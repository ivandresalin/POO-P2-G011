/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo1.entidades;

/**
 *
 * @author ivand
 */
public class Persona extends Entidad{
    private String cedula;
    private String telefono;
    // Constructor que llama al constructor de la clase padre
    public Persona(String nombre, String email, String cedula, String telefono) {
        super(nombre, email);
        this.cedula = cedula;
        this.telefono = telefono;
    }

    // Getter y setter para cedula
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter y setter para telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
