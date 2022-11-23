package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper
public interface UserMapper {

    // map from entity to dto
    @Mapping(source = "firstName", target = "fullName")
    UserDTO mapToDTO(User entity);
   List<UserDTO> map(List<User> enList);


    //map from dto to entity
    @Mapping(source = "fullName", target = "firstName")
    User mapToEntity(UserDTO dto);

    User unMap(UserDTO userDTO, @MappingTarget   User user);
   List<User> unMap(List<UserDTO> userDTOS);
}
