package gui;

import main.AirlineReservation.Main;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCreationGuiTest extends AssertJSwingJUnitTestCase  {


  private FrameFixture screen;

  @BeforeEach
  @Override
  protected void onSetUp() {
    Main main = new Main();
    screen = new FrameFixture(main);
    screen.show();
  }
  @Test
  public void userCreationTest() {
    screen.menuItem("userMenu").click().requireVisible();
    screen.menuItem("userCreation").click().requireVisible();
    screen.textBox("firstname").setText("Jose");
    screen.textBox("lastname").setText("Gonzalez");
    screen.textBox("username").setText("jGonzalez");
    screen.textBox("password").setText("12324");
    screen.button("add").click();
    screen.cleanUp();
  }

  @Test
  public void cancelTest() {
    screen.menuItem("userMenu").click().requireVisible();
    screen.menuItem("userCreation").click().requireVisible();
    screen.button("cancel").click();
    screen.cleanUp();
  }

}