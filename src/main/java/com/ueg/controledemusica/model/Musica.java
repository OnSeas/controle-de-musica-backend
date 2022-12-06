package com.ueg.controledemusica.model;

import com.ueg.controledemusica.enums.TipoEstilo;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "tbl_musica")
public class Musica {

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

    public Long getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Long idMusica) {
        this.idMusica = idMusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoEstilo getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(TipoEstilo estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
}
