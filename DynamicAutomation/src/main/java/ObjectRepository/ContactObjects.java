package ObjectRepository;

import org.openqa.selenium.By;

public class ContactObjects {

	public final By ContactHeader= By.xpath("//a[@href='index.php?module=Contacts&action=index']");
	public final By ContactNewIcon= By.xpath("//img[@title='Create Contact...']");
	public final By LastName= By.xpath("//input[@name='lastname']");
	public final By SaveButton= By.xpath("(//td[text()=' Contact Information']/parent::tr/../../../../following-sibling::tr/descendant::input[@title='Save [Alt+S]'])[1]");
	public final By ContactCreated= By.xpath("//span[@class='dvHeaderText']");

}
