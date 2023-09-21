<%@page import="model.VerificaLoginDiretor"%>
<%@page import="model.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aluno</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<% 	Pessoa pessoa = (Pessoa)session.getAttribute("pessoa"); %>
</head>
<body>
	<img alt="imagemAluno" src="imagens/4212915_education_graduate_learning_student_icon.png">
	
	<div class="titulo">
		<h1 class="texto">Bem vindo(a), <%=pessoa.getNome().toUpperCase() %>!</h1>
	</div>	
	
	<div class="formCad">
		<label for="login">Login:</label>
			<input type="text" name="login" id="login" value="<%=pessoa.getLogin()%>" class="form-control" readonly>
		<br/>
		<label for="senha">Senha:</label>
			<input type="text" name="senha" id="senha"value="<%=pessoa.getSenha()%>" class="form-control" readonly>
		<br/>
		<label for="nome">Nome:</label>
			<input type="text" name="nome" id="nome" value="<%= pessoa.getNome()%>" class="form-control"  readonly>
		<br/>
		<label for="cpf">CPF:</label>
			<input type="text" name="cpf" id="cpf" value="<%=pessoa.getCpf()%>" class="form-control" readonly>
		<br/>
		<label for="idade">Idade:</label>
			<input type="text" name="idade" id="idade" value="<%=pessoa.getIdade()%>" class="form-control" readonly>
		<br/>
		<label for="endereco">Localização/estado:</label>
			<input type="text" name="endereco" id="endereco" value="<%=pessoa.getEndereco().getEstado()%>" class="form-control" readonly>
		<br/>
		<label for="cargo">Função:</label>
			<input type="text" name="cargo" id="cargo" value="<%=pessoa.getCargo().getCargo()%>" class="form-control" readonly>
		<br/>
		<label for="contato">Possui telefone fixo:</label>
			<input type="text" name="contato" id="contato" value="<%=pessoa.getContatos().getTelFixo()%>" class="form-control" readonly>
		<br/>
		<label for="contato2">Possui telefone movel:</label>
			<input type="text" name="contato2" id="contato2" value="<%=pessoa.getContatos().getTelMovel()%>" class="form-control" readonly>
		<br/>
			<div class="botaoSub">
				<a href="alterarCadastro.jsp" class="btn btn-primary">Alterar Cadastro</a>
			</div>
		</div>
	<a href="javascript: sair()" class="btn btn-danger" id="botaoSair">Sair</a>
<script src="scripts/Logout.js" type="text/javascript"></script>	
</body>
</html>