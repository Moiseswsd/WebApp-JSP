/**
 * Confirma logout
 * @author Moises
 */
 function sair(){
	 let conf = confirm("Deseja realmente sair?");
	 
	 if(conf){
		 window.location.href = "logout";
	 } else {
		 return false;
	 }
}