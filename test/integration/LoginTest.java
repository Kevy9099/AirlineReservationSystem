package integration;

import static org.mockito.Mockito.*;

import main.AirlineReservation.Login;
import main.AirlineReservation.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class LoginTest {

  Login login;
  User user;
  @InjectMocks
  Login loginMock;
  @Mock
  User userMock;

  @BeforeEach
  public void setup() {
    login = new Login();
  }


  @Test
  @DisplayName("Positive testing with correct credentials and data type")
  public void positiveTest() {
    user = new User("john", "123");
    Login.jButton1.doClick();
    login.loginButton(user.getUsername(), user.getPassword());
    Assertions.assertEquals("validated", login.loginButton(user.getUsername(),
        user.getPassword()));
  }

  @Test
  @DisplayName("Negative testing with null parameters")
  public void negativeTest() {
    user = new User(null, null);
    Assertions.assertEquals("UserName or Password Blank",
        login.loginButton(user.getUsername(), user.getPassword()));
  }


  @Test
  @DisplayName("Input validation with correct data type but wrong values")
  public void inputTest() {
    user = new User("fake", "soFake");
    Assertions
        .assertEquals("UserName or Password do not Match", login.loginButton(user.getUsername(),
            user.getPassword()));
  }

  @Test
  @DisplayName("Mock")
  public void mockTest() {
    login = new Login();
    userMock = new User("john", "123");
    loginMock = mock(Login.class);
    when(loginMock.loginButton("john", "123")).thenReturn("validated");
    Assertions.assertEquals("validated", login.loginButton(userMock.getUsername(),
        userMock.getPassword()));

  }
}