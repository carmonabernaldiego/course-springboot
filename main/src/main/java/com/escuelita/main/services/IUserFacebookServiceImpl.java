package com.escuelita.main.services;

import com.escuelita.main.controllers.dtos.requests.CreateUserRequest;
import com.escuelita.main.controllers.dtos.requests.UpdateUserRequest;
import com.escuelita.main.controllers.dtos.responses.GetUserResponse;
import com.escuelita.main.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("facebook")
public class IUserFacebookServiceImpl implements IUserService {
    @Override
    public GetUserResponse get(Long id) {
        GetUserResponse response = new GetUserResponse();
        response.setId(12312514L);
        response.setEmail("fromfacebook@facebook.com");
        return response;
    }

    @Override
    public List<GetUserResponse> list() {
        return Collections.emptyList();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public GetUserResponse create(CreateUserRequest request) {
        return null;
    }

    @Override
    public GetUserResponse update(Long id, UpdateUserRequest request) {
        return null;
    }
}
