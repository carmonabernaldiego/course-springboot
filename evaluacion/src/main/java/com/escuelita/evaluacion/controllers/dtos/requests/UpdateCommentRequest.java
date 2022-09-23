package com.escuelita.evaluacion.controllers.dtos.requests;

public class UpdateCommentRequest {
    private String comment;

    private String email;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
