package dev.movie.boxoffice.mainApi;

import dev.movie.boxoffice.mainApi.dto.UserDto;
import dev.movie.boxoffice.mainApi.entity.User;
import dev.movie.boxoffice.mainApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository memberRepository;

    @Override
    public UserDto createUser(UserDto dto) {
        User member = User.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .build();
        User result = memberRepository.save(member);

        UserDto memberDto = UserDto.builder()
                .userSeq(result.getUserSeq())
                .userId(result.getUserId())
                .password(result.getPassword())
                .build();
        return memberDto;
    }

    @Override
    @Transactional
    public List<UserDto> readAllUser() {
        return memberRepository.findAll().stream()
                .map(member -> UserDto.builder()
                        .userSeq(member.getUserSeq())
                        .userId(member.getUserId())
                        .password(member.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
