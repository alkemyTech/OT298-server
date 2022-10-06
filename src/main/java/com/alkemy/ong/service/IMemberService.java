package com.alkemy.ong.service;

import com.alkemy.ong.dto.MemberDTO;

public interface IMemberService {

    MemberDTO save(MemberDTO dto);

    MemberDTO update(Long id,MemberDTO dto);
    
    MemberDTO delete(Long id);
}
