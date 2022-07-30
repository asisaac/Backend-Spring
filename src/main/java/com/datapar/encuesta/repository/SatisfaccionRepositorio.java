package com.datapar.encuesta.repository;

import java.util.List;
import java.util.Optional;

import org.jooq.tools.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datapar.encuesta.entity.Satisfaccion;

@Repository
public interface SatisfaccionRepositorio extends JpaRepository<Satisfaccion, Long> {
	Optional<Satisfaccion> findByNombre(String nombre);
    boolean existsByEmail(String email);
    @Query(value = "select 'Calif. : ' || calificacion as name, count(calificacion) as value from satisfaccion group by calificacion", nativeQuery = true)
    List<JSONObject> findByGroup();
}
