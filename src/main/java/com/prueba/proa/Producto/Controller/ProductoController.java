package com.prueba.proa.Producto.Controller;

import com.prueba.proa.Producto.Entity.Producto;
import com.prueba.proa.Producto.Repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoRepository productoRepository;

    /*REGISTRO DE PRODUCTO CON LOS SIGUIENTES CAMPOS:
        Producto
        Marca
        Descripción
        precio
     */
    @PostMapping
    public Producto registrarProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    //Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles){
        return productoRepository.findById(id).map(producto -> {
            producto.setProducto(productoDetalles.getProducto());
            producto.setMarca(productoDetalles.getMarca());
            producto.setDescripcion(productoDetalles.getDescripcion());
            producto.setPrecio(productoDetalles.getPrecio());

            return ResponseEntity.ok(productoRepository.save(producto));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Buscar Servicio con parametros en Header ID_CLIENT_SESSION = 78965088

    @GetMapping("/buscar")
    public  ResponseEntity<List<Producto>> buscarPormarca(@RequestParam String marca, @RequestHeader("ID_CLIENT_SESSION") String clientSessionId){
        if(!"78965088".equals(clientSessionId)){

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Collections.emptyList());
        }
        List<Producto> productos = productoRepository.findByMarca(marca);
        productos.forEach(producto -> logger.info("Producto encontrado: {}", producto));

        return ResponseEntity.ok(productos);
    }

}
