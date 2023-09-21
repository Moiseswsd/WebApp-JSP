<%@page import="model.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Escola</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="imagens/6771584_black board_education_learning_nuclear_school_icon.png">
<link rel="stylesheet" href="style.css">
<script src="scripts/Login.js" type="text/javascript"></script>	
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div id="id1">
		<img alt="Nao foi possivel carregar a imagem" src="imagens/2064501_alphabet_education_learn_school_student_icon.png">
	</div>
	<div id="id4" >
		<h3 >Entre com seu cadastro:</h3>
	</div>
		<div id="id2">
				<form action="logar" id="form1" name="frmlogin" onsubmit="return verificarLogin();">
					<div class="input-group mb-3">
						<input type="text" name="login" id="login" placeholder="Usuario" class="form-control"> 
						<br/>
					</div>
					<div class="input-group mb-3">
						<input type="password" name="senha" id="senha" placeholder="Senha" class="form-control">
						<br/>
					</div>
					<div id="id5">
						<input type="submit" value="Login" class="btn btn-primary">
					</div>
						<br/>
				</form>
				<%if(request.getAttribute("loginInvalido") != null){ request.setAttribute("loginInvalido", null);%> <p class="msg" id="msg">Login/senha inválidos</p> <% } %>
		</div>	
	<div id="id3">
		<a href="Cadastrar.jsp" class="cad">Não possui cadastro?</a>
	</div>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>