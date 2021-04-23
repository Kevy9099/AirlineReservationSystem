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

  private FrameFixture window;
  JDesktopPane pane;

  @BeforeEach
  protected void onSetUp() {
    Login test = GuiActionRunner.execute(Login::new);
    Container container = test.getContentPane();
    pane = new JDesktopPane();
    pane.add(container);
    test.setVisible(true);

    window = new FrameFixture(Containers.frameFor(container));
    window.show();
  }

  @Test
  public void checkEmptyLogin() {
    window.textBox("username").setText("");
    window.textBox("password").setText("");
    window.button("loginButton").click();
    window.cleanUp();
  }

  @Test
  void checkValidLogin() {
    window.textBox("username").setText("john");
    window.textBox("password").setText("123");
    window.button("loginButton").click();
    window.cleanUp();

  }

  @Test
  public void invalidLoginTest() {
    window.textBox("username").enterText("George");
    window.textBox("password").enterText("1gb42");
    window.button("loginButton").click();
    window.cleanUp();
  }

  @Test
  public void cancelButtonTest(){
    window.button("cancelButton").click();
    window.cleanUp();
  }

}