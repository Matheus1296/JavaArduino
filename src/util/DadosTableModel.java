/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Dados;

/**
 *
 * @author FireBlade
 */
public class DadosTableModel extends AbstractTableModel {

    private final List<Dados> dados;

    public DadosTableModel(List<Dados> dados) {
        this.dados = dados;

    }

    @Override

    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return dados.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        // TODO Auto-generated method stub
        Dados d = dados.get(linha);

        switch (coluna) {
            case 0:
                return d.getData();
            case 1:
                return d.getHora();
            case 2:
                return d.getNivel();
            default:
                break;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Data";
            case 1:
                return "Hora";
            case 2:
                return "Nível";
            default:
                return "";
        }
    }
}
