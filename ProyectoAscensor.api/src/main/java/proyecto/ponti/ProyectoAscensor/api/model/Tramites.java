package proyecto.ponti.ProyectoAscensor.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tramites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idtramites")
    private Integer id;


    private String numtramite;

    private String categoriatramite;


    private String tipoinstitucion;

}
