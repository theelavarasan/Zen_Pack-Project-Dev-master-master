package com.ZenPack.service.Services;

import com.ZenPack.common.APIResponse;
import com.ZenPack.dto.LoginRequestDto;
import com.ZenPack.dto.SignUpRequestDto;
import com.ZenPack.model.User;
import com.ZenPack.repository.UserRepository;
import com.ZenPack.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse signUp(SignUpRequestDto signUpRequestDto) {
        APIResponse apiResponse = new APIResponse();
        User userEntity = new User();
        userEntity.setUserName(signUpRequestDto.getUserName());
        userEntity.setPassword(signUpRequestDto.getPassword());
        userEntity.setEmailId(signUpRequestDto.getEmailId());

        userEntity =repository.save(userEntity);

        String token = jwtUtils.generateJwt(userEntity);

        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);

        apiResponse.setData(data);

        return apiResponse;
    }

    public APIResponse login(LoginRequestDto loginRequestDto) {
        APIResponse apiResponse = new APIResponse();

        User user = repository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDto.getEmailId(),loginRequestDto.getPassword());

        if(user == null){
            apiResponse.setData("User login failed");
        }
        String token = jwtUtils.generateJwt(user);

        Map<String,Object> data =new HashMap<>();
        data.put("accesToken",token);

        apiResponse.setData(data);
        return apiResponse;
    }
}
