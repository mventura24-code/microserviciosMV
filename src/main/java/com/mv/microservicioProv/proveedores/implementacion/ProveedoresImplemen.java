package com.mv.microservicioProv.proveedores.implementacion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.microservicioProv.proveedores.services.*;
import com.mv.microservicioProv.proveedores.entity.Proveedores;
import com.mv.microservicioProv.proveedores.repository.*;
@Service

public class ProveedoresImplemen implements IProveedores {
	@Autowired
	protected ProveedoresRepository proveedoresRepository;

	@Override
	public List<Proveedores> findAll() {
	    return (List<Proveedores>) proveedoresRepository.findAll();
	}

	@Override
	public Proveedores save(Proveedores proveedores) {
	    Proveedores.setId(UUID.randomUUID());
	    return proveedoresRepository.save(proveedores);
	}

	@Override
	public Proveedores update(UUID id, Proveedores proveedores) {
	    Optional<Proveedores> optionalProveedor = proveedoresRepository.findById(id);
	    if (optionalProveedor.isPresent()) {
	        Proveedores existingProveedor = optionalProveedor.get();
	        existingProveedor.setNombre(proveedores.getNombre());
	        existingProveedor.setDireccion(proveedores.getDireccion());
	        existingProveedor.setTelefono(proveedores.getTelefono());
	        return proveedoresRepository.save(existingProveedor);
	    }
	    return null;
	}

	@Override
	public Integer deleteById(UUID id) {
	    if (!proveedoresRepository.existsById(id)) {
	        return 404; // Not Found
	    } else {
	        proveedoresRepository.deleteById(id);
	        return 204; // No Content
	    }
	}

}