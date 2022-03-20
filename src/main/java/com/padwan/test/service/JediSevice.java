package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.exception.RegraCadastroException;
import com.padwan.test.model.Jedi;
import com.padwan.test.model.Mentor;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JediSevice {

    @Autowired
    private JediRepository jediRepository;

    @Autowired
    private MentorRepository mentorRepository;

    public Jedi findById(Long id) {
        return jediRepository.findById(id).orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(),404));
    }

    public Jedi save(JediDTO dto) {
        Long idMentor = dto.getMentor_id();
        Mentor mentor = mentorRepository.findById(idMentor).orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(), 404));
        Jedi jedi = new Jedi();
        jedi.getId();
        jedi.setMentor(mentor);
        jedi.setNome(dto.getNome());
        jedi.setStatus(dto.getStatus());
        jedi.setMidichlorians(dto.getMidichlorians());
        return jedi;
    }
}
