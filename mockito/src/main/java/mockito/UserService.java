package mockito;

public class UserService {
	private UserDao dao;
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	public String typeOfUser(int id) {
		User user = dao.findById(id);
		
		if(user.getBalance() > 0 && user.getBalance() <= 1000) {
			return "new user";
		}
		else if(user.getBalance() > 1001 && user.getBalance() <= 2000) {
			return "regular user";
		}
		else {
			return "premium user";
		}
	}
}
