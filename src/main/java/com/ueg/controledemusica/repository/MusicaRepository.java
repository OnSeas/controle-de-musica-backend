package com.ueg.controledemusica.repository;

import com.ueg.controledemusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    @Query(
            "SELECT CASE WHEN COUNT(m) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM  Musica m " +
            "WHERE (m.titulo = :titulo AND m.artista = :artista) "
    )
    Boolean existeNoArtista(@Param("titulo") String titulo, @Param("artista") String artista);

    Musica findByIdMusica(Long idMusica);
}
