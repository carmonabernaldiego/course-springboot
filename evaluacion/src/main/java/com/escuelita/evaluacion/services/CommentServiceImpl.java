package com.escuelita.evaluacion.services.interfaces;

import com.escuelita.evaluacion.controllers.dtos.requests.CreateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.requests.UpdateCommentRequest;
import com.escuelita.evaluacion.controllers.dtos.responses.GetCommentResponse;
import com.escuelita.evaluacion.entities.Comment;
import com.escuelita.evaluacion.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("company")
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository repository;

    @Override
    public GetCommentResponse get(Long id) { return from(id); }

    @Override
    public List<GetCommentResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) { repository.deleteById(id); }

    @Override
    public GetCommentResponse create(CreateCommentRequest request) {
        Comment comment = from(request);
        return from(repository.save(comment));
    }

    @Override
    public GetCommentResponse update(Long id, UpdateCommentRequest request) {
        Comment comment = repository.findById(id).orElseThrow(() -> new RuntimeException("The user does not exist"));
        comment = update(comment, request);
        return from(comment);
    }

    private Comment update(Comment comment, UpdateCommentRequest request) {
        comment.setComment(request.getComment());
        comment.setEmail(request.getEmail());
        return repository.save(comment);
    }

    private Comment from(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setEmail(request.getEmail());
        return comment;
    }

    private GetCommentResponse from(Comment comment) {
        GetCommentResponse response = new GetCommentResponse();
        response.setId(comment.getId());
        response.setComment(comment.getComment());
        return response;
    }

    private GetCommentResponse from(Long idComment) {
        return repository.findById(idComment)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }
}
