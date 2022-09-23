package com.escuelita.practica.repositories;

import com.escuelita.practica.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
