import java.util.*;

public class Account {
	private String username;
	private String password;
	private final AccountType acctype;
	private int access_lvl;
	private int status = 0;
	
	Scanner pscanner = new Scanner(System.in);
	
	//constructor for account class
	public Account(String username, String password, AccountType type){
		this.username = username;
		this.password = password;
		acctype = type;
	}
	
	//uses the AccountType enum to assign access level to user
	public void assign_access_lvl(){
		switch(acctype){
			case DataEntryClerk:
				this.access_lvl = 1;
				break;
			case ApplicationReviewer:
				this.access_lvl = 2;
				break;
			case Administrator:
				this.access_lvl = 3;
				break;
	}
		}
	
	public void ChangePassword(){
		System.out.println("Enter your old password");
		String old_password = pscanner.nextLine();
		if (old_password.equals(this.password)){
			System.out.println("Enter a new password");
			String new_password = pscanner.nextLine();
			System.out.println("Enter new password again");
			String new_password2 = pscanner.nextLine();
			if (new_password.equals(new_password2)){
				this.password = new_password;
			}
		} else {System.out.println("Incorrect password entered");}
	}

	public boolean Login(String username, String password){
		if (password.equals(this.password)){
			return true;
		} else {return false;}
	}
	
	public void Logout(){
		
	}

}