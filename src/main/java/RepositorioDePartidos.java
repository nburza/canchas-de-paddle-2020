import java.util.ArrayList;
import java.util.List;

public class RepositorioDePartidos {

    private List<Partido> partidos = new ArrayList<>();

    public void reservar(Partido partido) {
        if(this.partidos.stream().anyMatch(p -> p.seSuperponeCon(partido)))
            throw new RuntimeException("El horario esta ocupado");
        this.partidos.add(partido);
    }

    public void eliminar(Partido partido) {
        this.partidos.remove(partido);
    }


}
