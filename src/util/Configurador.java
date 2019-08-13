/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author aluno
 */
public class Configurador {

    private String url;
    private String driver;
    private String login;
    private String senha;

    public Configurador() {

        try {

            // Abre o Arquivo de Propriedades
            FileInputStream arq = new FileInputStream("config.ini");

            // Cria um Objeto para armezenar as propriedades
            Properties prop = new Properties();

            // Carrega o conteúdo do arquivo de propriedades
            prop.load(arq);

            // Fecha o arquivo de propriedades
            arq.close();

            // Carrega as respectivas propriedades e cada atributo
            url = prop.getProperty("url");
            driver = prop.getProperty("driver");
            login = prop.getProperty("login");
            senha = prop.getProperty("senha");

        } catch (IOException ioe) {
            System.out.println("Arquivo config.ini não encontrado.");
        }
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}
