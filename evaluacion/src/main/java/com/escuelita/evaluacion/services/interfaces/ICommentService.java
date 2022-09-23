package com.escuelita.evaluacion.services.interfaces;

import com.escuelita.evaluacion.controllers.dtos.requests.CreateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.requests.UpdateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.responses.GetCommentResponse;

import java.util.List;

public interface ICommentService {
    GetCommentResponse get(Long id);

    List<GetCommentResponse> list();

    void delete(Long id);

    GetCommentResponse create(CreateCommentRequest request);

    GetCommentResponse update(Long id, UpdateCommentRequest request);
}
