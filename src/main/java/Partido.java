import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime inicio;
    private LocalDateTime fin;
    @ManyToOne
    private Cancha cancha;
    @ManyToOne
    private Color colorCancha;
    @ManyToOne
    private Jugador jugadorReservante;
    @ManyToMany
    private List<Participacion> participantes = new ArrayList<>();

    public Partido(LocalDateTime inicio, LocalDateTime fin, Cancha cancha, Color colorCancha, Jugador jugadorReservante) {
        cancha.verificarHorario(inicio, fin);
        this.inicio = inicio;
        this.fin = fin;
        this.cancha = cancha;
        this.jugadorReservante = jugadorReservante;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public Color getColorCancha() {
        return colorCancha;
    }

    public List<Participacion> getParticipantes() {
        return participantes;
    }

    public void empezar(List<Jugador> jugadores) {
        this.colorCancha = this.cancha.getColor();
        jugadores.forEach(jugador -> this.participantes.add(new Participacion(jugador)));
    }

    public Boolean seSuperponeCon(Partido otroPartido) {
        return this.cancha.equals(otroPartido.getCancha()) &&
                (this.inicio.isAfter(otroPartido.getFin()) || this.fin.isBefore(otroPartido.getInicio()));
    }
}
