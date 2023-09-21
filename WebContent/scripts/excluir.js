/**
 * Confirma exclusao
 * @author Moises
 */

 function confirmar(pessoaID){
	 let conf = confirm("Deseja realmente excluir este cadastro?");
	 
	 if(conf){
		 window.location.href = "deletar?pessoaID=" + pessoaID;
	 } else{
		 return false;
	 }
 }
 