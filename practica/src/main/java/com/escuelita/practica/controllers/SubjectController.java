package com.escuelita.practica.controllers;

import com.escuelita.practica.controllers.dtos.requests.CreateSubjectRequest;
import com.escuelita.practica.controllers.dtos.requests.UpdateSubjectRequest;
import com.escuelita.practica.controllers.dtos.responses.GetSubjectResponse;
import com.escuelita.practica.services.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    @Qualifier("company")
    private SubjectService service;

    @GetMapping
    public List<GetSubjectResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public GetSubjectResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public GetSubjectResponse create(@RequestBody CreateSubjectRequest request) {
        return service.create(request);
    }

    @PutMapping("{id}")
    public GetSubjectResponse update(@PathVariable Long id, @RequestBody UpdateSubjectRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}