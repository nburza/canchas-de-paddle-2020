import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Color {

    @Id
    @GeneratedValue
    private Long id;

    private String descripcion;

    public Color(String descripcion) {
        this.descripcion = descripcion;
    }
}
