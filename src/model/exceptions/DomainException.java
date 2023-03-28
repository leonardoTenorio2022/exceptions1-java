package model.exceptions;

public class DomainException extends Exception{/*RuntimeException = Tipo de erro que o compilador n�o obriga a tratar
	Se usar ele roda normalmente, por�m, caso exclua algum bloco, o programa interrompe, por n�o ser obrigado a trarar*/
	private static final long serialVersionUID = 1L;//Necess�rio delcarar a vers�o pois � do tipo serializable 
	
	public DomainException (String msg){//Cria-se o construtor para poder estanciar o DomainException
		super(msg);
	}

}
