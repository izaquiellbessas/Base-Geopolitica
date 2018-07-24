/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arqtobd.model;

/**
 *
 * @author izaquiel
 */
public class ModelCidade {

    private int codigo;
    private int codIBGE;
    private String nome; //45
    private int fk_estado;

    public ModelCidade() {
    }

    public ModelCidade(int codigo, int codIBGE, String nome, int fk_estado) {
        this.codigo = codigo;
        this.codIBGE = codIBGE;
        this.nome = nome;
        this.fk_estado = fk_estado;
    }

    public int getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(int codIBGE) {
        this.codIBGE = codIBGE;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFk_estado() {
        return fk_estado;
    }

    public void setFk_estado(int fk_estado) {
        this.fk_estado = fk_estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
