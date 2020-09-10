import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Jugador {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private Calendar fechaNacimiento;
    @ManyToOne
    private Paleta paleta;

    public Jugador(String nombre, String apellido, String domicilio, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Paleta getPaleta() {
        return paleta;
    }

    public void setPaleta(Paleta paleta) {
        this.paleta = paleta;
    }
}
