/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import model.Dados;
import modelDAO.DadosDAO;
import serial.SerialRxtx;
import view.TelaRegistroDeAlerta;
import view.TelaUsuario;

public class Controlador {

    public static void main(String[] args) {
        TelaUsuario telaUsuario = new TelaUsuario();

        SerialRxtx serial = new SerialRxtx();

        if (serial.iniciaSerial(telaUsuario)) {

            while (true) {

            }

        } else {

        }
    }

    public void salvarDados(Dados dados) {
        dados = DadosDAO.inserir(dados.getNivel(), dados.getHora(), dados.getData());
    }
    
    public void buscarTodosDados() {
        List<Dados> dados = DadosDAO.buscarTodos();
        new TelaRegistroDeAlerta(dados);
    }

}
