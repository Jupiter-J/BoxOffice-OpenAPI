package dev.movie.boxoffice.mainApi;

import dev.movie.boxoffice.mainApi.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto);
    List<UserDto> readAllUser();

}
