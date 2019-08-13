/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Dados;
import util.DadosTableModel;

/**
 *
 * @author FireBlade
 */
public class TelaRegistroDeAlerta extends JFrame {

    public TelaRegistroDeAlerta(List<Dados> dados) {
        super("GF-Alarme");

        JTable tabela = new JTable();
        DadosTableModel tableModel = new DadosTableModel(dados);
        tabela.setModel(tableModel);

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tabela);
        scroll.setSize(100, 200);

        Container c = getContentPane();
        c.add(scroll);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
