package com.natalino.lojaanime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natalino.lojaanime.entity.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

}
