
package Modelo;

/**
 *
 * @author Hilary Madeley Calva Camacho, Thais Nicole Cartuche Peralta
 */
public class DatosCelulares {
    private String color;
    private Double precio;
    private String marca; 
    private String pantalla;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }


    public DatosCelulares(String color, Double precio, String marca, String memoria) {
        this.color = color;
        this.precio = precio;
        this.marca = marca;
        this.pantalla = memoria;
    }

    public DatosCelulares() {
    }

    @Override
    public String toString() {
        return "DatosCelulares{" + "color=" + color + ", precio=" + precio + ", marca=" + marca + ", memoria=" + pantalla + '}';
    }
    
}
