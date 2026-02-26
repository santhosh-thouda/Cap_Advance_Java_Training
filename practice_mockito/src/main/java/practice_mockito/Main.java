package practice_mockito;

public class Main {

	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		dao.insertUser();
		Users u = dao.findById(1);
		System.out.println(u);
	}
}