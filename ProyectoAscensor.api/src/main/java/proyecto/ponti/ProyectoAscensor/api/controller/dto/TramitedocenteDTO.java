package proyecto.ponti.ProyectoAscensor.api.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TramitedocenteDTO {

    @NotBlank
    @Size(min=1, max = 30)
    private String tramite;

}