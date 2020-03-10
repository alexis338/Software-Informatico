
package softwareinformaticomvc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Eliel Novelo
 */
public class tblSecante extends AbstractTableModel {
    private String[] columnas = {"i","xi1","xi","fxi1","fxi","n","d","xi1r","error"}; 
        private ArrayList<CsSecante> lista = null;  
     public tblSecante(ArrayList<CsSecante> resultados) {
        this.lista = resultados;
    }
    @Override
    public int getRowCount() {
     return this.lista.size();
    }
    @Override
    public int getColumnCount() {
     return this.columnas.length;
    }
    @Override
    public Object getValueAt(int i, int columna) {
        CsSecante fila = this.lista.get(i);
        switch(columna){
            case 0:
                return fila.getInteracion();
            case 1: 
                return fila.getXi1();
            case 2:
                return fila.getXi();
            case 3:
                return fila.getFxi1();
            case 4:
                return fila.getFxi();
            case 5:
                return fila.getN();
            case 6:
                return fila.getD();
            case 7:
                return fila.getXi1r();
            case 8:
                return fila.getError();
               
        }
        return null;
    }   
    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }
    @Override
    public String getColumnName(int i) {
        return this.columnas[i];
    }
}
