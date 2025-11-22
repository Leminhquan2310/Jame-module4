package com.examworkmanagement.service.Impl;

import com.examworkmanagement.entity.PriorityLevel;
import com.examworkmanagement.repository.PriorityLevelRepository;
import com.examworkmanagement.service.PriorityLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityLevelServiceImpl implements PriorityLevelService {
    @Autowired
    private PriorityLevelRepository priorityLevelRepository;

    @Override
    public List<PriorityLevel> findAll() {
        return priorityLevelRepository.findAll();
    }
}
