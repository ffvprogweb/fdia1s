package com.fatec.sigvs.controller;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.model.ProdutoDTO;
import com.fatec.sigvs.servico.IProdutoServico;

@CrossOrigin("*") // desabilita o cors do spring security
@RestController
@RequestMapping("/api/v1/produtos")
public class APIProdutoController {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	IProdutoServico produtoServico;

// consulta todos os produtos cadastrados
	@GetMapping
	public ResponseEntity<Object> consultaTodos() {
		logger.info(">>>>>> apicontroller consulta todos");
		return ResponseEntity.status(HttpStatus.OK).body(produtoServico.consultaCatalogo());
	}

// consulta produto pelo codigo
	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> consultaPorId(@PathVariable("id") Long id) {
		logger.info(">>>>>> apicontroller consulta por id");
		ProdutoDTO p = produtoServico.consultaPorId(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(produtoServico.consultaPorId(id).get());
	}

	@PostMapping
	public ResponseEntity<Object> cadastrarCliente(@RequestBody ProdutoDTO p) {
		logger.info(">>>>>> apicontroller cadastrar produto iniciado ");
		try {
			Optional<Produto> produto = produtoServico.cadastrar(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(produto.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}