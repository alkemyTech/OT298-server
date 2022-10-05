package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.mapper.MemberMapper;
import com.alkemy.ong.model.Member;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    public MemberDTO save(MemberDTO dto){
            Member member = memberMapper.memberDTOToMember(dto);
            Member savedMember = memberRepository.save(member);
            return memberMapper.memberToMemberDTO(savedMember);
    }
    public List<MemberDTO> getAll(){
        List<Member> list = memberRepository.findAll();
        if (list.isEmpty()){
            throw new ResourceNotFoundException("member.empty_list");
        }
        return memberMapper.toDtoList(list);
    }
}
