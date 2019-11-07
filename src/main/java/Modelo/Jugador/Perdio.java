package Modelo.Jugador;

public class Perdio implements EstadoJugador {
    public void consultarEstado() { throw new JugadorSinUnidadesEnJuegoExcepcion(); }

    public EstadoJugador actualizarEstado(EstadoJugador estado, int cantidadUnidades) { return new Perdio(); }
}
