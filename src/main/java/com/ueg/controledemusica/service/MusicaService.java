package com.ueg.controledemusica.service;

import com.ueg.controledemusica.model.Musica;
import com.ueg.controledemusica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public Musica getMusica(Long id){
        return musicaRepository.findByIdMusica(id);
    }

    public Musica inserir(Musica musica){
        if(!musicaRepository.existeNoArtista (musica.getTitulo(), musica.getArtista())){
            if(!(musica.getDuracao() < 0)){
                return musicaRepository.save(musica);
            }
            else{
                throw new IllegalStateException("Não é possível cadastrar uma música com menos de 0 segundos");
            }
        }
        else{
            throw new IllegalStateException("O artista " + musica.getArtista() + " já tem uma música com este nome!");
        }
    }

    public List<Musica> listarTudo(){
        return musicaRepository.findAll();
    }

    public Musica remover(Long id){
        Musica musica = getMusica(id);
        musicaRepository.delete(musica);
        return musica;
    }

    public Musica alterar(Long id, Musica musica){
        Musica musicaBD = getMusica(id);

        if(StringUtils.hasLength(musica.getTitulo()) && !musicaBD.getTitulo().equals(musica.getTitulo())) {
            if(!musicaRepository.existeNoArtista(musica.getTitulo(), musica.getArtista())){
                musicaBD.setTitulo(musica.getTitulo());
            }
            else{
                throw new IllegalStateException("O artista " + musica.getArtista() + " já tem outra música com este nome!");
            }
        }

        if(StringUtils.hasLength(musica.getArtista())){
            musicaBD.setArtista(musica.getArtista());
        }

        if(StringUtils.hasLength(musica.getCompositor())){
            musicaBD.setCompositor(musica.getCompositor());
        }

        if(musica.getDuracao() >= 0){
            musicaBD.setDuracao(musica.getDuracao());
        }
        else{
            throw new IllegalStateException("A música não pode ter menos de 0 segundos!");
        }

        musicaRepository.save(musicaBD);
        return musicaBD;
    }
}
