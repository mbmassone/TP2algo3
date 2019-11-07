import Modelo.Bando;
import Modelo.Casillero.Casillero;
import Modelo.Curandero;
import Modelo.CurarEnemigoExcepcion;
import Modelo.Infanteria;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CuranderoTest {
    @Test
    public void curanderoCuraAliado(){
        Curandero curandero = new Curandero(Bando.BANDO2, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(Bando.BANDO2, new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(Bando.BANDO1, new Casillero());

        infanteriaEnemiga.accion(infanteriaAliada);
        infanteriaEnemiga.accion(infanteriaAliada);

        curandero.accion(infanteriaAliada);

        Assert.assertSame(infanteriaAliada.getVida(), 95);
    }
    @Test
    public void curanderoCuraEnemigo(){
        Curandero curandero = new Curandero(Bando.BANDO2, new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(Bando.BANDO1,new Casillero());

        assertThrows(CurarEnemigoExcepcion.class, () ->{
            curandero.accion(infanteriaEnemiga);
        });
    }
    @Test
    public void curanderoSeCuraAsiMismo(){
        Curandero curandero = new Curandero(Bando.BANDO2,new Casillero());
        curandero.accion(curandero);

        Assert.assertSame(curandero.getVida(),90);
    }

}
