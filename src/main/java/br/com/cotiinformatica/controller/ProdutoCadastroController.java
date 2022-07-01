package br.com.cotiinformatica.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Controller
public class ProdutoCadastroController {

	@RequestMapping(value = "/cadastrar-produto")
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView("products/cadastro");
		return modelAndView;

	}

	@RequestMapping(value = "/criar-produto")
	public ModelAndView criarProduto(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("products/cadastro");

		try {

			String nome = request.getParameter("nome");
			Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
			Integer preco = Integer.parseInt(request.getParameter("preco"));
			String descricao = request.getParameter("descricao");
			Date dataValidade = new SimpleDateFormat("yyy-MM-dd").parse(request.getParameter("data"));

			Produto produto = new Produto();
			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setPreco(preco);
			produto.setQuantidade(quantidade);
			produto.setDataValidade(dataValidade);

			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.inserir(produto);

			modelAndView.addObject("mensagem_sucesso", "Produto '" + produto.getNome() + "', cadastrado com sucesso.");

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

}
