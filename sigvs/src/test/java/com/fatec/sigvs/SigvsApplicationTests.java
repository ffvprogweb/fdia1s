package com.fatec.sigvs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.sigvs.model.IProdutoRepository;
import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.model.ProdutoDTO;
import com.fatec.sigvs.servico.IProdutoServico;

@SpringBootTest
class SigvsApplicationTests {
	@Autowired
	IProdutoServico produtoServico;
	@Autowired
	IProdutoRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	void validaPersistencia() {
		repository.deleteAll();
		Produto produto1 = new Produto("Eletrobomba 110V para Maquina de Lavar e Lava Louças", "maquina de lavar",51.66, 12);
		repository.saveAll(Arrays.asList(produto1));
		assertEquals(1, repository.count());
	}
	@Test
	void validaServico() {
		repository.deleteAll();
		ProdutoDTO produto1 = new ProdutoDTO("Eletrobomba 110V para Maquina de Lavar e Lava Louças", "maquina de lavar",51.66, 12);
		produtoServico.cadastrar(produto1);
		assertEquals(1, repository.count());
	}
}
