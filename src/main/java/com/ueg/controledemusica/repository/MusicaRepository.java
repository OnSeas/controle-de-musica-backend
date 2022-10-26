package com.ueg.controledemusica.repository;

import com.ueg.controledemusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Musica findByIdMusica(Long idMusica);
}
