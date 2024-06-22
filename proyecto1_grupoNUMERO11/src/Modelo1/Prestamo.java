/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo1;

import modelo1.entidades.Persona;

/**
 *
 * @author ivand
 */
public class Prestamo extends TransaccionFinanciera {
    private Persona deudor;
    private String fechaDePrestamo;
    private int cuota;
    
    public Prestamo(String codigo, String descripcion, double valor, String fechaInicio, String fechaFin, Persona deudor, String fechaDePrestamo, int cuota) {
        super(codigo, descripcion, valor, fechaInicio, fechaFin);
        this.deudor= deudor;
        this.fechaDePrestamo=fechaDePrestamo;
        this.cuota= cuota;
         
     }    
    
    public Persona getDeudor() {
        return deudor;
    }

    public void setDeudor(Persona deudor) {
        this.deudor = deudor;
    }

    public String getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public void setFechaDePrestamo(String fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }
}
