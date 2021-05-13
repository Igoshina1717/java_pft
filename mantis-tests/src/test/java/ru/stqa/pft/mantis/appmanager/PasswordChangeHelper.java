package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;

public class PasswordChangeHelper extends HelperBase {

  public PasswordChangeHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.xpath("//input[@type='submit']"));
    type(By.name("password"), password);
    click(By.xpath("//input[@type='submit']"));
  }


  public void goToManageUsers() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void chooseUser() {
    wd.findElement(By.xpath("//tbody/tr[5]/td[1]/a")).click();
  }

  public String getUserName(){
    return wd.findElement(By.cssSelector("input[name='username']")).getAttribute("value");
  }

  public String getUserMail(){
    return wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
  }

  public void resetUserPassword() throws UnsupportedEncodingException {
    String name = new String("'Reset Password'".getBytes(),"UTF-8");
    wd.findElement(By.cssSelector("input[value=" + name + "]")).click();
  }

  public void goToResetPage(String link) {
    wd.get(link);
  }

  public void setNewPassword(String newPassword) throws UnsupportedEncodingException {
    type(By.name("password"), newPassword);
    type(By.name("password_confirm"), newPassword);
    click(By.xpath("//button[@type='submit']"));
  }

}