package com.datapar.encuesta.service;

import java.util.List;
import java.util.Optional;

import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datapar.encuesta.entity.Satisfaccion;
import com.datapar.encuesta.repository.SatisfaccionRepositorio;

@Service
@Transactional
public class SatisfaccionService {

	@Autowired
	SatisfaccionRepositorio satisfaccionRepositorio;
	
	public List<Satisfaccion> getAll(){
        return satisfaccionRepositorio.findAll();
    }
	
	public Optional<Satisfaccion> getByNombre(String nombre){
        return satisfaccionRepositorio.findByNombre(nombre);
    }

    public boolean existsByEmail(String email){
        return satisfaccionRepositorio.existsByEmail(email);
    }

    public void save(Satisfaccion satisfaccion){
        satisfaccionRepositorio.save(satisfaccion);
    }
    
    public List<JSONObject> findByGroup(){
    	return satisfaccionRepositorio.findByGroup();
    }
}