package integration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import main.AirlineReservation.userCreation;
import main.AirlineReservation.userInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class userCreationTest {

  userCreation creation;
  userInfo userInfo;

  @InjectMocks
  userCreation userMock;
  @Mock
  userInfo infoMock;

  @BeforeEach
  public void setup() {
    creation = new userCreation();
    userCreation.txtuserid.setText("CS005");
    userCreation.txtfirstname.setText("Abc");
    userCreation.txtlastname.setText("EXY");
    userCreation.txtusername.setText("gimim");
    userCreation.txtpassword.setText("42424");
  }

  @Test
  @DisplayName("Positive Testing")
  public void positiveTest() {
    userInfo = new userInfo("CS005", "Abc", "EXY", "gimim", "42424");
    userCreation.jButton1.doClick();
    creation.userCreationButton(userInfo.getId(), userInfo.getFirstname(), userInfo.getLastname(),
        userInfo.getUsername(), userInfo.getPassword());
    Assertions.assertEquals("User Created...", creation
        .userCreationButton(userInfo.getId(), userInfo.getFirstname(), userInfo.getLastname(),
            userInfo.getUsername(), userInfo.getPassword()));
  }

  @Test
  @DisplayName("Negative Testing")
  public void negativeTest() {
    userInfo = new userInfo(null, null, null, null, null);
    Assertions.assertEquals("Incorrect Fields", creation
        .userCreationButton(userInfo.getId(), userInfo.getFirstname(), userInfo.getLastname(),
            userInfo.getUsername(), userInfo.getPassword()));
  }

  @Test
  @DisplayName("Mock")
  public void mockTest() {
    creation = new userCreation();
    infoMock = new userInfo("CS005", "Abc", "EXY", "gimim", "42424");
    userMock = mock(userCreation.class);
    when(userMock.userCreationButton("CS005", "Abc", "EXY", "gimim", "42424"))
        .thenReturn("User Created");
    Assertions.assertEquals("User Created...", creation
        .userCreationButton(infoMock.getId(), infoMock.getFirstname(), infoMock.getLastname(),
            infoMock.getUsername(), infoMock.getPassword()));
  }
}
