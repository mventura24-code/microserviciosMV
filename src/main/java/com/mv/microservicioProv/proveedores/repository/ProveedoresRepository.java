package com.mv.microservicioProv.proveedores.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.mv.microservicioProv.proveedores.entity.*;

public interface ProveedoresRepository extends CrudRepository<Proveedores, UUID> {
	

}
