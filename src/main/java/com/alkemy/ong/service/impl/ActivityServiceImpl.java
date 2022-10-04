
package com.alkemy.ong.service.impl;


import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.mapper.ActivityMapper;
import com.alkemy.ong.model.Activity;
import com.alkemy.ong.repository.ActivityRepository;
import com.alkemy.ong.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;

    @Transactional
    @Override
    public ActivityDTO save(ActivityDTO dto) {
        Activity activity = activityMapper.activityDTOToActivity(dto);
        Activity savedActivity = activityRepository.save(activity);
        return activityMapper.activityToActivityDTO(savedActivity);
    }

    @Override
    public List<ActivityDTO> getAll(){
        List<Activity> activityList = activityRepository.findAll();
        List<ActivityDTO> dtoList = new ArrayList<>();
        for (Activity activity : activityList){
            ActivityDTO dto = activityMapper.activityToActivityDTO(activity);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
