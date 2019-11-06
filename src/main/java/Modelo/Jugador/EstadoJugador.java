package Modelo.Jugador;

public interface EstadoJugador {
    void consultarEstado();

    EstadoJugador actualizarEstado(EstadoJugador estado, int cantidadUnidades);
}
