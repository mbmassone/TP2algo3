package Modelo.Casillero;

import Modelo.Unidad;

public class EnTerritorioEnemigo implements EstadoTerritorio {
    public void analizarDanio(Unidad unidad, float danio){
        danio = (float) (danio * 1.05);
        unidad.descontarVida(danio);
    }

    public void actualizarEstado(Unidad unidad, Casillero casillero){
        if(!casillero.obtenerDuenio().obtenerNombre().equals(unidad.obtenerDuenio().obtenerNombre() ) )
            unidad.actualizarEstadoTerritorio(new EnTerritorioAliado() );
    }
}
