package ObjectRepository;

import org.openqa.selenium.By;


public class Login {


	public final By userName= By.xpath("//input[@name='user_name']");
	public final By passWord= By.xpath("//input[@name='user_password']");
	public final By loginButton= By.xpath("//input[@id='submitButton']");
	public final By LogOutIcon= By.xpath("//img[@src='themes/softed/images/user.PNG']");
	public final By LogOutButton= By.xpath("//a[text()='Sign Out']");



	
	
}
