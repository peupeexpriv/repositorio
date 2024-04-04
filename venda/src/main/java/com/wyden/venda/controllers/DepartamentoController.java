package com.wyden.venda.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
}
