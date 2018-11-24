import java.util.*;

public class Account {
	protected final String username;
	protected String password;
	protected final AccountType acctype;
	protected int access_lvl;
	public int status;
	
	Scanner scan = new Scanner(System.in);
	
	// arraylist that stores all login information
	public static ArrayList<String[]> Login_storage  = new ArrayList<String[]>();
	
	// array that stores username and password
	String[] login = new String[2];	
	
	//constructor for account class
	public Account(String username, String password, AccountType type){
		this.username = username;
		this.password = password;
		acctype = type;
		login[0] = this.username;
		login[1] = this.password;
		Login_storage.add(login);
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
	
	public String get_password(){
		return this.password;
	}
	
	public String get_username(){
		return this.username;
	}
	
	public void ChangePassword(){
		System.out.println("Enter your old password");
		String old_password = scan.nextLine();
		if (old_password.equals(this.password)){
			System.out.println("Enter a new password");
			String new_password = scan.nextLine();
			System.out.println("Enter new password again");
			String new_password2 = scan.nextLine();
			if (new_password.equals(new_password2)){
				this.password = new_password;
			}
		} else {System.out.println("Incorrect password entered");}
	}

	public void Login(String username, String password){
		for(int item = 0; item < Login_storage.size(); item++){
			if (username.equals(this.get_username())){
				if(password.equals(this.get_password())){
					status = 0;
				}else {System.out.println("Invalid username or password");}
			}
		}
	}
	
	public void Logout(){
		System.out.println("Are you sure you want to logout?	'y' = yes, 'n' = no");
		String choice = scan.next();
		try{
			if (choice.equalsIgnoreCase("y")){
				status = -1;
			}else if (choice.equalsIgnoreCase("n")){
				status = status;
			}
		} catch (StringIndexOutOfBoundsException exception){
			System.out.println("enter 'Y' or 'N':");
			Logout();
		}
	}
	
	
}