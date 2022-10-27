package com.ueg.controledemusica.controller;

import com.ueg.controledemusica.model.Musica;
import com.ueg.controledemusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/musica")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;

    @GetMapping(path = "{idMusica}")
    public Musica getMusica(@PathVariable("idMusica") Long id){
        return musicaService.getMusica(id);
    }

    @GetMapping(path = "")
    public List<Musica> listarTudo(){
        List<Musica> musicas = new ArrayList<Musica>();
        musicas = musicaService.listarTudo();
        return musicas;
    }

    @PostMapping
    public Musica incluir(@RequestBody Musica musica){
        return musicaService.inserir(musica);
    }

    @DeleteMapping(path = "{idMusica}")
    public Musica remover(@PathVariable("idMusica") Long id){
        return musicaService.remover(id);
    }

    @PatchMapping(path = "{idMusica}")
    public Musica alterar(@PathVariable("idMusica") Long id, @RequestBody Musica musica){
        return musicaService.alterar(id, musica);
    }


}
