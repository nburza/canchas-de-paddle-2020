import javax.persistence.*;

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
}
