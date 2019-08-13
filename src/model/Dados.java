/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Dados {

    private int dadosId;
    private int nivel;
    private String hora;
    private String data;

    public int getDadosId() {
        return dadosId;
    }

    public void setDadosId(int dadosId) {
        this.dadosId = dadosId;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Dados() {
    }

    public Dados(int dadosId, int nivel, String hora, String data) {
        this.dadosId = dadosId;
        this.nivel = nivel;
        this.hora = hora;
        this.data = data;
    }

}
