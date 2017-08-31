package labmock;

public interface IProcesso {
	public long getID();
	public String getNomeReclamante();
	public String getTelefone();
	public String getEmail();
	public IVirtualProcess getVirtualProcess();
}
