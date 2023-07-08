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
import proyecto.ponti.ProyectoAscensor.api.controller.dto.TramitealumnoDTO;
import proyecto.ponti.ProyectoAscensor.api.model.Tramitealumno;
import proyecto.ponti.ProyectoAscensor.api.model.Tramitedocente;
import proyecto.ponti.ProyectoAscensor.api.repository.TramitealumnoRepository;

@RestController
@RequestMapping("api/alumno")
public class TramitealumnoController {
    @Autowired
    private TramitealumnoRepository tramitealumnoRepository;

    @GetMapping
    Page<Tramitealumno> index(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
        return tramitealumnoRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Tramitealumno obtener(@PathVariable Integer id) {
        return tramitealumnoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Tramitealumno crear(@RequestBody @Validated TramitealumnoDTO tramitealumnoDTO) {
        Tramitealumno tramitealumno = new ModelMapper().map(tramitealumnoDTO, Tramitealumno.class);
        return tramitealumnoRepository.save(tramitealumno);
    }

    @PutMapping("/{id}")
    Tramitealumno actualizar(@PathVariable Integer id, @RequestBody TramitealumnoDTO tramitealumnoDTO) {
        Tramitealumno tramitealumno = tramitealumnoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        new ModelMapper().map(tramitealumnoDTO, tramitealumno);
        return tramitealumnoRepository.save(tramitealumno);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id) {
        Tramitealumno tramitealumno = tramitealumnoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        tramitealumnoRepository.delete(tramitealumno);
    }
}

