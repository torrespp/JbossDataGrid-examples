import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class conectionDB{
	public static void main(String[] args)
	{
		long tiempoInicio = System.currentTimeMillis();
	String driver = "org.postgresql.Driver";
	String connectString = "jdbc:postgresql://localhost:5432/sace";
	String user = "postgres";
	String password = "postgres";

	try{
	Class.forName(driver);
	Connection con = DriverManager.getConnection(connectString, user , password);
	Statement stmt = con.createStatement();

	//ResultSet rs = stmt.executeQuery("SELECT * FROM gecliente");
	ResultSet rs = stmt.executeQuery("SELECT count(*) FROM gecliente");

	while (rs.next()){
	//System.out.println("geCliente " + rs.getString("usuarioaltaid"));
	System.out.println("geCliente " + rs.getString(1));
	}

	stmt.close();
	con.close();
	long totalTiempo = System.currentTimeMillis() - tiempoInicio; 
	System.out.println("El tiempo total de la ejecución es :" + totalTiempo + " miliseg"); 
	}

	catch ( Exception e ){
	System.out.println(e.getMessage());
	}
	}
	}