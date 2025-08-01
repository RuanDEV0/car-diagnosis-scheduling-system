package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import ruandev.com.systemspringboot.domain.User;
import ruandev.com.systemspringboot.dto.user.UserPostDto;
import ruandev.com.systemspringboot.dto.user.UserPutDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
     User toClient(UserPostDto userPostDto);
     User toClient(UserPutDto userPutDto);
}
