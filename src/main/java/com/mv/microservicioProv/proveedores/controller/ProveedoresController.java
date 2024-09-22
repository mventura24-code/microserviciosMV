package com.mv.microservicioProv.proveedores.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.microservicioProv.proveedores.services.*;
import com.mv.microservicioProv.proveedores.entity.*;

public class ProveedoresController {
	
	@Autowired
	protected IProveedores proveedoresService;

	@GetMapping
	public ResponseEntity<List<Proveedores>> getAllProveedores() {
	    return ResponseEntity.ok(proveedoresService.findAll());
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Proveedores>> findAll() {
	    return ResponseEntity.ok(proveedoresService.findAll());
	}

	@PostMapping("/save")
	public ResponseEntity<Proveedores> save(@RequestBody Proveedores proveedores) {
	    return ResponseEntity.ok(proveedoresService.save(proveedores));
	}

	@PutMapping(path = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Proveedores proveedores) {
	    Proveedores updateProveedor = proveedoresService.update(id, proveedores);
	    if (updateProveedor != null) {
	        return ResponseEntity.ok(updateProveedor);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
	    Integer response = proveedoresService.deleteById(id);
	    if (response == 204) {
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } else {
	        return ResponseEntity.notFound().build(); // 404 Not Found
	    }
	}


	

}
