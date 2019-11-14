import Modelo.Casillero.Casillero;
import Modelo.Casillero.CasilleroFueraDeRangoExcepcion;
import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Tablero.Direccion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasilleroTest {
    @Test
    public void obtenerAdyacenteDevuelveExcepcionSiNoHayAdyacenteEnEsaDireccion(){
        Casillero casillero = new Casillero();

        assertThrows(CasilleroFueraDeRangoExcepcion.class, () ->{
            casillero.obtenerAdyacente(Direccion.ARRIBA);
        } );
    }
}
