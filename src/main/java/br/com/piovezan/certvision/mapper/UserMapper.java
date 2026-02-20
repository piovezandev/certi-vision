package br.com.piovezan.certvision.mapper;

import br.com.piovezan.certvision.model.User;
import br.com.piovezan.certvision.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse entityToResponse(User user);
}
