package Vista_api.RecursosClass;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class CasillaVista {

    private enum Estado{
        VACIO,
        CATAPULTA,
        CURANDERO,
        INFANTERIA,
        JINETE
    }
    //Esto seguro puede hacerce con solo un Image y un solo visor, pero ni idea por el momento

    private Image casilleroImage;
    private ImageView visorCasilleroImage;


    //Tambien podria ser le constructor, pero dbeeria mandarle el estado de la casilla a la que pertenece
    //Desconozco si todas las unidades pueden ser reemplazadas por la clase unidad.
    //TODO cambiar lo que recibe

    public CasillaVista() {

    }

    public ImageView mostrar(){
        //Constructor, deberia setupear el estado de la casilla al iniciar
        //Talvez pueda ser reemplazado por el actualizar
        return this.visorCasilleroImage;
    }

    //podriamos directamente usar el constructor cada vez que quisieramos actualizar, aun estoy en duda
    public void actualizar(String string) throws Exception{
        //Abro el stream de los archivos
        FileInputStream imagen = new FileInputStream(string + ".png");

        //Referencio todas las imagenes
        this.casilleroImage = new Image(imagen);


        //Coloco un visor de imagenes por cada flujo abierto

        this.visorCasilleroImage = new ImageView(casilleroImage);

    }

}

