package com.wyden.venda.controllers;
import java.security.PublicKey;
import java.util.List;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyden.venda.entity.Departamento;
import com.wyden.venda.repositories.DepartamentoRepository;

@RestController
@RequestMapping(value = "/department")
public class DepartamentoController {
	
	@Autowired
	DepartamentoRepository repository;
	
	public Departamento getDepartamentoId(@PathVariable Long id) {
		
		return repository.findById(id).get();
	}
	@GetMapping
	public List<Departamento> findAllDepartamentos() {
		List<Departamento> result = repository.findAll();
		return result;
	}
	
	@PutMapping(value="/{id}")
	public void updateDepartamento(@RequestBody Departamento dep, @PathVariable Long id) {
		
		Departamento dep2 = repository.findById(id).get();
		dep2 = dep;
		repository.save(dep2);
	}
	@PostMapping()
	public void insertDepartamento(@RequestBody Departamento dep, @PathVariable Long id) {
		repository.save(dep);
	}
}
