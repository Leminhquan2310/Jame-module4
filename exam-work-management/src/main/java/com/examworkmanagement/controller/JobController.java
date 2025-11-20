package com.examworkmanagement.controller;

import com.examworkmanagement.entity.Job;
import com.examworkmanagement.entity.JobForm;
import com.examworkmanagement.entity.JobStatus;
import com.examworkmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.examworkmanagement.repository")
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("list")
    public ModelAndView showList(
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minTime,
            @RequestParam(required = false) Integer maxTime
    ) {
        List<Job> jobs = jobService.searchJobs(status, name, minTime, maxTime);
        ModelAndView view = new ModelAndView("jobs-list");

        view.addObject("jobs", jobs);
        view.addObject("status", status);
        view.addObject("name", name);
        view.addObject("minTime", minTime);
        view.addObject("maxTime", maxTime);

        return view;
    }

    @GetMapping("create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("jobs-create");
        modelAndView.addObject("jobForm", new JobForm());
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("jobs-edit");
        Job job = jobService.findById(id);
        JobForm jobForm = new JobForm();

        jobForm.setId(job.getId());
        jobForm.setName(job.getName());
        jobForm.setDescription(job.getDescription());
        jobForm.setCompletedTime(job.getCompletedTime());
        jobForm.setStatus(JobStatus.fromInt(job.getStatus()));

        modelAndView.addObject("jobForm", jobForm);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("jobs-detail");
        Job job = jobService.findById(id);
        modelAndView.addObject("job", job);
        return modelAndView;
    }

    @PostMapping("create")
    public String createJob(@ModelAttribute JobForm jobForm) {
        MultipartFile multipartFile = jobForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(jobForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Job job = new Job(jobForm.getId(), jobForm.getName(), jobForm.getDescription(), jobForm.getCompletedTime(), fileName, jobForm.getStatus().getId());
        jobService.create(job);
        return "redirect:/jobs/list";
    }

    @PostMapping("save")
    public String saveJob(@ModelAttribute JobForm jobForm) {
        String fileName;
        if (jobForm.getImage().isEmpty()) {
            Job job = jobService.findById(jobForm.getId());
            fileName = job.getImage();
        } else {
            MultipartFile multipartFile = jobForm.getImage();
            fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(jobForm.getImage().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Job job = new Job(jobForm.getId(), jobForm.getName(), jobForm.getDescription(), jobForm.getCompletedTime(), fileName, jobForm.getStatus().getId());
        jobService.create(job);
        return "redirect:/jobs/list";
    }

    @PostMapping("delete/{id}")
    public String deleteJob(@PathVariable("id") Long id) {
        jobService.delete(id);
        return "redirect:/jobs/list";
    }
}
