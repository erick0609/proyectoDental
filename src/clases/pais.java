/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author PROPIETARIO
 */
public class pais {
    private char avPais ;
    private String pais;

    public pais() {
    }

    public pais(char avPais, String pais) {
        this.avPais = avPais;
        this.pais = pais;
    }

    public char getAvPais() {
        return avPais;
    }

    public void setAvPais(char avPais) {
        this.avPais = avPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
