package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.exception.EntityNotSavedException;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.mapper.MemberMapper;
import com.alkemy.ong.model.Member;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MessageSource message;

    @Transactional
    public MemberDTO save(MemberDTO dto) {
        Member member = memberMapper.memberDTOToMember(dto);
        Member savedMember = memberRepository.save(member);
        return memberMapper.memberToMemberDTO(savedMember);
    }

    @Override
    public MemberDTO update(Long id, MemberDTO dto) {
            Member member = getMemberEntityById(id);

        try {

            verifiedNullData(dto, member);


            memberRepository.save(member);

        } catch (EntityNotSavedException ense) {

            throw new EntityNotSavedException(message.getMessage("member.notSaved", null, Locale.US));

        }


        return memberMapper.memberToMemberDTO(member);
    }

    /*Comprueba que los datos que se van a actualizar no pisen a los que no se actualizan,si no, los va retorna nulos
     o no actualiza nada en la base de datos*/

    private static void verifiedNullData(MemberDTO dto, Member member) {
        if(!StringUtils.hasLength(dto.getName())){
            member.setName(member.getName());
        }else{
            member.setName(dto.getName());
        }


        if(!StringUtils.hasLength(dto.getImage())){
            member.setImage(member.getImage());
        }else{
            member.setImage(dto.getImage());
        }

        if(!StringUtils.hasLength(dto.getDescription())){
            member.setDescription(member.getDescription());
        }else{
            member.setDescription(dto.getDescription());
        }

        if(!StringUtils.hasLength(dto.getFacebookUrl())){
            member.setFacebookUrl(member.getFacebookUrl());
        }else{
            member.setFacebookUrl(dto.getFacebookUrl());
        }

        if(!StringUtils.hasLength(dto.getInstagramUrl())){
            member.setInstagramUrl(member.getInstagramUrl());
        }else{
            member.setInstagramUrl(dto.getInstagramUrl());
        }

        if(!StringUtils.hasLength(dto.getLinkedinUrl())){
            member.setLinkedinUrl(member.getLinkedinUrl());
        }else{
            member.setLinkedinUrl(dto.getLinkedinUrl());
        }
    }

    public MemberDTO delete(Long id){
        
        if (!memberRepository.existsById(id)){
            throw new ResourceNotFoundException(message.getMessage("member.notFound", null, Locale.US));
        }
        Member member = memberRepository.getById(id);
        memberRepository.deleteById(id);
        
        return memberMapper.memberToMemberDTO(member);
    }
    
    private Member getMemberEntityById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new EntityNotFoundException(message.getMessage("member.notFound", null, Locale.US));
        }

        return member.get();
    }

}
