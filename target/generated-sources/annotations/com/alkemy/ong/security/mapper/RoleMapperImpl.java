package com.alkemy.ong.security.mapper;

import com.alkemy.ong.security.dto.RoleGetDto;
import com.alkemy.ong.security.dto.RolePostDto;
import com.alkemy.ong.security.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:49:18-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role rolePostDtoToRole(RolePostDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( dto.getName() );
        role.setDescription( dto.getDescription() );

        return role;
    }

    @Override
    public RoleGetDto roleToRoleGetDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleGetDto roleGetDto = new RoleGetDto();

        roleGetDto.setName( role.getName() );
        roleGetDto.setDescription( role.getDescription() );

        return roleGetDto;
    }

    @Override
    public List<RoleGetDto> listRolesToListDtos(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleGetDto> list = new ArrayList<RoleGetDto>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToRoleGetDto( role ) );
        }

        return list;
    }
}
