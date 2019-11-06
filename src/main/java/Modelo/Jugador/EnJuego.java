package Modelo.Jugador;

public class EnJuego implements EstadoJugador {
    public void consultarEstado(){ }

    public EstadoJugador actualizarEstado(EstadoJugador estado, int cantidadUnidades){
        if(cantidadUnidades == 0)
            return new Perdio();
        return estado;
    }
}
