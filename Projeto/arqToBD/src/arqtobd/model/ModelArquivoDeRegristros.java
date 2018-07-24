/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqtobd.model;

import java.util.logging.Logger;

/**
 *
 * @author izaquiellbessas
 */
public class ModelArquivoDeRegristros {

    private int quantidadeLinhasPorRegistro;
    private String delimitadorCamposDoRegistro;

    public ModelArquivoDeRegristros() {
    }

    public ModelArquivoDeRegristros(int quantidadeLinhasPorRegistro, String delimitadorCamposDoRegistro) {
        this.quantidadeLinhasPorRegistro = quantidadeLinhasPorRegistro;
        this.delimitadorCamposDoRegistro = delimitadorCamposDoRegistro;
    }

    public int getQuantidadeLinhasPorRegistro() {
        return quantidadeLinhasPorRegistro;
    }

    public String getDelimitadorCamposDoRegistro() {
        return delimitadorCamposDoRegistro;
    }

    public void setQuantidadeLinhasPorRegistro(int quantidadeLinhasPorRegistro) {
        this.quantidadeLinhasPorRegistro = quantidadeLinhasPorRegistro;
    }

    public void setDelimitadorCamposDoRegistro(String delimitadorCamposDoRegistro) {
        this.delimitadorCamposDoRegistro = delimitadorCamposDoRegistro;
    }
    private static final Logger LOG = Logger.getLogger(ModelArquivoDeRegristros.class.getName());

    public static Logger getLOG() {
        return LOG;
    }
}
