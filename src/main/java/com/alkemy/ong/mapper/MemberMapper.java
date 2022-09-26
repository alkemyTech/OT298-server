package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.model.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberDTOToMember(MemberDTO memberDTO);

    MemberDTO memberToMemberDTO(Member member);

}
