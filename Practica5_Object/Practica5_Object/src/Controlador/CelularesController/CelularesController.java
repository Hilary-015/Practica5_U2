package Controlador.CelularesController;

import Controlador.TDA_Lista.ListaEnlazadaServices;
import Controlador.TDA_Lista.TipoOrdenacion;
import Modelo.DatosCelulares;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hilary Madeley Calva Camacho, , Thais Nicole Cartuche Peralta
 */
public class CelularesController {

    DatosCelulares celularPrueba = new DatosCelulares();
    ListaEnlazadaServices<DatosCelulares> listaCelular = new ListaEnlazadaServices<>();
    DatosCelulares[] celularArreglo = new DatosCelulares[1000];

    public DatosCelulares[] getCelularArreglo() {
        return celularArreglo;
    }

    public void setCelularArreglo(DatosCelulares[] celularArreglo) {
        this.celularArreglo = celularArreglo;
    }

    public DatosCelulares getCelularPrueba() {
        return celularPrueba;
    }

    public void setCelularPrueba(DatosCelulares celularPrueba) {
        this.celularPrueba = celularPrueba;
    }

    public ListaEnlazadaServices<DatosCelulares> getListaCelular() {
        return listaCelular;
    }

    public void setListaCelular(ListaEnlazadaServices<DatosCelulares> listaCelular) {
        this.listaCelular = listaCelular;
    }

    public CelularesController() {
    }
    
    public String[] marca(){
        String[] marcasAleatorias = new String[10000];
        
        String[] marcas = {"Samsung", "Huawei", "iPhone", "Xiaomi", "LG", "Sony", "Motorola"};
        for (int i = 0; i < 10000; i++) {
            marcasAleatorias[i] = marcas [(int)(Math.floor(Math.random()*((marcas.length-1)-0+1)))];
        }
        return marcasAleatorias;
    }
    
    public String[] color(){
        String[] coloresAleatorios = new String[10000];
        
        String[] colores = {"Azul", "Negro", "Rosa", "Blanco", "Azul metalico", "Gris", "Dorado", "Celeste", "Verde metalico"};
        for (int i = 0; i < 10000; i++) {
            coloresAleatorios[i] = colores [(int)(Math.floor(Math.random()*((colores.length-1)-0+1)))];
        }
        return coloresAleatorios;
    }
    
    public String[] pantalla(){
        String[] memoriaAleatorios = new String[10000];
        
        String[] memoria = {"5.8 pulgadas", "6.2 pulgadas", "6.4 pulgadas", "6.7 pulgadas", "6.9 pulgadas"};
        for (int i = 0; i < 10000; i++) {
            memoriaAleatorios[i] = memoria [(int)(Math.floor(Math.random()*((memoria.length-1)-0+1)))];
        }
        return memoriaAleatorios;
    }
    
    public double precio() {
        double minValor = 200.0;
        double maxValor = 600.0;
        double precio = (Math.random() * (maxValor- minValor)+200);
        return Math.round(precio * 100.0) / 100.0;
    }

    public ListaEnlazadaServices<DatosCelulares> guardarLista() {
        DatosCelulares cuenta;
        for (int i = 0; i < 1000; i++) {
            cuenta = (new DatosCelulares(color()[i], precio(), marca()[i], pantalla()[i]));
            listaCelular.insertarAlInicio(cuenta);
            setListaCelular(listaCelular);
        }
        return getListaCelular();
    }
    
    public void ordenarShell(String atributo, TipoOrdenacion ordenacion){
        try {  
            getListaCelular().getLista().ordenarShell(atributo, ordenacion);
        } catch (Exception ex) {
            Logger.getLogger(CelularesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ordenarQuickShort(String atributo, TipoOrdenacion ordenacion){
        try {  
            getListaCelular().getLista().ordenarQuickShort(atributo, ordenacion);
        } catch (Exception ex) {
            Logger.getLogger(CelularesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
