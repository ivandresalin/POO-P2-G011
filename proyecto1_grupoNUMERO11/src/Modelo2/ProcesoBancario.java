/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo2;
import entidades.Banco;
import modelo.TransaccionFinanciera;

/**
 *
 * @author ivand
 */
public abstract class ProcesoBancario {
    protected static int contador=1;
    protected int  codigo;
    protected Banco banco;
    protected String fechaApertura;
    protected double interesPorMes;
    protected String fechaCierre;
    
    public static void incrementarCodigo(){
        contador++;
    }
    // Constructor
    public ProcesoBancario(Banco banco, String fechaApertura, double interesPorMes, String fechaCierre) {
        
        this.codigo = contador;
        this.banco = banco;
        this.fechaApertura = fechaApertura;
        this.interesPorMes = interesPorMes;
        this.fechaCierre = fechaCierre;
        incrementarCodigo();
    }

    // Getters y setters para codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
    
    public String mostrarInformacion(){
        return "";
    } 
        
        
    
    
}
