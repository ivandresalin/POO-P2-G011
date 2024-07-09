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
public class CuentaBancaria extends ProcesoBancario{
    private TipoCuenta tipoCuenta;
    private String numero;
    private double saldo;

    // Constructor que llama al constructor de la clase padre
    public CuentaBancaria( Banco banco, String fechaApertura, double interesPorMes, String fechaCierre, TipoCuenta tipoCuenta, String numero, double saldo) {
        super( banco, fechaApertura, interesPorMes, fechaCierre);
        this.tipoCuenta = tipoCuenta;
        this.numero = numero;
        this.saldo = saldo;
    }

    // Getter y setter para tipoCuenta
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    // Getter y setter para numero
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Getter y setter para saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String mostrarInformacion() {
       return String.format("%-10s %-30s %-15s %-15s %-15s %n",codigo,banco.getNombre(),tipoCuenta ,numero,saldo,fechaCierre);
        
    }
}
