package kr.co.local_pick.local_pick.controller;

import kr.co.local_pick.local_pick.dto.MemberResponseDto;
import kr.co.local_pick.local_pick.dto.SignUpRequestDto;
import kr.co.local_pick.local_pick.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final MemberService memberService;

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<MemberResponseDto> signup(SignUpRequestDto signUpRequestDto) {
        memberService.signup(signUpRequestDto);
        return ResponseEntity.ok().body(new MemberResponseDto());
    }
}
