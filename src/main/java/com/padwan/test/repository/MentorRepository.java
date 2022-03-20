package com.padwan.test.repository;

import com.padwan.test.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor,Long> {
    Mentor findByNomeLike(String nome);


    @Query(value="select * from jedi as j where j.status = 'MESTRE_JEDI'", nativeQuery=true)
    List<Mentor> mentorAndAlunos();
}
