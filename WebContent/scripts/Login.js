/**
 *  Verifica se o usuario preencheu os 'inputs' e remove o alerta de login invalido apos 4 segundos 
 * @author Moises
 */
 function verificarLogin(){
	 let login = frmlogin.login.value;
	 let senha = frmlogin.senha.value;
 	if(login === ""){
		 alert("Login inválido!");
		 frmlogin.login.focus();
		 return false;
	 } else if (senha === ""){
		 alert("Senha inválida!");
		 frmlogin.senha.focus();
		 return false;
	 } else{
		 return true;
	 }
 }
 
 function removerMsg(){
	 var mensagem = document.getElementById("msg");
	 mensagem.style.display = "none";
 }
 
 setTimeout(removerMsg, 4000);