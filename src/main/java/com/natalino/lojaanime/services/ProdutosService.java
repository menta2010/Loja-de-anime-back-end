package com.natalino.lojaanime.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natalino.lojaanime.entity.Produtos;
import com.natalino.lojaanime.repository.ProdutoRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutoRepository rep;
	
	
	public List<Produtos> findAll(){
		List<Produtos>lista = rep.findAll();
		return lista;	
	}
	
	public Produtos create(Produtos prod) {
		prod.setId(null);
		rep.save(prod);
		return prod;
		
	}
	
	
	
	

}
