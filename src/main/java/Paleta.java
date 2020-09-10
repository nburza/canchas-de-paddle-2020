import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paleta {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Double grosor;
    @ManyToOne
    private Color color;
    @ManyToOne
    private Constructor constructor;

    public Paleta(String nombre, Double grosor, Color color, Constructor constructor) {
        this.nombre = nombre;
        this.grosor = grosor;
        this.color = color;
        this.constructor = constructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getGrosor() {
        return grosor;
    }

    public void setGrosor(Double grosor) {
        this.grosor = grosor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
}
