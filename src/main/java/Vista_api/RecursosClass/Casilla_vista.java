package Vista_api.RecursosClass;

import Modelo.Unidad;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class Casilla_vista {

    private enum Estado{
        VACIO,
        CATAPULTA,
        CURANDERO,
        INFANTERIA,
        JINETE
    }
    //Esto seguro puede hacerce con solo un Image y un solo visor, pero ni idea por el momento

    private Image casillero_image;
    private ImageView visor_casillero_image;


    //Tambien podria ser le constructor, pero dbeeria mandarle el estado de la casilla a la que pertenece
    //Desconozco si todas las unidades pueden ser reemplazadas por la clase unidad.
    //TODO cambiar lo que recibe

    public void setup() throws Exception{
        //Abro el stream de los archivos
        FileInputStream imagen = new FileInputStream("vacio.png");

        //Referencio todas las imagenes
        this.casillero_image = new Image(imagen);


        //Coloco un visor de imagenes por cada flujo abierto

        this.visor_casillero_image = new ImageView(casillero_image);

    }
    public ImageView mostrar(){
        //Constructor, deberia setupear el estado de la casilla al iniciar
        //Talvez pueda ser reemplazado por el actualizar
        return this.visor_casillero_image;
    }

    //podriamos directamente usar el constructor cada vez que quisieramos actualizar, aun estoy en duda
    public void actualizar(){
        //Actualiza el estado de la casilla
        //Redibujandola y sustrajendo los datos del modelo
    }
}

