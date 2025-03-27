package com.jaime.practica4_api_rest.repositories;

import com.jaime.practica4_api_rest.models.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionRepository extends JpaRepository<Accion, Long> {
    // Aquí puedes definir métodos de consulta personalizados si lo deseas
}
