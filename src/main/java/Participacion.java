import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participacion {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Jugador jugador;
    @ManyToOne
    private Paleta paleta;

    public Participacion(Jugador jugador) {
        this.jugador = jugador;
        this.paleta = jugador.getPaleta();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Paleta getPaleta() {
        return paleta;
    }
}
