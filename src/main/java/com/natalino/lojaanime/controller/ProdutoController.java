package com.natalino.lojaanime.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	ResponseEntity<Void>create(@RequestBody Produtos produtos){
		 produtos = prod.create(produtos);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				  path("/{id}").buildAndExpand(produtos.getId()).toUri();
			return	ResponseEntity.created(uri).build();
		
		
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Void>update(@RequestBody Produtos produto,@PathVariable Long id){
		prod.findById(id);
		prod.update(produto);
		return ResponseEntity.noContent().build();
	}
	
	

}
