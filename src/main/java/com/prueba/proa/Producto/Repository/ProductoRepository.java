package com.prueba.proa.Producto.Repository;

import com.prueba.proa.Producto.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByMarca(String marca);
}
