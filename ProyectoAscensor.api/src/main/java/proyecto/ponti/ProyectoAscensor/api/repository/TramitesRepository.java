package proyecto.ponti.ProyectoAscensor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.ponti.ProyectoAscensor.api.model.Tramites;

import java.util.Optional;

public interface TramitesRepository extends JpaRepository<Tramites, Integer> {

    @Override
    Optional<Tramites> findById(Integer id);

    Optional<Tramites> findOneByNombre(String nombre);
    Optional<Tramites> findOneByApellido(String apellido);
    Optional<Tramites> findOneByCodigo(String codigo);
    Optional<Tramites> findOneByTelefono(Integer telefono);
    Optional<Tramites> findOneByOcupacion(String ocupacion);
    Optional<Tramites> findOneByCorint(String corint);
    Optional<Tramites> findOneByTipint(String tipint);
}
