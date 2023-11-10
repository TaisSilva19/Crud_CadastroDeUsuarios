package pointSistemasCrud;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean {
	private UserService userService = new UserService();
	private User user = new User();
	private List<User> users;
	
	public UserBean() {
		users = getUsers();
    }

	public List<User> getUsers() {
		return userService.getAllUsers();		
	}
	
	public void addUser() {
		userService.addUser(user);
		user = new User();
	}
	
	public void updateUser() {
		userService.UpdateUser(user);
	}
	
	public void deleteUser() {
		userService.deleteUser(user);
		user = new User();
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
