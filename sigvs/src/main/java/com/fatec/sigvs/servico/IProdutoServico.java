package com.fatec.sigvs.servico;

import java.util.List;
import java.util.Optional;

import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.model.ProdutoDTO;

public interface IProdutoServico {
	public Optional<Produto> cadastrar(ProdutoDTO produto);

	public Optional<ProdutoDTO> consultaPorId(Long id);

	public List<Produto> consultaCatalogo();

	public ProdutoDTO atualizar(Long id, ProdutoDTO produto);

	public void excluir(Long id);
}
