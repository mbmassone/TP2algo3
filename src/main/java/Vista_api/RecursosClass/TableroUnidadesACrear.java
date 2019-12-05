package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Controlador.ControladorDeAgregarUnidad;
import Controlador.CreadorDeUnidad.CreadorDeCatapulta;
import Controlador.CreadorDeUnidad.CreadorDeCurandero;
import Controlador.CreadorDeUnidad.CreadorDeInfanteria;
import Controlador.CreadorDeUnidad.CreadorDeJinete;
import Modelo.Tablero.Coordenada;
import Vista_api.Mapa;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static Vista_api.ConstantesInterfaz.*;

public class TableroUnidadesACrear extends HBox {

    ImageView imagenCatapulta;
    ImageView imagenCurandero;
    ImageView imagenInfanteria;
    ImageView imagenJinete;

    Label textoCatapulta;
    Label textoCurandero;
    Label textoInfanteria;
    Label textoJinete;

    GridPane matriz;

    public TableroUnidadesACrear(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa, Label labelPuntos){
        //Setup de la grilla que contiene a la muestra d eunidades
        this.matriz = new GridPane();
        this.matriz.setHgap(20);
        this.matriz.setVgap(20);

        //Carga de imagenes
        imagenCatapulta = new ImageView(new Image(IMG_CATAPULTA));
        imagenCurandero = new ImageView(new Image(IMG_CURANDERO));
        imagenInfanteria = new ImageView(new Image(IMG_INFANTERIA));
        imagenJinete = new ImageView(new Image(IMG_JINETE));

        //Creo los handlers para cada imagen



        //Los asocio al hacer click en cada unidad.

        imagenCatapulta.addEventFilter(MouseEvent.MOUSE_CLICKED, new ControladorDeAgregarUnidad(contenedor, ultimaCoordenadaTocada, new CreadorDeCatapulta(), mapa, labelPuntos));
        imagenCurandero.addEventFilter(MouseEvent.MOUSE_CLICKED, new ControladorDeAgregarUnidad(contenedor, ultimaCoordenadaTocada, new CreadorDeCurandero(), mapa, labelPuntos));
        imagenInfanteria.addEventFilter(MouseEvent.MOUSE_CLICKED, new ControladorDeAgregarUnidad(contenedor, ultimaCoordenadaTocada, new CreadorDeInfanteria(), mapa, labelPuntos));
        imagenJinete.addEventFilter(MouseEvent.MOUSE_CLICKED, new ControladorDeAgregarUnidad(contenedor, ultimaCoordenadaTocada, new CreadorDeJinete(), mapa, labelPuntos));

        //Setup de textos
        textoCatapulta = new Label("Catapulta\n5");
        textoCurandero = new Label("Curandero\n2");
        textoInfanteria = new Label("Infanteria\n1");
        textoJinete = new Label("Jinete\n3");
        //Coloco las imagenes y los textos en la grilla
        this.matriz.add(imagenCatapulta,0,0);
        this.matriz.add(textoCatapulta,1,0);
        this.matriz.add(imagenCurandero,0,1);
        this.matriz.add(textoCurandero,1,1);
        this.matriz.add(imagenInfanteria,0,2);
        this.matriz.add(textoInfanteria,1,2);
        this.matriz.add(imagenJinete,0,3);
        this.matriz.add(textoJinete,1,3);



        //Coloco la grilla en el TableroUnidadesACrear
        this.getChildren().addAll(this.matriz);
    }
}
