package com.alkemy.ong.mapper;

import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdated", ignore = true)
    User userPostDtoToUser (UserPostDto dto);

    @Mapping(target = "nameRole", ignore = true)
    UserGetDto userToUserDto (User user);

}
