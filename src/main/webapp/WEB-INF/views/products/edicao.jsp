<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição de Produtos</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<!-- menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"></jsp:include>

	<div class="container mt-3">

		<h3>Edição de Produtos</h3>
		<p>Utilize o formulário para alterar o produto cadastrado no
			sistema.</p>
		<hr />

		<form action="atualizar-produto">

			<!--  campo oculto -->
			<input type="hidden" name="idProduto" value="${produto.idProduto}" />

			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome do produto:</label> <input type="text" name="nome"
						class="form-control" placeholder="Digite aqui" required="required"
						value="${produto.nome}" />
				</div>
				<div class="col-md-3">
					<label>Quantidade:</label> <input type="number" name="quantidade"
						class="form-control" required="required"
						value="${produto.quantidade}" />
				</div>
				<div class="col-md-3">
					<label>Preço:</label> <input type="number" name="preco"
						class="form-control" required="required" value="${produto.preco}" />
				</div>
			<div class="row mb-3">
				<div class="col-md-9">
					<label>Descrição do Produto</label>
					<textarea name="descricao" class="form-control" required="required">${produto.descricao}</textarea>
				</div>
				<div class="col-md-3">
					<label>Data de validade:</label> <input type="date" name="data"
						class="form-control" required="required"
						value='<fmt:formatDate value="${produto.dataValidade}" pattern="yyyy-MM-dd"/>' />
				</div>
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Salvar Alterações"
						class="btn btn-primary" /> <a
						href="/projetodesafio01/consultar-produto" class="btn btn-light">
						Voltar para a consulta </a>

				</div>
			</div>

		</form>

		<div class="mt-2">
			<strong class="text-success">${mensagem_sucesso}</strong>
		</div>

		<div class="mt-2">
			<strong class="text-danger">${mensagem_erro}</strong>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
