/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo1;

/**
 *
 * @author ivand
 */
public class Pago extends TransaccionFinanciera {
    private TipoAcredor acredor;
    private double interes;
    private String fechaDePrestamo;
    private int cuota;
      // Constructor que llama al constructor de la clase padre
    public Pago(String codigo, String descripcion, double valor, String fechaInicio, String fechaFin, TipoAcredor acredor, double interes, String fechaDePrestamo, int cuota) {
        super(codigo, descripcion, valor, fechaInicio, fechaFin);
        this.acredor = acredor;
        this.interes = interes;
        this.fechaDePrestamo = fechaDePrestamo;
        this.cuota = cuota;
    }

    // Getter y setter para acredor
    public TipoAcredor getAcredor() {
        return acredor;
    }

    public void setAcredor(TipoAcredor acredor) {
        this.acredor = acredor;
    }

    // Getter y setter para interes
    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    // Getter y setter para fechaDePrestamo
    public String getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public void setFechaDePrestamo(String fechaDePrestamo) {
        this.fechaDePrestamo = fechaDePrestamo;
    }

    // Getter y setter para cuota
    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }
}
