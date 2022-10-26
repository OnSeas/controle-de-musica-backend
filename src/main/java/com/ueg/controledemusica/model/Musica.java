package com.ueg.controledemusica.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "tbl_musica")
public @Data class Musica {

    @Id
    private Long idMusica;

    @Column(name = "cln_titulo", length = 40, nullable = false)
    private String titulo;

    @Column(name = "cln_duracao", nullable = false)
    private Integer duracao;

    @Column(name = "cln_artista", length = 40,nullable = false)
    private String artista;

    @Column(name = "cln_compositor", length = 40, nullable = false)
    private String compositor;

    @Column(name = "cln_favorito")
    private Boolean favorito;
}
