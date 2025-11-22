package com.examworkmanagement.entity;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

public class JobForm {
    private Long id;

    @NotEmpty(message = "Tên không được để trống!")
    @Size(max = 20, message = "Tên không được lớn hơn 20 kí tự!")
    private String name;


    @NotEmpty(message = "Mô tả không được để trống!")
    @Size(max = 200, message = "Mô tả không được lớn hơn 200 kí tự!")
    private String description;

    @NotNull(message = "Không được để trống!")
    @Min(value = 1, message = "Thời gian hoàn thành phải lớn hơn 0")
    private Integer completedTime;

    private MultipartFile image;
    private JobStatus status;
    private PriorityLevel priorityLevel;

    public JobForm(Long id, String name, String description, Integer completedTime, MultipartFile image, JobStatus status, PriorityLevel priorityLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completedTime = completedTime;
        this.image = image;
        this.status = status;
        this.priorityLevel = priorityLevel;
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

    public Integer getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Integer completedTime) {
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

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
