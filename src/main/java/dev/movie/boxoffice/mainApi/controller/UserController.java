package dev.movie.boxoffice.mainApi.controller;

import dev.movie.boxoffice.mainApi.UserServiceImpl;
import dev.movie.boxoffice.mainApi.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServiceImpl memberService;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
        UserDto result = this.memberService.createUser(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> readAllUser(){
        List<UserDto> memberList = this.memberService.readAllUser();
        if (memberList == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(memberList);
    }

}
