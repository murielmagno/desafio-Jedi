package com.padwan.test.com.padwan.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padwan.test.AppConfigTest;
import com.padwan.test.controller.JediController;
import com.padwan.test.controller.MentorController;
import com.padwan.test.dto.MentorDTO;
import com.padwan.test.model.Jedi;
import com.padwan.test.model.Mentor;
import com.padwan.test.model.Status;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.service.MentorService;
import org.aspectj.lang.annotation.After;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@DisplayName("JediControllerTest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JediControllerTest extends AppConfigTest {

    @Autowired
    private JediController jediController;

    @MockBean
    private JediRepository jediRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void listaDeJedis() throws Exception {
        List<Jedi> jedis = new ArrayList<>();
        jedis.add(jediRepository.save(criarJedi()));
        Mockito.when(jediRepository.save(criarJedi())).thenReturn(jedis.get(0));
        this.mockMvc.perform(get("/jedi/jedis")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postCriarMentor() throws Exception {

        Map<String,Object> body = new HashMap<>();
        body.put("nome","Ges");
        body.put("midichlorians",2345467);
        String jediAsJson = new ObjectMapper().writeValueAsString(body);
        mockMvc.perform(post("/mentor").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(jediAsJson)).andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void postCriarMentorJedi() throws Exception {

        Map<String,Object> body = new HashMap<>();
        body.put("nome","new");
        body.put("status",1);
        body.put("mentor_id",1);
        body.put("midichlorians",65456);
        String jediAsJson = new ObjectMapper().writeValueAsString(body);
        mockMvc.perform(post("/jedi").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(jediAsJson)).andExpect(MockMvcResultMatchers.status().isCreated());

    }

    private Jedi criarJedi() {
        Jedi jedi = Mockito.mock(Jedi.class);
        return jedi;
    }
}
