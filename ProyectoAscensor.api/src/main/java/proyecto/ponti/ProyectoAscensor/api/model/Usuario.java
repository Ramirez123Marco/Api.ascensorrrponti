package proyecto.ponti.ProyectoAscensor.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    private String nombre;

    private String apellido;

    private String dni;

    private String telefono;

    private  String correo;

    //@Enumerated(EnumType.STRING)
    private Rol rol;
    private String user;

    private String pass;
    public enum Rol{

        ALUMNO,

        DOCENTE

    }}
