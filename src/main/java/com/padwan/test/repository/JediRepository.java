package com.padwan.test.repository;

import com.padwan.test.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JediRepository extends JpaRepository<Jedi,Long> {

    @Query(value="select * from jedi as j where j.midichlorians > 9000", nativeQuery=true)
    List<Jedi> maisDeNoveMil();

    @Query(value="select * from jedi as j", nativeQuery=true)
    List<Jedi> osJedis();

}
