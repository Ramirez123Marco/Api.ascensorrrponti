package proyecto.ponti.ProyectoAscensor.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.ponti.ProyectoAscensor.api.controller.dto.UsuarioDTO;

import proyecto.ponti.ProyectoAscensor.api.model.Usuario;

import proyecto.ponti.ProyectoAscensor.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping
        Page<Usuario> index(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
            return usuarioRepository.findAll(pageable);
        }
        @GetMapping("/{id}")
        Usuario obtener(@PathVariable Integer id) {
            return usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Usuario crear(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        Usuario usuario = new ModelMapper().map(usuarioDTO, Usuario.class);
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    Usuario actualizar(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        new ModelMapper().map(usuarioDTO, usuario);
        return usuarioRepository.save(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        usuarioRepository.delete(usuario);
    }
}
