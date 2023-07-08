package proyecto.ponti.ProyectoAscensor.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tramitedocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtramitedocente")
    private Integer id;

    private String nombre;
    private String apellido;
    private String codigo;
    private String ocupacion;
    private String institucion;
    private String correoinstitucional;
    private String foto;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name ="idtramitealumno")
    private Tramitealumno idtramitealumno;

    @ManyToOne
    @JoinColumn(name = "idtramites")
    private Tramites idtramites;




}
