package com.alkemy.ong.service;


import com.alkemy.ong.dto.ActivityDTO;

import java.util.List;

public interface IActivityService {
    ActivityDTO save (ActivityDTO dto);

    List<ActivityDTO> getAll();

    ActivityDTO getId(Long id);

    ActivityDTO update (Long id, ActivityDTO dto);
}
