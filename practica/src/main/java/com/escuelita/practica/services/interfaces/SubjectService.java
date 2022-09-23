package com.escuelita.practica.services.interfaces;

import com.escuelita.practica.controllers.dtos.requests.CreateSubjectRequest;
import com.escuelita.practica.controllers.dtos.requests.UpdateSubjectRequest;
import com.escuelita.practica.controllers.dtos.responses.GetSubjectResponse;

import java.util.List;

public interface SubjectService {
    List<GetSubjectResponse> list();

    GetSubjectResponse get(Long id);

    GetSubjectResponse create(CreateSubjectRequest request);

    GetSubjectResponse update(Long id, UpdateSubjectRequest request);

    void delete(Long id);
}