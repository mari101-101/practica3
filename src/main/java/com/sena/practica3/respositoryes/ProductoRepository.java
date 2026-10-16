package com.sena.practica3.respositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.practica3.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
