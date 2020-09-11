import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Cancha {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    @ManyToOne
    private Color color;
    private Boolean tieneIluminacion;

    public Cancha(String nombre, Color color, Boolean tieneIluminacion) {
        this.nombre = nombre;
        this.color = color;
        this.tieneIluminacion = tieneIluminacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getTieneIluminacion() {
        return tieneIluminacion;
    }

    public void verificarHorario(LocalDateTime inicio, LocalDateTime fin) {
        if(!this.tieneIluminacion && LocalTime.of(12,0).getHour() <= inicio.getHour()
         && LocalTime.of(18,0).getHour() >= inicio.getHour())
            throw new RuntimeException("Las canchas sin iluminacion no aceptan este horario");
    }
}
