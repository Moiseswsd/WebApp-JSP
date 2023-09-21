<%@page import="model.VerificaLoginDiretor"%>
<%@page import="model.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Todos os cadastros</title>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="scripts/excluir.js" type="text/javascript"></script>
</head>
<body>
<% @SuppressWarnings("unchecked")
	ArrayList<Pessoa> lista = (ArrayList<Pessoa>)session.getAttribute("lista");
	Pessoa pessoa = (Pessoa)session.getAttribute("pessoa");
	if(pessoa == null){
		pessoa = new Pessoa();
	}
	VerificaLoginDiretor v = new VerificaLoginDiretor();
	v.verificaLogin(session, request, response, pessoa); %>
 	<div class="titulo">
		<h1 class="texto">Todos os cadastros até o momento!</h1>
	</div>
	<a href="criar.jsp" id="link" class="btn btn-success">Criar novo cadastro</a> 
	<a href="javascript: sair()" class="btn btn-danger" id="botaoSair">Sair</a> 
	<a href="relatorio" id="relatorio" class="btn btn-dark">Gerar pdf</a> 
	<a href="diretor.jsp" class="btn btn-info" id="inicio">Início</a>
<div id="tabela">
	 <table id="tabela1">
	 	<thead>
	 			<tr>
	 				<td>Nome</td>
	 				<td>Função</td>
	 				<td>Cadastro ID</td>
	 				<td > </td>
	 			</tr>	
	 	</thead>
	 <tbody>
	 <%for(int i=0; i<lista.size(); i++) {%>
				 <tr>
	 				<td><%=lista.get(i).getNome().toUpperCase()%></td>
	 				<td><%=lista.get(i).getCargo().getCargo()%></td>
	 				<td><%=lista.get(i).getPessoaID()%></td>
	 				<% if(!lista.get(i).getCargoID().equals("1")) {%>
	 				<td><a href="editar?pessoaID=<%=lista.get(i).getPessoaID()%>" class="btn btn-warning" id="branco">Editar</a> <a href="javascript: confirmar(<%=lista.get(i).getPessoaID()%>)" class="btn btn-danger">Excluir</a></td>
	 					<%}else {%> <td id="centralizar"> <a href="ver.jsp" class="btn btn-info" id="branco">Visualizar</a> </td> <% }%>	
	 			</tr><%} %>
	 </tbody>
	 </table>
</div>
<script src="scripts/Logout.js" type="text/javascript"></script>			
</body>
</html>