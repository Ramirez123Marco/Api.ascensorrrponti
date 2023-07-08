package proyecto.ponti.ProyectoAscensor.api.controller.dto;

import lombok.Getter;
import lombok.Setter;
import proyecto.ponti.ProyectoAscensor.api.model.Tramitedocente;

@Getter
@Setter
public class TramitealumnoDTO {

private String carrera;

private String ciclo;

private String vouchert;

private Tramitedocente idtramitedocente;
}
