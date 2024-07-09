/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo2;
import entidades.Banco;
/**
 *
 * @author ivand
 */
public class Inversion extends ProcesoBancario{
    private double cantidad;

    // Constructor que llama al constructor de la clase padre
    public Inversion( Banco banco, String fechaApertura, double interesPorMes, String fechaCierre, double cantidad) {
        super(banco, fechaApertura, interesPorMes, fechaCierre);
        this.cantidad = cantidad;
    }

    // Getter y setter para cantidad
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("%-10s %-30s %-15s %-15s %-15s %-15s %n",codigo,banco.getNombre(), fechaApertura,cantidad, interesPorMes,fechaCierre);
        
    }
}
