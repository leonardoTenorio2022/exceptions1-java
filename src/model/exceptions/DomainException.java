package model.exceptions;

public class DomainException extends Exception{/*RuntimeException = Tipo de erro que o compilador não obriga a tratar
	Se usar ele roda normalmente, porém, caso exclua algum bloco, o programa interrompe, por não ser obrigado a trarar*/
	private static final long serialVersionUID = 1L;//Necessário delcarar a versão pois é do tipo serializable 
	
	public DomainException (String msg){//Cria-se o construtor para poder estanciar o DomainException
		super(msg);
	}

}
