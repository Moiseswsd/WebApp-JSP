/**
 * Verifica o preenchimento correto do formulario
 * @author Moises
 */

 function validarCadastro(){
	 let login = cadastro.login.value;
	 let senha = cadastro.senha.value;
	 let nome = cadastro.nome.value;
	 let cpf = cadastro.cpf.value;
	 let idade = cadastro.idade.value;
	 let endereco = cadastro.endereco.value;
	 let cargo = cadastro.cargo.value;
	 let contato = cadastro.contato.value;
	 var numberPattern = /^\d+$/;
	 var letterPattern = /^[A-Za-z]+$/;
	 
	if(login === "" || login.length < 4 || login.length > 20){ /*Descubra uma maneira de não permitir logins iguais*/
		alert("Login inválido! O login não pode ter menos de 4 dígitos nem mais que 20!");
		cadastro.login.focus();
		return false;
	} else if (senha === "" || senha.length < 8 || senha.length > 20){
		alert("Senha Inválida! Deve ter pelo menos 8 caracteres e no máximo 20!");
		cadastro.senha.focus();
		return false;
	} else if (!letterPattern.test(nome) || nome === "" || nome.length > 40 || nome.length < 3){
		alert("Nome inválido! Deve conter apenas caracteres (a-z)), no mínimo 3 e no máximo 40!");
		cadastro.nome.focus();
		return false;
	} else if (!numberPattern.test(cpf) || cpf === "" || cpf.length !== 11){
		alert("CPF inválido! Deve conter apenas números, totalizando 11 dígitos!");
		cadastro.cpf.focus();
		return false;
	} else if (!numberPattern.test(idade) || idade === "" || idade.length > 2){  /* Verificar se idade não pode ser negativa*/
		alert("Idade inválida!");
		cadastro.idade.focus();
		return false;
	} else if (endereco === ""){
		alert("Preencha o endereço!");
		cadastro.endereco.focus();
		return false;
	} else if (cargo === ""){
		alert("Preencha a função!");
		cadastro.cargo.focus();
		return false;
	} else if (contato === ""){
		alert("Preencha o contato!");
		cadastro.contato.focus();
		return false;
	} else{
		return true;
	}
	
 }