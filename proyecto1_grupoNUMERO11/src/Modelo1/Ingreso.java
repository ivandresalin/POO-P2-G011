/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo1 ;


/**
 *
 * @author ivand
 */
public class Ingreso extends TransaccionFinanciera{
    private Categoria categoria;
    private String repeticion;
    public Ingreso(String codigo, String descripcion, double valor, String fechaInicio, String fechaFin, Categoria categoria, String repeticion) {
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

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Categoría: " + categoria);
        System.out.println("Repetición: " + repeticion);
    }
}
