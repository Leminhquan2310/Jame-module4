package com.examworkmanagement.service;

import com.examworkmanagement.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> finAll();

    public List<Job> searchJobs(Integer status, String name, Integer minTime, Integer maxTime);

    Job findById(Long id);

    void delete(Long id);

    void update(Job job);

    void create(Job job);
}
