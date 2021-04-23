package gui;

import java.awt.Container;
import javax.swing.JDesktopPane;
import main.AirlineReservation.Login;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.Containers;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginGuiTest extends AssertJSwingJUnitTestCase {

  private FrameFixture screen;
  JDesktopPane deskPane;

  @BeforeEach
  protected void onSetUp() {
    Login login = GuiActionRunner.execute(Login::new);
    Container container = login.getContentPane();
    deskPane = new JDesktopPane();
    deskPane.add(container);
    login.setVisible(true);

    screen = new FrameFixture(Containers.frameFor(container));
    screen.show();
  }

  @Test
  public void loginIsEmpty() {
    screen.textBox("username").setText("");
    screen.textBox("password").setText("");
    screen.button("loginButton").click();
    screen.cleanUp();
  }

  @Test
  void loginValidation() {
    screen.textBox("username").setText("john");
    screen.textBox("password").setText("123");
    screen.button("loginButton").click();
    screen.cleanUp();

  }

  @Test
  public void invalidTest() {
    screen.textBox("username").enterText("Sze");
    screen.textBox("password").enterText("4t367");
    screen.button("loginButton").click();
    screen.cleanUp();
  }

  @Test
  public void cancelBtnTest(){
    screen.button("cancelButton").click();
    screen.cleanUp();
  }

}