package com.padwan.test.controller;

import com.padwan.test.dto.MentorDTO;
import com.padwan.test.exception.RegraCadastroException;
import com.padwan.test.model.Mentor;
import com.padwan.test.repository.MentorRepository;
import com.padwan.test.service.MentorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private MentorService mentorService;

    public MentorController(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar Mentor por ID")
    public ResponseEntity<Mentor> getMentorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(mentorRepository.findById(id)
                .orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(), 404)));
    }

    @GetMapping()
    @Operation(summary = "Buscar Mentor pelo nome!! (Usar Param na requisição)")
    public ResponseEntity<Mentor> getMentorNome(@PathParam("nome") String nome) {
        if (mentorRepository.findByNomeLike(nome) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(mentorRepository.findByNomeLike(nome));
    }


    @PostMapping
    @Operation(summary = "Criar um Mentor")
    public ResponseEntity<Mentor> save(@RequestBody MentorDTO mentorDTO){
        Mentor mentor = mentorService.save((mentorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mentorRepository.save(mentor));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um mentor :/ ")
    public void delete(@PathVariable Long id) {
        mentorRepository.findById(id).map(mentor -> {
            mentorRepository.delete(mentor);
            return mentor;
        }).orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(), 404));

    }

    @GetMapping("/lista")
    @Operation(summary = "Lista de mentores")
    public ResponseEntity<List<Mentor>> getMentorNome() {
        return ResponseEntity.ok().body(mentorRepository.findAll());
    }

    @GetMapping("/mentorDisc")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista de mentores e seus pupilos <3 ")
    public ResponseEntity<Map<String, List>> mentorDisc(){
        List<Mentor> result = mentorRepository.mentorAndAlunos();
        Map<String,List> map = null;
        if(result != null && !result.isEmpty()){
            map = new HashMap<>();
            for (Mentor object : result) {
                map.put("O mestre: "+ object.getNome()+" possui os seguintes discipulos: ", Collections.singletonList(object.getDiscipulo()));
            }
        }
        return ResponseEntity.ok().body(map);
    }

}
