package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ProdutoRepository {

	public void inserir(Produto produto) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(
				"insert into produto(nome, quantidade, preco, descricao, dataValidade) values(?,?,?,?,?)");

		statement.setString(1, produto.getNome());
		statement.setInt(2, produto.getQuantidade());
		statement.setInt(3, produto.getPreco());
		statement.setString(4, produto.getDescricao());
		statement.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(produto.getDataValidade()));
		statement.execute();

		connection.close();

	}

	public void atualizar(Produto produto) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(
				"update produto set nome=?, quantidade=?, preco=?, descricao=?, dataValidade=? where idproduto=?");

		statement.setString(1, produto.getNome());
		statement.setInt(2, produto.getQuantidade());
		statement.setInt(3, produto.getPreco());
		statement.setString(4, produto.getDescricao());
		statement.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(produto.getDataValidade()));
		statement.setInt(6, produto.getIdProduto());
		statement.execute();

		connection.close();
	}

	public void excluir(Produto produto) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from produto where idproduto=?");

		statement.setInt(1, produto.getIdProduto());
		statement.execute();

		connection.close();
	}

	public List<Produto> obterTodos() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from produto order by dataValidade, nome");

		ResultSet resultSet = statement.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (resultSet.next()) {

			Produto produto = new Produto();

			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getInt("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setDataValidade(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dataValidade")));

			lista.add(produto);

		}

		connection.close();
		return lista;

	}

	public Produto obterPorId(Integer idProduto) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from produto where idproduto=?");

		statement.setInt(1, idProduto);
		ResultSet resultSet = statement.executeQuery();

		Produto produto = null;

		if (resultSet.next()) {

			produto = new Produto();

			produto.setIdProduto(resultSet.getInt("idproduto"));
			produto.setNome(resultSet.getString("nome"));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getInt("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setDataValidade(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dataValidade")));

		}

		connection.close();
		return produto;

	}
	
	public List<Produto> obterPorNome(String nome) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from produto order by nome, dataValidade");

		ResultSet resultSet = statement.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (resultSet.next()) {

			Produto produto = new Produto();

			
			produto.setNome(resultSet.getString("nome"));
			produto.setQuantidade(resultSet.getInt("quantidade"));
			produto.setPreco(resultSet.getInt("preco"));
			produto.setDescricao(resultSet.getString("descricao"));
			produto.setDataValidade(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dataValidade")));

			lista.add(produto);

		}

		connection.close();
		return lista;


	}

}