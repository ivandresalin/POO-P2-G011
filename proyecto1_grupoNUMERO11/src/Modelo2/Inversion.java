/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo2;
import modelo1.entidades.Banco;
/**
 *
 * @author ivand
 */
public class Inversion extends ProcesoBancario{
    private double cantidad;

    // Constructor que llama al constructor de la clase padre
    public Inversion(String codigo, Banco banco, String fechaApertura, double interesPorMes, String fechaCierre, double cantidad) {
        super(codigo, banco, fechaApertura, interesPorMes, fechaCierre);
        this.cantidad = cantidad;
    }

    // Getter y setter para cantidad
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
