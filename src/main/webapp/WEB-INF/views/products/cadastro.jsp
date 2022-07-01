<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<!-- menu do sistema -->
	<jsp:include page="/WEB-INF/views/components/menu.jsp"></jsp:include>

	<div class="container mt-3">

		<h3>Cadastro de Produtos</h3>
		<p>Preencha o formulário para incluir os produtos no sistema.</p>
		<hr />

		<form method="post" action="criar-produto">

			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome do produto:</label> <input type="text" name="nome"
						class="form-control" placeholder="Digite aqui" required="required" />
				</div>
				<div class="col-md-3">
					<label>Quantidade:</label> <input type="number" name="quantidade"
						class="form-control" required="required" />
				</div>
				<div class="col-md-3">
					<label>Preço:</label> <input type="number" name="preco"
						class="form-control" required="required" />
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-9">
					<label>Descrição do Produto</label>
					<textarea name="descricao" class="form-control" required="required"></textarea>
				</div>
				<div class="col-md-3">
					<label>Data de validade:</label> <input type="date" name="data"
						class="form-control" required="required" />
				</div>

			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Realizar Cadastro"
						class="btn btn-success" /> <input type="reset" value="Limpar"
						class="btn btn-light" />
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
