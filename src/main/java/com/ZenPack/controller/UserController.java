package com.ZenPack.controller;
import com.ZenPack.common.APIResponse;
import com.ZenPack.dto.LoginRequestDto;
import com.ZenPack.dto.SignUpRequestDto;
import com.ZenPack.service.Services.UserService;
import com.ZenPack.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        APIResponse apiResponse = service.signUp(signUpRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDto loginRequestDto){
        APIResponse apiResponse = service.login(loginRequestDto);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @GetMapping("/privateApi")
    public ResponseEntity<APIResponse> privateApi(@RequestHeader(value = "authorization", defaultValue = "") String auth) throws Exception {
        APIResponse apiResponse =new APIResponse();

        jwtUtils.verify(auth);

        apiResponse.setData("this is private api");
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }



}
