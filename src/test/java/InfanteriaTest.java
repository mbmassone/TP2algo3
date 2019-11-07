import Modelo.*;
import Modelo.Casillero.Casillero;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InfanteriaTest{

    @Test
    public void testInfanteriaAtacaEnemigo(){
        Infanteria infanteriaAliada = new Infanteria(Bando.BANDO1, new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(Bando.BANDO2, new Casillero());

        infanteriaAliada.accion(infanteriaEnemiga);
        Assert.assertSame(infanteriaEnemiga.getVida(),90);
    }

    @Test
    public void testInfanteriaMataAEnemigo() {
        Casillero casilleroJinete = new Casillero();
        Infanteria infanteria = new Infanteria(Bando.BANDO1, new Casillero());
        Jinete jinete = new Jinete(Bando.BANDO2, casilleroJinete);

        casilleroJinete.agregarUnidad(jinete);

        Assert.assertFalse(casilleroJinete.estaLibre());
        for (int i = 0; i < 10; i++) {
            infanteria.accion(jinete);
        }
        Assert.assertTrue(casilleroJinete.estaLibre());

    }

    @Test
    public void testInfanteriaAtacaAliado(){
        Infanteria infanteria = new Infanteria(Bando.BANDO2, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(Bando.BANDO2, new Casillero());

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            infanteria.accion(infanteriaAliada);
        });
    }

    @Test
    public void testInfanteriaPuedeRecibirCuracion(){
        Infanteria infanteria = new Infanteria(Bando.BANDO2, new Casillero());
        Curandero curandero = new Curandero(Bando.BANDO2, new Casillero());

        curandero.accion(infanteria);

        assertSame(infanteria.getVida(),115);
    }

}
