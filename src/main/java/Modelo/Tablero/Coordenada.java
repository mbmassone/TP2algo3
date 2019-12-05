package Modelo.Tablero;

public class Coordenada {
    //Atributos
    int fila;
    int columna;

    public Coordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o){
        Coordenada coordenada = (Coordenada) o;
        return (this.fila == coordenada.obtenerFila()) && (this.columna == coordenada.obtenerColumna());
    }


    @Override
    public int hashCode() {
        return this.fila | (this.columna << 15);
    }

    public Coordenada suma(Coordenada coordenada){
        return new Coordenada(this.fila + coordenada.obtenerFila(), this.columna + coordenada.obtenerColumna());
    }

    public int calcularDistancia(Coordenada coordenada){
        return Math.max(Math.abs(coordenada.obtenerFila() - this.fila), Math.abs((coordenada.obtenerColumna() - this.columna)));
    }

    public int obtenerFila(){ return fila; }

    public int obtenerColumna(){ return columna; }

    public void cambiarCoordenada(Coordenada coordenada){
        this.fila = coordenada.obtenerFila();
        this.columna = coordenada.obtenerColumna();
    }
}