package com.prueba.proa.Producto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private String marca;
    private String descripcion;
    private double precio;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getProducto(){
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // RESPONSE
    @Override
    public String toString() {
        return "Producto solicitado{" +
                    "id=" + id +
                    ", Nombre del Producto='" + producto + '\'' +
                    ", Marca='" + marca + '\'' +
                    ", Descripción='" + descripcion + '\'' +
                    ", Precio=" + precio +
                '}';
    }

}
