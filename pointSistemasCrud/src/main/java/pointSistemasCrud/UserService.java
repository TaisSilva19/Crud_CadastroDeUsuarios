package pointSistemasCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	public List<User>getAllUsers(){
		List<User>users = new ArrayList<>();
		try (Connection connection = ConexaoPostgreSQL.obterConexao();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users")){
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			users.add(user);
			}	
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return users;	
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (name, email) VALUES(?,?)";
		
		try (Connection connection = ConexaoPostgreSQL.obterConexao();
			PreparedStatement pstmt = connection.prepareStatement(sql)){
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.executeUpdate();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}	
		
		public void UpdateUser(User user) {
			String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
			
			try (Connection connection = ConexaoPostgreSQL.obterConexao();
			     PreparedStatement pstmt = connection.prepareStatement(sql)){
				
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setLong(3, user.getId());
				pstmt.executeUpdate();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		 public void deleteUser(User user) {
			String sql = "DELETE FROM users WHERE id = ? ";
			
			try (Connection connection = ConexaoPostgreSQL.obterConexao();
				     PreparedStatement pstmt = connection.prepareStatement(sql)){
				
				pstmt.setLong(1, user.getId());
				pstmt.executeUpdate();
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}
				
	}

