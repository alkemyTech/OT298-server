package com.alkemy.ong.service;

import com.alkemy.ong.dto.SlidesDTO;
import java.util.List;
import java.util.LinkedList;

public interface ISlidesService {
    SlidesDTO delete(Long id);
    SlidesDTO save(SlidesDTO slidesDTO);
    LinkedList<SlidesDTO> listSlides(LinkedList<SlidesDTO> slidesDTOlist);
    List<SlidesDTO> getAllSlides();
}
