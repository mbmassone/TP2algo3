package Modelo;

public class Turno {

    Jugador j1;
    Jugador j2;
    Jugador actual;

    public Turno(Jugador j1, Jugador j2){
        this.j1 = j1;
        this.j2 = j2;

        this.actual = j1;
    }

    public boolean cambiarTurno(){
        this.actual = actual.obtenerEnemigo();
        return j1.esGanador() || j2.esGanador();
    }

    public Jugador obtenerJugadorActual(){
        return this.actual;
    }

    public Jugador obtenerGanador(){
        if(j1.esGanador()) return j1;
        else return j2;
    }
}
