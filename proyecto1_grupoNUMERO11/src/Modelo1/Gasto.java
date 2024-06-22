/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo1;

/**
 *
 * @author ivand
 */
public class Gasto extends TransaccionFinanciera {
    private Categoria categoria;
    private String repeticion;
    
    public Gasto(String codigo, String descripcion, double valor, String fechaInicio, String fechaFin, Categoria categoria, String repeticion) {
        super(codigo, descripcion, valor, fechaInicio, fechaFin);
        this.categoria = categoria;
        this.repeticion = repeticion;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }
    
}
