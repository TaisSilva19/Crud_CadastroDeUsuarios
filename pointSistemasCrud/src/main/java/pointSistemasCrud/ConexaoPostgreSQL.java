package pointSistemasCrud;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConexaoPostgreSQL {

	    private static final String URL = "jdbc:postgresql://localhost:5432/users";
	    private static final String USUARIO = "postgres";
	    private static final String SENHA = "123456";

	    public static Connection obterConexao() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            return DriverManager.getConnection(URL, USUARIO, SENHA);
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new RuntimeException("Erro ao conectar ao banco de dados PostgreSQL.", e);
	        }
	    }

	    public static void fecharConexao(Connection conexao) {
	        try {
	            if (conexao != null && !conexao.isClosed()) {
	                conexao.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    }
	}
