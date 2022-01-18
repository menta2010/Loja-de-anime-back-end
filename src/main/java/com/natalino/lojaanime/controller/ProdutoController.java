package com.natalino.lojaanime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natalino.lojaanime.entity.Produtos;
import com.natalino.lojaanime.services.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	
	@Autowired
	private ProdutosService prod;
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Produtos>lista = prod.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Produtos produto = prod.findById(id);
		return ResponseEntity.ok().body(produto);
		
	}
	
	@PostMapping
	ResponseEntity<?>create(@RequestBody Produtos produtos){
		Produtos produtos1 = prod.create(produtos);
		return ResponseEntity.ok().body(produtos1);
		
		
	}
	
	
	

}
