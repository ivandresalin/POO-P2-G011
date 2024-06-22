/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo1.entidades;

/**
 *
 * @author ivand
 */
public class Banco extends Entidad {
    private String ruc;
    private String nombreOficialCredito;
    private String telefonoOficialCredito;

    // Constructor que llama al constructor de la clase padre
    public Banco(String nombre, String email, String ruc, String nombreOficialCredito, String telefonoOficialCredito) {
        super(nombre, email);
        this.ruc = ruc;
        this.nombreOficialCredito = nombreOficialCredito;
        this.telefonoOficialCredito = telefonoOficialCredito;
    }

    // Getter y setter para ruc
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    // Getter y setter para nombreOficialCredito
    public String getNombreOficialCredito() {
        return nombreOficialCredito;
    }

    public void setNombreOficialCredito(String nombreOficialCredito) {
        this.nombreOficialCredito = nombreOficialCredito;
    }

    // Getter y setter para telefonoOficialCredito
    public String getTelefonoOficialCredito() {
        return telefonoOficialCredito;
    }

    public void setTelefonoOficialCredito(String telefonoOficialCredito) {
        this.telefonoOficialCredito = telefonoOficialCredito;
    } 
    
}
