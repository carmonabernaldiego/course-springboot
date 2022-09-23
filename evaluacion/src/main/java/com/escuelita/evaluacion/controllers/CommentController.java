package com.escuelita.evaluacion.controllers;

import com.escuelita.evaluacion.controllers.dtos.requests.CreateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.requests.UpdateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.responses.GetCommentResponse;
import com.escuelita.evaluacion.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    @Qualifier("company")
    private ICommentService service;

    @GetMapping
    public List<GetCommentResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public GetCommentResponse create(@RequestBody CreateCommentRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public GetCommentResponse update(@PathVariable Long id, @RequestBody UpdateCommentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}