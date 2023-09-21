<%@page import="model.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar cadastro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<% Pessoa pessoa = (Pessoa)session.getAttribute("edicao");
	if(pessoa == null){
	pessoa = new Pessoa();
	}%>
</head>
<body>
	<div class="titulo">
		<h1>Editando cadastro!</h1>
	</div>		
	<div class="formCad">
	<form action="editarPt2" name="cadastro" onsubmit="return validarCadastro();">
		<label for="pessoaID">Identificador da conta (ID)</label>
		<input type="text" name="pessoaID" id="pessoaID" value="<%=pessoa.getPessoaID()%>" class="form-control" readonly>
		<br/>
		<label for="login">Login</label>
		<input type="text" name="login" id="login" value="<%=pessoa.getLogin()%>" class="form-control"> 
		<br/>
		<label for="senha">Senha</label>
		<input type="password" name="senha" id="senha"value="<%=pessoa.getSenha()%>" class="form-control">
		<br/>
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome" value="<%= pessoa.getNome()%>" class="form-control">
		<br/>
		<label for="cpf">CPF</label>
		<input type="text" name="cpf" id="cpf" value="<%=pessoa.getCpf()%>" class="form-control">
		<br/>
		<label for="idade">Idade</label>
		<input type="text" name="idade" id="idade" value="<%=pessoa.getIdade()%>" class="form-control">
		<br/>
		<label for="endereco">Localização/estado:</label>
		<select name="endereco" id="endereco" class="form-select">
			<option value="" disabled selected>estado</option>
			<option value="1">Brasília-DF</option>	
			<option value="2">Acre</option>
			<option value="3">Alagoas</option>
			<option value="4">Amapa</option>
			<option value="5">Amazonas</option>
			<option value="6">Bahia</option>
			<option value="7">Ceara</option>
			<option value="8">Espirito Santo</option>
			<option value="9">Goias</option>
			<option value="10">Maranhao</option>
			<option value="11">Mato Grosso</option>
			<option value="12">Mato Grosso do Sul</option>
			<option value="13">Minas Gerais</option>
			<option value="14">Para</option>
			<option value="15">Paraiba</option>
			<option value="16">Parana</option>
			<option value="17">Pernambuco</option>
			<option value="19">Piaui</option>
			<option value="20">Rio de Janeiro</option>
			<option value="21">Rio Grande do Norte</option>
			<option value="23">Rio Grande do Sul</option>
			<option value="24">Rondonia</option>
			<option value="25">Roraima</option>
			<option value="26">Santa Catarina</option>
			<option value="27">Sao Paulo</option>
			<option value="28">Sergipe</option>
			<option value="29">Tocantins</option>
		</select>
		<br/>
		<label for="cargo">Função:</label>
		<select name="cargo" id="cargo" class="form-select">
			<option value="" disabled selected>Função</option>
			<option value="1">Diretor</option>
			<option value="2">Professor</option>
	 		<option value="3">Aluno</option>
	 	</select>
		<br/>
		<label for="contato">Contato:</label>
		<select name="contato" id="contato" class="form-select">
			<option value="" disabled selected>Formas de Contato disponíveis</option>
	 		<option value="1">Possui fixo e celular</option>
			<option value="2">Possui celular mas não Fixo</option>
	 		<option value="3">Possui fixo mas não celular</option>
	 		<option value="4">Não possui ambos</option>
		</select>
		<br/>
			<div class="botaoSub">
				<input type="submit" value="Alterar" class="btn btn-primary">
			</div>
	</form>
	</div>
<a href="javascript: sair()" class="btn btn-danger" id="botaoSair">Sair</a> 
<%if(session.getAttribute("info") != null){ session.setAttribute("info", null);%> <p id="msg">Login e/ou CPF já está sendo utilizado!</p> <% } %>
<script src="scripts/Login.js" type="text/javascript"></script>	
<script src="scripts/Logout.js" type="text/javascript"></script>	
<script src="scripts/Cadastrar.js" type="text/javascript"></script>	
</body>
</html>