package tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupPage();
    app.SelectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }


}
