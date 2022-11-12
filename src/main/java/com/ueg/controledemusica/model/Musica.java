package com.ueg.controledemusica.model;

import com.ueg.controledemusica.enums.TipoEstilo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "tbl_musica")
public @Data class Musica {

    @Id
    @SequenceGenerator(
            name = "musica_sequence",
            sequenceName = "musica_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "musica_sequence"
    )
    private Long idMusica;

    @Column(name = "cln_titulo", length = 40, nullable = false)
    private String titulo;

    @Column(name = "cln_estilo_musical", nullable = false)
    private TipoEstilo estiloMusical;

    @Column(name = "cln_duracao", nullable = false)
    private Integer duracao;

    @Column(name = "cln_artista", length = 40,nullable = false)
    private String artista;

    @Column(name = "cln_compositor", length = 40, nullable = false)
    private String compositor;

    @Column(name = "cln_favorito")
    private Boolean favorito;
}
