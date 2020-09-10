import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue
    private Long id;

    private Calendar inicio;
    private Calendar fin;
    @ManyToOne
    private Cancha cancha;
    @ManyToOne
    private Color colorCancha;
    @ManyToOne
    private Jugador jugadorReservante;
    @ManyToMany
    private List<Participacion> participantes = new ArrayList<>();

    public Partido(Calendar inicio, Calendar fin, Cancha cancha, Color colorCancha, Jugador jugadorReservante) {
        this.inicio = inicio;
        this.fin = fin;
        this.cancha = cancha;
        this.jugadorReservante = jugadorReservante;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public Calendar getFin() {
        return fin;
    }

    public Cancha getCancha() {
        return cancha;
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
                (this.inicio.after(otroPartido.getFin()) || this.fin.before(otroPartido.getInicio()));
    }
}
