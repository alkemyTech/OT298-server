package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.model.Member;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberDTOToMember(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( memberDTO.getId() );
        member.setName( memberDTO.getName() );
        member.setFacebookUrl( memberDTO.getFacebookUrl() );
        member.setInstagramUrl( memberDTO.getInstagramUrl() );
        member.setLinkedinUrl( memberDTO.getLinkedinUrl() );
        member.setImage( memberDTO.getImage() );
        member.setDescription( memberDTO.getDescription() );

        return member;
    }

    @Override
    public MemberDTO memberToMemberDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId( member.getId() );
        memberDTO.setName( member.getName() );
        memberDTO.setFacebookUrl( member.getFacebookUrl() );
        memberDTO.setInstagramUrl( member.getInstagramUrl() );
        memberDTO.setLinkedinUrl( member.getLinkedinUrl() );
        memberDTO.setImage( member.getImage() );
        memberDTO.setDescription( member.getDescription() );

        return memberDTO;
    }
}
