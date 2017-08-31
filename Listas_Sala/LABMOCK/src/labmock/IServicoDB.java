package labmock;


public interface IServicoDB {
	
	public void getDBConnection();
	public int persisteProcesso(IProcesso proc) ;
}
