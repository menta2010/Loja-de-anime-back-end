package com.natalino.lojaanime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.natalino.lojaanime.entity.Produtos;
import com.natalino.lojaanime.repository.ProdutoRepository;
import com.natalino.lojaanime.services.exceptions.ObjetoNaoEncontrado;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutoRepository rep;
	
	
	public List<Produtos> findAll(){
		List<Produtos>lista = rep.findAll();
		return lista;	
	}
	
	public Produtos findById(Long id) {
	Optional<Produtos>prod = rep.findById(id);
	return prod.orElseThrow(()-> new ObjetoNaoEncontrado(
			"O objeto não foi encontrado! ID: "+ id + ", tipo: " +Produtos.class.getName() 
			));
		
	}
	
	public Produtos create(Produtos prod) {
		prod.setId(null);
		rep.save(prod);
		return prod;
		
	}
	
	public Produtos update(Produtos prod) {
		findById(prod.getId());
		return rep.save(prod);
		
	}
	
	public void delete(Long id) {
		findById(id);
		
		try {
		rep.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			
		
		}
	}
	
	
	
	

}
