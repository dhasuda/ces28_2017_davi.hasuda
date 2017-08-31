package labmock;

import java.sql.SQLException;

public class SIAPJ {
	
	private IServicoEmail email;
	private IServicoDB db;
	private IValidatorProcesso procVal;
	
	public SIAPJ(IServicoEmail email, IServicoDB db, IValidatorProcesso procVal) {
		super();
		this.email = email;
		this.db = db;
		this.procVal = procVal;
	}

	public void criaReclamacao(IProcesso processo) throws SQLException {
		//1) Checa se o processo está no formato correto
		boolean result = procVal.validaProcesso(processo);
		
		//2) se estiver correto
		if (result==true){
			//2.1 ele persiste o processo no banco de dados 
			db.persisteProcesso(processo);
			
			//2.2 envia uma mensagem de e-mail para o usuário que o processo foi aceito 
			email.sendEmail(processo.getEmail(), "Processo aceito");
		}
		
		else {
			//3) se estiver incorreto, ele envia uma mensagem de e-mail para o usuário informando os problemas.
			email.sendEmail(processo.getEmail(), "Existem erros em seu processo");
		}
	}

}
