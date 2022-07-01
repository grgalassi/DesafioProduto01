package br.com.cotiinformatica.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Controller
public class ProdutoEdicaoController {
	
	@RequestMapping(value = "/editar-produto")
	public ModelAndView edicao(Integer id, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("products/edicao");

		try {


			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.obterPorId(id);

			modelAndView.addObject("produto", produto);

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
		
	}
	
	@RequestMapping(value = "/atualizar-produto")
	public ModelAndView atualizarCompromisso(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("products/edicao");

		try {

			
			Produto produto = new Produto();

			produto.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
			produto.setNome(request.getParameter("nome"));
			produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			produto.setPreco(Integer.parseInt(request.getParameter("preco")));
			produto.setDescricao(request.getParameter("descricao"));
			produto.setDataValidade(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));

			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.atualizar(produto);

			modelAndView.addObject("mensagem_sucesso", "Produto atualizado com sucesso.");
			modelAndView.addObject("produto", produto);

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;

	}

	
}
	
