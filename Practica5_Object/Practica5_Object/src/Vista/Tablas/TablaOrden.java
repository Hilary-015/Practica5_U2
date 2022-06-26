package Vista.Tablas;

import Controlador.Exceptions.PosicionException;
import Controlador.TDA_Lista.ListaEnlazada;
import Modelo.DatosCelulares;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva, Thais Cartuche 
 */
public class TablaOrden extends AbstractTableModel {

    ListaEnlazada<DatosCelulares>  listaCelular = new ListaEnlazada<>();

    public ListaEnlazada<DatosCelulares> getListaCelular() {
        return listaCelular;
    }

    public void setListaCelular(ListaEnlazada<DatosCelulares> listaCelular) {
        this.listaCelular = listaCelular;
    }


    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return listaCelular.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Marca";
            case 1:
                return "Color";
            case 2:
                return "Memoria";
            case 3:
                return "Precio";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        DatosCelulares celular;
        try {
            celular = listaCelular.obtenerDato(arg0);
            switch (arg1) {
            case 0:
                return celular.getMarca();
            case 1:
                return celular.getColor();
            case 2:
                return celular.getPantalla();
            case 3:
                return celular.getPrecio();
            default:
                return null;
        }
        } catch (PosicionException ex) {
            Logger.getLogger(TablaOrden.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
}
