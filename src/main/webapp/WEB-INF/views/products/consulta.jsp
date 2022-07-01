<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Produtos</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<!-- menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"></jsp:include>

	<div class="container mt-3">

		<h3>Consulta de Produtos</h3>
		<p>Pesquise os produtos cadastrados no sistema.</p>
		<hr />

		<p>Digite o nome do produto para consulta:</p>

		<form method="post"  action="pesquisar-produto">
			<div class="row">
				<div class="col-md-4">
					<input type="text" class="form-control" name="nome"
						value="${nome}" required="required" />
				</div>
				<div class="col-md-3">
					<input type="submit" class="btn btn-success" value="Pesquisar" />
				</div>
			</div>
		</form>

		<div class="text-danger mt-2">
			<strong>${mensagem_erro}</strong>
		</div>
		
		<div class="text-success mt-2">
			<strong>${mensagem_sucesso}</strong>
		</div>

		<table class="table table-hover table-sm mt-4">
			<thead>
				<tr>
					<th>Produto</th>
					<th>Quantidade</th>
					<th>Preço</th>
					<th>Descrição</th>
					<th>Data Validade</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${produto}" var="item">

					<tr>
						<td>${item.nome}</td>
						<td>${item.quantidade}</td>
						<td>${item.preco}</td>
						<td>${item.descricao}</td>
						<td><fmt:formatDate value="${item.dataValidade}" pattern="dd/MM/yyyy" />
						</td>
						<td><a
							href="/projetodesafio01/editar-produto?id=${item.idProduto}"
							class="btn btn-primary btn-sm"> Editar </a> <a
							href="/projetodesafio01/excluir-produto?id=${item.idProduto}"
							onclick="return confirm('Deseja realmente excluir o produto?\n${item.nome}');"
							class="btn btn-danger btn-sm"> Excluir </a></td>
					</tr>

				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">Quantidade de produtos cadastrados:
						${produto.size()}</td>
				</tr>
			</tfoot>
		</table>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
