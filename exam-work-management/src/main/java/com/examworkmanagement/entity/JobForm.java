package com.examworkmanagement.entity;

import org.springframework.web.multipart.MultipartFile;

public class JobForm {
    private Long id;
    private String name;
    private String description;
    private int completedTime;
    private MultipartFile image;
    private JobStatus status;

    public JobForm(Long id, String name, String description, int completedTime, MultipartFile image, JobStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completedTime = completedTime;
        this.image = image;
        this.status = status;
    }

    public JobForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(int completedTime) {
        this.completedTime = completedTime;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
}
