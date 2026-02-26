package practice_mockito;

//Bussiness logic
public class UsersService {

	UsersDao dao; //null
	
	public UsersService(UsersDao dao){
		this.dao = dao;
	}
	
	public String typeOfUser(int id) {
		Users user = dao.findById(id);
		
		if(user.getBalance()>0 && user.getBalance()<=1000) {
			return "new User";
		}else if(user.getBalance()>1000 && user.getBalance()<=2000) {
			return "regular user";
		}
		else {
			return "premium user";
		}
	}
	
}
