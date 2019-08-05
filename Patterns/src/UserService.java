
public class UserService {
	
	private UserDataRepository udr;
	
	UserService(UserDataRepository udr){
		this.udr = udr;
	}
	public void persistUser(User user){
		udr.save(user);
	}

}
