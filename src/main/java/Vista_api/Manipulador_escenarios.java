package Vista_api;

import javafx.stage.Stage;

public interface Manipulador_escenarios {

    //inicializa el escenario
    void inicializar();
    //actualiza los atributos

    void actualizar() throws Exception;

    void mostrar(Stage stage);

}
