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
import proyecto.ponti.ProyectoAscensor.api.controller.dto.TramitesDTO;
import proyecto.ponti.ProyectoAscensor.api.model.Tramites;
import proyecto.ponti.ProyectoAscensor.api.repository.TramitesRepository;

@RestController
@RequestMapping("/api/aea/tramite")
public class TramitesController {
    @Autowired
    private TramitesRepository tramitesRepository;
    @GetMapping("")
    Page<Tramites> index(@PageableDefault(sort = "id", size = 5) Pageable pageable) {
        return tramitesRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    Tramites obtener(@PathVariable Integer id) {
        return tramitesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Tramites crear(@RequestBody @Validated TramitesDTO tramitesDTO) {
        Tramites tramites = new ModelMapper().map(tramitesDTO, Tramites.class);
        return tramitesRepository.save(tramites);
    }

    @PutMapping("/{id}")
    Tramites actualizar(@PathVariable Integer id, @RequestBody TramitesDTO tramitesDTO) {
        Tramites tramites = tramitesRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        new ModelMapper().map(tramitesDTO, tramites);
        return tramitesRepository.save(tramites);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminar(@PathVariable Integer id) {
        Tramites tramites= tramitesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        tramitesRepository.delete(tramites);
    }
}

