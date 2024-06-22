/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo2;
import modelo1.entidades.*;

/**
 *
 * @author ivand
 */
public class ProcesoBancario {
    private String codigo;
    private Banco banco;
    private String fechaApertura;
    private double interesPorMes;
    private String fechaCierre;

    // Constructor
    public ProcesoBancario(String codigo, Banco banco, String fechaApertura, double interesPorMes, String fechaCierre) {
        this.codigo = codigo;
        this.banco = banco;
        this.fechaApertura = fechaApertura;
        this.interesPorMes = interesPorMes;
        this.fechaCierre = fechaCierre;
    }

    // Getters y setters para codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getters y setters para banco
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    // Getters y setters para fechaApertura
    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    // Getters y setters para interesPorMes
    public double getInteresPorMes() {
        return interesPorMes;
    }

    public void setInteresPorMes(double interesPorMes) {
        this.interesPorMes = interesPorMes;
    }

    // Getters y setters para fechaCierre
    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
