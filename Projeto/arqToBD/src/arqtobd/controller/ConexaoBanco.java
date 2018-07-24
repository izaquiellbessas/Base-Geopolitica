/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arqtobd.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izaquiel
 */
public class ConexaoBanco {

    private Connection conexao = null;
    private static final String DRIVER_PADRAO_MYSQL = "com.mysql.jdbc.Driver";
    private static final String URL_PADRAO_MYSQL = "jdbc:mysql://localhost/"; //para ser concatenada com o nome do banco

    /**
     * Construtor para conexão com uma base de dados qualquer, não
     * necessariamente o MySQL
     *
     * @param driver - passa o driver do banco para conexão
     * @param url - passa a url(caminho) da base de dados especificada
     * @param nomeBanco - nome da base de dados, será concatenada com url
     * @param usuario - nome do usuario do banco
     * @param senha - senha do usuario do banco
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public ConexaoBanco(String driver, String url, String nomeBanco, String usuario, String senha) throws ClassNotFoundException, SQLException {
        String urlFinal = url + nomeBanco;
        Class.forName(driver);
        this.conexao = DriverManager.getConnection(urlFinal, usuario, senha);
        if (conexao.isValid(10)) {
            System.out.println("Conexão com o bando estabelecida com sucesso!");
        } else {
            System.out.println("A conexão falhou!");
        }
    }

    /**
     * Construtor padrão para conexão com bancos MySQL - Os parametros padrões
     * como o driver e a url são invocados automaticamente.
     *
     * @param nomeBanco Nome da base de dados
     * @param usuario Nome do usuário da base
     * @param senha Senha do usuario
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public ConexaoBanco(String nomeBanco, String usuario, String senha) throws ClassNotFoundException, SQLException {
        this(DRIVER_PADRAO_MYSQL, URL_PADRAO_MYSQL, nomeBanco, usuario, senha);
    }

    public void fecharResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fecharConexao() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
                System.out.println("Conexão com o banco encerrada");
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
