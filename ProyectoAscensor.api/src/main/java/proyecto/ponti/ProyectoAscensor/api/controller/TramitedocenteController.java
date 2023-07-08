package proyecto.ponti.ProyectoAscensor.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proyecto.ponti.ProyectoAscensor.api.controller.dto.TramitedocenteDTO;
import proyecto.ponti.ProyectoAscensor.api.model.Tramitedocente;
import proyecto.ponti.ProyectoAscensor.api.repository.TramitedocenteRepository;

@RestController
@RequestMapping("api/docente")
public class TramitedocenteController {

    private final TramitedocenteRepository tramitedocenteRepository;

    public TramitedocenteController(TramitedocenteRepository tramitedocenteRepository) {
        this.tramitedocenteRepository = tramitedocenteRepository;
    }

    @GetMapping("")
    Page<Tramitedocente> index(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
        return tramitedocenteRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    Tramitedocente obtener(@PathVariable Integer id) {
        return tramitedocenteRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Tramitedocente crear(@RequestBody @Validated TramitedocenteDTO tramitedocenteDTO) {
        Tramitedocente tramitedocente = new ModelMapper().map(tramitedocenteDTO, Tramitedocente.class);
        return tramitedocenteRepository.save(tramitedocente);
    }

    @PutMapping("/{id}")
    Tramitedocente actualizar(@PathVariable Integer id, @RequestBody TramitedocenteDTO tramitedocenteDTO) {
        Tramitedocente tramitedocente = tramitedocenteRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        new ModelMapper().map(tramitedocenteDTO, tramitedocente);
        return tramitedocenteRepository.save(tramitedocente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id) {
        Tramitedocente tramitedocente = tramitedocenteRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        tramitedocenteRepository.delete(tramitedocente);
    }
}

