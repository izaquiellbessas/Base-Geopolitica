/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arqtobd.dao;

import arqtobd.model.ModelCidade;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author izaquiel
 */
public class DAOCidade {

    private final Statement stmt;

    public DAOCidade(Connection conn) throws SQLException {
        stmt = (Statement) conn.createStatement();
    }

    public void excluir(int value) throws SQLException {
        String SQLcidade = "DELETE FROM Cidades where idCidade = " + value;
        stmt.executeUpdate(SQLcidade);
    }

    public void ins(Connection conn, ModelCidade mod) throws SQLException {
        //Ordem dos valores: idcidade, nome, codibge, fk_estado
        String SQL = "INSERT INTO Cidades (nome, codigoIBGE, fkEstado) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, mod.getNome());
            ps.setInt(2, mod.getCodIBGE());
            ps.setInt(3, mod.getFk_estado());
            /* executando a inserção */
            ps.executeUpdate();
        }
    }

    public void ins(Connection conn, String valor[]) throws SQLException {
        //Ordem dos valores: idcidade, nome, codibge, fk_estado
        String SQL = "INSERT INTO Cidades (nome, codigoIBGE, fkEstado) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, valor[0]);
            ps.setInt(2, Integer.parseInt(valor[1]));
            ps.setInt(3, Integer.parseInt(valor[2]));
            /* executando a inserção */
            ps.executeUpdate();
        }
    }

    public void alt(Connection conn, String valor[], String rowId) throws SQLException {
        String SQL = "UPDATE Cidades SET nome=?, codigoIBGE=?, fkEstado=? WHERE idCidade=?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, valor[0]);
            ps.setString(2, valor[1]);
            ps.setString(3, valor[2]);
            /* pega o ID do registro para atualizar */
            ps.setString(4, rowId);
            /* executando a atualização */
            ps.executeUpdate();
        }
    }
}
