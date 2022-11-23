package net.javaguides.springboot.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapToDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setFullName( entity.getFirstName() );
        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );

        return userDTO;
    }

    @Override
    public List<UserDTO> map(List<User> enList) {
        if ( enList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( enList.size() );
        for ( User user : enList ) {
            list.add( mapToDTO( user ) );
        }

        return list;
    }

    @Override
    public User mapToEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( dto.getFullName() );
        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );

        return user;
    }

    @Override
    public List<User> unMap(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( mapToEntity( userDTO ) );
        }

        return list;
    }
}
