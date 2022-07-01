package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Controller
public class ProdutoConsultaController {
	
	
	@RequestMapping(value = "/consultar-produto")
	public ModelAndView consulta(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("products/consulta");

		try {

			ProdutoRepository produtoRepository = new ProdutoRepository();
			List<Produto> lista = produtoRepository.obterTodos();

			modelAndView.addObject("produto", lista);

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/pesquisar-produto", method = RequestMethod.POST)
	public ModelAndView pesquisarProduto(String nome, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("products/consulta");

		try {
			
			ProdutoRepository produtoRepository = new ProdutoRepository();
			List<Produto> lista = produtoRepository.obterPorNome(nome);

			modelAndView.addObject("produto", lista);
			modelAndView.addObject("nome");
			

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());

		}

		return modelAndView;
	}

	@RequestMapping(value = "/excluir-produto")
	public ModelAndView excluirProduto(Integer id, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("products/consulta");

		try {

			
			Produto produto = new Produto();
			produto.setIdProduto(id);
			

			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.excluir(produto);

			modelAndView.addObject("mensagem_sucesso", "Produto excluído com sucesso.");

			List<Produto> lista = produtoRepository.obterTodos();
			modelAndView.addObject("produto", lista);

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;

	}
	
}