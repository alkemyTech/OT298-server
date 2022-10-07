package com.alkemy.ong.service;


import com.alkemy.ong.dto.ActivityDTO;

import java.util.List;

public interface IActivityService {
    ActivityDTO save (ActivityDTO dto);

    List<ActivityDTO> getAll();

<<<<<<< HEAD
=======
    ActivityDTO getId(Long id);

>>>>>>> 67dd049ad8eb1e48236022154ba401827a39e6f9
    ActivityDTO update (Long id, ActivityDTO dto);
}
