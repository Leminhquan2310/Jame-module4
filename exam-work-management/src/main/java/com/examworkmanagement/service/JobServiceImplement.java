package com.examworkmanagement.service;

import com.examworkmanagement.entity.Job;
import com.examworkmanagement.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class JobServiceImplement implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> finAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> searchJobs(Integer status, String name, Integer minTime, Integer maxTime) {
        return jobRepository.search(status, name, minTime, maxTime);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Job job = findById(id);
        if (job == null) return;

        if (job.getImage() != null && !job.getImage().isEmpty()) {
            // Lấy đường dẫn tuyệt đối
            String uploadDir = "D:\\My file\\CodeGym\\Module_4\\Jame\\exam-work-management\\src\\main\\webapp\\uploads\\";
            Path path = Paths.get(uploadDir, job.getImage());
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        jobRepository.delete(job);
    }

    @Override
    public void update(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void create(Job job) {
        jobRepository.save(job);
    }
}
