package postgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
public class DemoDb {
	private static String url = "jdbc:postgresql://localhost:5432/correio";
	private static String user = "postgres";
	private static String senha = "gabriel8330";

	public static void main(String[] args) {
		Scanner scr = new Scanner (System.in);
		int code;
		int validacao_BD = 0;
		System.out.println(" ----------------------");
		System.out.println("|  TRANSPORTES GABRIEL |");
		System.out.println(" ----------------------");
		
		System.out.println(" ----------------------------------------------------");
		System.out.println("|Digite o código do produto:                         |");
		code = scr.nextInt();
		System.out.println("-----------------------------------------------------");
		System.out.println("\n");
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, senha);
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM public.rastreio");
			ResultSet rs = stmt.executeQuery();
			System.out.println("-----------------------------------------------------------------------------------------");
			while (rs.next()) {	
				if(rs.getInt(1) == code) {
					System.out.println("Codigo: "+rs.getInt(1)+"  |  DATA: "+rs.getTimestamp(8)+"  |  Status: "+rs.getString(3)+"  |  Local: "+rs.getString(2));
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("Codigo: "+rs.getInt(1)+"  |  DATA: "+rs.getTimestamp(9)+"  |  Status: "+rs.getString(5)+"  |  Local: "+rs.getString(4));
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("Codigo: "+rs.getInt(1)+"  |  DATA: "+rs.getTimestamp(10)+"  |  Status: "+rs.getString(7)+"  |  Local: "+rs.getString(6));
					System.out.println("-----------------------------------------------------------------------------------------");
					validacao_BD++;
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		if (validacao_BD == 0) {
			System.out.println("Não foi encontrado nenhum código "+code+" no nosso Banco de dados!");
		}
		scr.close();
	}

}
