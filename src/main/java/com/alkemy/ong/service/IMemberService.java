package com.alkemy.ong.service;

import com.alkemy.ong.dto.MemberDTO;
import java.util.List;

public interface IMemberService {

    MemberDTO save(MemberDTO dto);
    
    List<MemberDTO> getAll();
}
