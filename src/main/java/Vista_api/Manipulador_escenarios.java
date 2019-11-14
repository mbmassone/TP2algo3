package Vista_api;

import javafx.stage.Stage;

public interface Manipulador_escenarios {

    //inicializa el escenario
    void inicializar();
    //actualiza los atributos
    void actualizar()  throws Exception;
    //vuelve a dibujar la superficie (Realmente necesatio? hace Forward del metodo .show)
    void mostrar();

    void mostrar(Stage stage);

}
