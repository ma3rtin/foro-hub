package com.foro.hub.domain.topico;

import com.foro.hub.domain.curso.CursoRepository;
import com.foro.hub.domain.usuario.UsuarioRepository;
import com.foro.hub.infra.errores.ValidacionException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ServicioTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public void registrarTopico(DatosRegistroTopico datos) {
        var existeTopico = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if(existeTopico){
            throw new ValidacionException("Topico con titulo y mensaje existente");
        }
        if(!usuarioRepository.existsById(datos.autor_id())){
            throw new ValidacionException("Usuario inexistente");
        }
        if(!cursoRepository.existsById(datos.curso_id())){
            throw new ValidacionException("Curso inexistente");
        }

        var fecha = LocalDateTime.now();
        var usuario = usuarioRepository.getReferenceById(datos.autor_id());
        var curso = cursoRepository.getReferenceById(datos.curso_id());


        topicoRepository.save(new Topico(null, datos.titulo(), datos.mensaje(), fecha, true, usuario, curso, new ArrayList<>()));
    }

    public Page<Topico> obtenerTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion);
    }

    public Topico obtenerTopicoPorId(Long id) {
        if(!topicoRepository.existsById(id)){
            throw new ValidacionException("Topico inexistente");
        }
        return topicoRepository.getReferenceById(id);
    }

}

