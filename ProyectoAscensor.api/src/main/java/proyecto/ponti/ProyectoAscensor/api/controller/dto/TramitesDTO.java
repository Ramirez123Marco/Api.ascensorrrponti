package proyecto.ponti.ProyectoAscensor.api.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TramitesDTO {
    private String nombre;
    private String apellido;
    private String codigo;
    private Integer telefono;
    private String ocupacion;
    private String corint;
    private String tipint;



}
