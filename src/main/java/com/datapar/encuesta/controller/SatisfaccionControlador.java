package com.datapar.encuesta.controller;

import java.util.List;

import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapar.encuesta.dto.Mensaje;
import com.datapar.encuesta.entity.Satisfaccion;
import com.datapar.encuesta.service.SatisfaccionService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class SatisfaccionControlador {

	@Autowired
	private SatisfaccionService satisfaccionService;
	
	//metodo para listar resultados de la encuesta
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/listar")	
	public List<Satisfaccion> list(){
        List<Satisfaccion> list = satisfaccionService.getAll();
        return list;
    }
	
	//metodo para listar resultados de la encuesta
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/estadistica")	
	public List<JSONObject> estadistica(){
		List<JSONObject> list = satisfaccionService.findByGroup();
	    return list;
	}
	
	//metodo para listar resultados de la encuesta y estadistica
		@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
		@GetMapping("/listado")	
		public Object[] listadoEstadistica(){
			List<Satisfaccion> lis = satisfaccionService.getAll();
			List<JSONObject> est = satisfaccionService.findByGroup();
		    return new Object[]{lis, est};
		}
	
		
	//metodo para registrar encuesta
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PreAuthorize("hasAnyRole('ADMIN', 'USER', '')")
	@PostMapping("/registrar")
	public ResponseEntity<?> registro(@RequestBody Satisfaccion satisfaccionDto){		
		satisfaccionService.save(satisfaccionDto);
		return new ResponseEntity(new Mensaje("Encuesta Registrada"), HttpStatus.OK);
	}
}
