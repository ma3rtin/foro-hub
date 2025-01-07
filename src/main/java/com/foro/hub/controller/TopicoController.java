package com.foro.hub.controller;

import com.foro.hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ServicioTopico servicioTopico;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datos){
        servicioTopico.registrarTopico(datos);
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopico>> listarTopicos(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(servicioTopico.obtenerTopicos(paginacion).map(t -> new DatosTopico(t)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosTopico> obtenerTopico(@PathVariable Long id){
        var topico = servicioTopico.obtenerTopicoPorId(id);
        return ResponseEntity.ok(new DatosTopico(topico));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datos){
        var topico = servicioTopico.obtenerTopicoPorId(datos.id());
        topico.actualizarDatos(datos);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        var topico = servicioTopico.obtenerTopicoPorId(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
