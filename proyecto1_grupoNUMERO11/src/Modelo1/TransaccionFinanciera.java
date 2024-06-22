/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo1;

/**
 *
 * @author ivand
 */
public class TransaccionFinanciera {
    private String codigo;
    private String descripcion;
    private double valor;
    private String fechaInicio;
    private String fechaFin;
    
     // Constructor
    public TransaccionFinanciera(String codigo, String descripcion, double valor, String fechaInicio, String fechaFin) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Métodos getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Método para mostrar la información de la transacción
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Valor: " + valor);
        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + fechaFin);
    }
    
}
