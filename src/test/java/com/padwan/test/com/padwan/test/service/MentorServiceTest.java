package com.padwan.test.com.padwan.test.service;

import com.padwan.test.AppConfigTest;
import com.padwan.test.dto.MentorDTO;
import com.padwan.test.model.Mentor;
import com.padwan.test.repository.MentorRepository;
import com.padwan.test.service.MentorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("MentorServiceTest")
public class MentorServiceTest extends AppConfigTest {

    @Autowired
    MentorService mentorService;

    @MockBean
    private MentorRepository mentorRepository;



    @Test
    public void salvarMentor(){
        Mentor mentor = criarMentor();
        Mockito.when(mentorRepository.save(mentor)).thenReturn(mentor);
    }

    private Mentor criarMentor() {
        MentorDTO mentorDTO =Mockito.mock(MentorDTO.class);
        Mentor mentor = mentorService.save(mentorDTO);
        mentor.getId();
        mentor.setNome(mentorDTO.getNome());
        mentor.setMidichlorians(mentorDTO.getMidichlorians());
        return mentor;
    }
}
