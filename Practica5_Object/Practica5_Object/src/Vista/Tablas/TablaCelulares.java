package Vista.Tablas;

import Controlador.TDA_Lista.ListaEnlazadaServices;
import Modelo.DatosCelulares;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hilary Calva, Thais Cartuche 
 */
public class TablaCelulares extends AbstractTableModel {

    ListaEnlazadaServices<DatosCelulares> listaCelular = new ListaEnlazadaServices<>();

    public ListaEnlazadaServices<DatosCelulares> getListaCelular() {
        return listaCelular;
    }

    public void setListaCelular(ListaEnlazadaServices<DatosCelulares> listaCelular) {
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
                return "Tamaño Pantalla";
            case 3:
                return "Precio";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1)  {
        DatosCelulares celular = listaCelular.obtenerDato(arg0);
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
    }
}
