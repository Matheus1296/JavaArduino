/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.Dados;
import util.Conexao;
import util.Configurador;

/**
 *
 * @author aluno
 */
public class DadosDAO {

    Configurador config = new Configurador();

    String url;
    String driver;
    String login;
    String senha;

    public DadosDAO() {
        url = config.getUrl();
        driver = config.getDriver();
        login = config.getLogin();
        senha = config.getSenha();
    }

    public static Dados inserir(int nivel, String hora, String data) {

//        nome = nome.trim();
//        telefone = telefone.trim();
//        celular = celular.trim();
//        email = email.trim();
        Dados dados = null;
        DadosDAO dadosDAO = new DadosDAO();

        try {

            // Criação do insert
            String sql = "insert into dados values (?,?,?,null)";

            // Obter a conexão com o BD
            Conexao conex = new Conexao(dadosDAO.url, dadosDAO.driver,
                    dadosDAO.login, dadosDAO.senha);

            // Abrir a conexao
            Connection con = conex.obterConexao();

            // Preparar o comando para ser executado
            PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, data);
            comando.setString(2, hora);
            comando.setInt(3, nivel);
            comando.execute();

            comando.executeUpdate();
            dados = new Dados(0, nivel, hora, data);

        } catch (Exception e) {

        }

        return dados;
    }

    public static List<Dados> buscarTodos() {

        DadosDAO daDAO = new DadosDAO();
        List<Dados> dados = new LinkedList<Dados>();

        try {

            // criação do select
            String sql = "select dados.data,dados.hora,dados.nivel from dados";

            // Obter a conexão com o banco de dados
            Conexao conex = new Conexao(daDAO.url, daDAO.driver, daDAO.login, daDAO.senha);

            // abrir conexão
            Connection con = conex.obterConexao();

            // Executa a confirmação direta de acesso ao banco pois não são
            // necessárias
            // informações para a query(caracter curinga)
            Statement comando = con.createStatement();

            // ResultSet - Classe java que monta em memória uma matriz com a
            // resposta das linhas do banco de dados
            ResultSet rs = comando.executeQuery(sql);

            // Vetor de objetos
            // Passagem de linha de dados do ResultSet para o vetor de objetos
            // (uma linha de dados da matriz do ResultSet é copiada para um
            // objeto no vetor clientesFisicos)
            while (rs.next()) {
                Dados d = new Dados();

                d.setData(rs.getString("data"));
                d.setHora(rs.getString("Hora"));
                d.setNivel(rs.getInt("nivel"));
                dados.add(d);
            }

            rs.close();
            comando.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dados;
    }
}
