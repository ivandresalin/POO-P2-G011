/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo1;

/**
 *
 * @author ivand
 */
public class Categoria {
    private TipoCategoria tipoCategoria;
    private String nombre;
    
    public Categoria(TipoCategoria tipoCategoria, String nombre) {
        this.tipoCategoria = tipoCategoria;
        this.nombre = nombre;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    
    }
}
