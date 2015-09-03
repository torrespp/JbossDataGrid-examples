import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoDB2{
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

	//ResultSet rs = stmt.executeQuery("SELECT * FROM gecliente where usuarioaltaid='chabela'");
	//ResultSet rs = stmt.executeQuery("SELECT count(*) FROM gecliente where usuarioaltaid='chabela'");
	ResultSet rs = stmt.executeQuery(" SELECT folio, usuarioaltaid, cajaid , importemovto "
    + "FROM movimiento");
	while (rs.next()){
	//System.out.println("geCliente " + rs.getString("usuarioaltaid"));
	System.out.println("geCliente " + rs.getString(1) + " , " +  rs.getString(2)+ " , " + rs.getString(3)  + " , " + rs.getString(4));
		
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