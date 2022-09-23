package com.escuelita.practica.services;

import com.escuelita.practica.controllers.dtos.requests.CreateSubjectRequest;
import com.escuelita.practica.controllers.dtos.requests.UpdateSubjectRequest;
import com.escuelita.practica.controllers.dtos.responses.GetSubjectResponse;
import com.escuelita.practica.entities.Subject;
import com.escuelita.practica.repositories.SubjectRepository;
import com.escuelita.practica.services.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("company")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository repository;

    @Override
    public List<GetSubjectResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public GetSubjectResponse get(Long id) {
        return from(id);
    }

    @Override
    public GetSubjectResponse create(CreateSubjectRequest request) {
        Subject subject = from(request);
        return from(repository.save(subject));
    }

    @Override
    public GetSubjectResponse update(Long id, UpdateSubjectRequest request) {
        Subject subject = repository.findById(id).orElseThrow(() -> new RuntimeException("The subject does not exist"));
        subject = update(subject, request);
        return from(subject);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private GetSubjectResponse from(Subject subject) {
        GetSubjectResponse response = new GetSubjectResponse();
        response.setId(subject.getId());
        response.setName(subject.getName());
        response.setDescription(subject.getDescription());
        response.setSemester(subject.getSemester());
        return response;
    }

    private GetSubjectResponse from(Long id) {
        return repository
                .findById(id)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("The subject does not exist"));
    }

    private Subject from(CreateSubjectRequest request) {
        Subject subject = new Subject();
        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        subject.setSemester(request.getSemester());
        return subject;
    }

    private Subject update(Subject subject, UpdateSubjectRequest request) {
        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        subject.setSemester(request.getSemester());
        return repository.save(subject);
    }
}