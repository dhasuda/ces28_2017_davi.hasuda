package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements IServicoDB {
	private Connection conn;
	
	@Override
	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8066/busca", "admin", "senha");
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int persisteProcesso(IProcesso proc) {
		try {
			String statement = "INSERT INTO PROCESSO (id, nomeReclamante, telefone, email)" + 
			"VALUES ('" + proc.getID() + "', '" + proc.getNomeReclamante() + "', '" + proc.getTelefone()
			+ "', '" + proc.getEmail() + "');";
			
			return conn.createStatement().executeUpdate(statement);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}