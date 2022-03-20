package com.padwan.test.controller;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.exception.RegraCadastroException;
import com.padwan.test.model.Jedi;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.service.JediSevice;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jedi")
public class JediController {

    @Autowired
    private JediSevice jediSevice;
    @Autowired
    private JediRepository jediRepository;

    @GetMapping("{id}")
    @Operation(summary = "Buscar Jedi pelo id")
    public ResponseEntity<Jedi> getJediById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(jediRepository.findById(id)
                .orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(), 404)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar um Jedi")
    public ResponseEntity<Jedi> save(@RequestBody JediDTO dto){
        Jedi jedi = jediSevice.save(dto);
        return ResponseEntity.status(201).body((jediRepository.save(jedi)));
    }


    @GetMapping("/jedis")
    @Operation(summary = "Buscar todos os Jedis cadastrados")
    public ResponseEntity<List<Jedi>> jedis() {
        return ResponseEntity.ok().body(jediRepository.osJedis());
    }

    @GetMapping("/noveMil")
    @Operation(summary = "Jedis com o poder MAIS DE NOVE MIL!!!")
    public ResponseEntity<List<Jedi>> maisDeNoveMil() {
        return ResponseEntity.ok().body(jediRepository.maisDeNoveMil());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um jedi :/ ")
    public void delete(@PathVariable Long id) {
        jediRepository.findById(id).map(jedi -> {
            jediRepository.delete(jedi);
            return jedi;
        }).orElseThrow(() -> new RegraCadastroException(ResponseEntity.notFound().build(), 404));
    }
}
