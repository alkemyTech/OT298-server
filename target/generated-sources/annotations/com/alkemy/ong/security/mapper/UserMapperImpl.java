package com.alkemy.ong.security.mapper;

import com.alkemy.ong.dto.AuxUserGetDto;
import com.alkemy.ong.security.dto.RoleGetDto;
import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.model.Role;
import com.alkemy.ong.security.model.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserPostDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setEmail( dto.getEmail() );
        user.setPhoto( dto.getPhoto() );

        return user;
    }

    @Override
    public UserGetDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetDto userGetDto = new UserGetDto();

        userGetDto.setFirstName( user.getFirstName() );
        userGetDto.setEmail( user.getEmail() );

        return userGetDto;
    }

    @Override
    public List<UserGetDto> listUsersToListDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserGetDto> list = new ArrayList<UserGetDto>( users.size() );
        for ( User user : users ) {
            list.add( userToUserDto( user ) );
        }

        return list;
    }

    @Override
    public AuxUserGetDto toAuxDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuxUserGetDto auxUserGetDto = new AuxUserGetDto();

        auxUserGetDto.setFirstName( user.getFirstName() );
        auxUserGetDto.setLastName( user.getLastName() );
        auxUserGetDto.setEmail( user.getEmail() );
        auxUserGetDto.setRoles( roleSetToRoleGetDtoSet( user.getRoles() ) );

        return auxUserGetDto;
    }

    protected RoleGetDto roleToRoleGetDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleGetDto roleGetDto = new RoleGetDto();

        roleGetDto.setName( role.getName() );
        roleGetDto.setDescription( role.getDescription() );

        return roleGetDto;
    }

    protected Set<RoleGetDto> roleSetToRoleGetDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleGetDto> set1 = new HashSet<RoleGetDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleGetDto( role ) );
        }

        return set1;
    }
}
