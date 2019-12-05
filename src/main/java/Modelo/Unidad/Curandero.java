package Modelo.Unidad;
import Modelo.Jugador.Jugador;

public class Curandero extends Curador{

    public Curandero(Jugador duenio){
        super(75,2, duenio);
        this.nombre = "curandero";
        this.curacionCercana = 15;
        this.curacionMediana = 0;
        this.curacionLejana = 0;
    }

    @Override
    public void recibirCuracion(float curacion){
        this.vida += curacion;
    }
}
