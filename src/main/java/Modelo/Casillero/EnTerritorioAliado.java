package Modelo.Casillero;

import Modelo.Unidad;

public class EnTerritorioAliado implements EstadoTerritorio {
    public void analizarDanio(Unidad unidad, float danio){
        unidad.descontarVida(danio);
    }

    public void actualizarEstado(Unidad unidad, Casillero casillero){
        if(!casillero.obtenerDuenio().obtenerNombre().equals(unidad.obtenerDuenio().obtenerNombre() ) )
            unidad.actualizarEstadoTerritorio(new EnTerritorioEnemigo() );
    }
}
