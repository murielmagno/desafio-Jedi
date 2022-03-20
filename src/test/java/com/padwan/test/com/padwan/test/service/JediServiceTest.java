package com.padwan.test.com.padwan.test.service;

import com.padwan.test.AppConfigTest;
import com.padwan.test.model.Jedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.MentorRepository;
import com.padwan.test.service.JediSevice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@DisplayName("JediServiceTest")
public class JediServiceTest extends AppConfigTest {

    @MockBean
    private JediRepository jediRepository;

    @MockBean
    private MentorRepository mentorRepository;

    @Autowired
    private JediSevice jediSevice;

    @Test
    @DisplayName("Encontra um Jedi")
    public void deveEncontrarJedi(){
        Long idJediMock = 1L;
        Optional<Jedi> jedi = Optional.of(criarJedi());
        Mockito.when(jediRepository.findById(ArgumentMatchers.eq(idJediMock))).thenReturn(jedi);
        jediSevice.findById(idJediMock);
    }

    private Jedi criarJedi() {
        Jedi jedi = Mockito.mock(Jedi.class);
        return jedi;
    }
}
