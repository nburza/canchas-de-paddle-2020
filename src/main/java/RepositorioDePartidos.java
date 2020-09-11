import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDePartidos implements WithGlobalEntityManager {

    private List<Partido> partidos = new ArrayList<>();

    public void reservar(Partido partido) {
        if(this.partidos.stream().anyMatch(p -> p.seSuperponeCon(partido)))
            throw new RuntimeException("El horario esta ocupado");
        entityManager().persist(partido);
    }

    public void eliminar(Partido partido) {
        entityManager().remove(partido);
    }

    public Partido getPartido(Long id) {
        return entityManager().find(Partido.class, id);
    }

    public List<Partido> getPartidosEnFranjaHoraria(LocalDateTime inicioFranja, LocalDateTime finFranja) {
        //ni idea como hacer esto con el entity manager o si hay que hacerlo con el entity manager
        return (List<Partido>) partidos.stream().filter(p -> inicioFranja.isBefore(p.getInicio()) && finFranja.isAfter(p.getFin()));
    }
}
