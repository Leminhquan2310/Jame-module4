package com.examworkmanagement.entity;

public enum JobStatus {
    DOING(0, "Đang làm"),
    COMPLETED(1, "Đã xong");

    private int id;
    private String label;

    JobStatus() {
    }

    JobStatus(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static JobStatus fromInt(int id) {
        for (JobStatus s : values()) {
            if (s.id == id) return s;
        }
        return null; // hoặc default
    }
}
