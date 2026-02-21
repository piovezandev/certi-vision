package br.com.certvision.domain.mapper;

import br.com.certvision.domain.model.User;
import br.com.certvision.domain.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse entityToResponse(User user);
}
