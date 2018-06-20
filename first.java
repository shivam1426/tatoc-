package selenium;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
//import com.gargoylesoftware.htmlunit.util.Cookie;

public class first {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
            driver.get("http://10.0.1.86/tatoc");
            driver.findElement(By.linkText("Basic Course")).click();
          	driver.findElement(By.className("greenbox")).click();
          	//driver.findElement(By.id("main"));
          	//driver.switchTo().frame(0);
          	
          	//String ans=driver.findElement(By.id("answer")).getAttribute("class");
          	//System.out.print(ans);
          	driver.switchTo().frame(0);
    		WebElement box1 = driver.findElement(By.id("answer"));
    		String Box1_color = box1.getAttribute("class");
             String Box2_color = "";
             while(!Box1_color.equals(Box2_color))
             {    driver.findElement(By.linkText("Repaint Box 2")).click();
            	 driver.switchTo().frame("child");
            	 WebElement box22=driver.findElement(By.id("answer"));
            	 Box2_color=box22.getAttribute("class");
            	 driver.switchTo().parentFrame();
            	 
             }
             driver.findElement(By.linkText("Proceed")).click();;
          	
		// TODO Auto-generated method stub
		WebElement from=driver.findElement(By.id("dragbox"));
		WebElement to=driver.findElement(By.id("dropbox"));
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		ArrayList windowsList=new ArrayList(driver.getWindowHandles());
		String windows1= ((String)windowsList.get(1));
		driver.switchTo().window(windows1);
		driver.findElement(By.id("name")).sendKeys("shivam chopra");
		driver.findElement(By.id("submit")).click();
		String windows2=(String)(windowsList.get(0));
		driver.switchTo().window(windows2);
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Generate Token")).click();
		String st=driver.findElement(By.id("token")).getText();
		String substring1=st.substring(7);
		Cookie name = new Cookie("Token", substring1);
		driver.manage().addCookie(name);
		driver.findElement(By.linkText("Proceed")).click();

		

		
		

	}

}
