package com.padwan.test.service;

import com.padwan.test.dto.MentorDTO;
import com.padwan.test.model.Mentor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorService {

    public Mentor save(MentorDTO dto) {
        Mentor mentor = new Mentor();
        mentor.getId();
        mentor.setNome(dto.getNome());
        mentor.setMidichlorians(dto.getMidichlorians());
        return mentor;
    }
}
