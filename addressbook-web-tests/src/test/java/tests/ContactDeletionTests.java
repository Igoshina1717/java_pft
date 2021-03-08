package tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {

    app.gotoHomePage();
    app.editContact();
    app.deleteContact();
  }

}
