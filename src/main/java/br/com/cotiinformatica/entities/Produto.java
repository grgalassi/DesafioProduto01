package br.com.cotiinformatica.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer preco;
	private Integer quantidade;
	private Date dataValidade;

}
