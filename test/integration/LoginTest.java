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
    Login myLogin;
    User testUser;
    @InjectMocks
    Login loginMock;
    @Mock
    User userTest;

    @BeforeEach
    public void setup() {
        myLogin = new Login();
    }


    @Test
    @DisplayName("Positive testing with correct credentials and data type")
    public void testLoginButtonPositive() {
        testUser = new User("john", "123");
        Login.jButton1.doClick();
        myLogin.loginButton(testUser.getUsername(), testUser.getPassword());
        Assertions.assertEquals("validated", myLogin.loginButton(testUser.getUsername(),
                testUser.getPassword()));
    }

    @Test
    @DisplayName("Negative testing with null parameters")
    public void testLoginButtonNegative() {
        testUser = new User(null, null);
        Assertions.assertEquals("UserName or Password Blank", myLogin.loginButton(testUser.getUsername(), testUser.getPassword()));
    }


    @Test
    @DisplayName("Input validation with correct data type but wrong values")
    public void testLoginButtonInputVal() {
        testUser = new User("soFake", "notReal");
        Assertions.assertEquals("UserName or Password do not Match", myLogin.loginButton(testUser.getUsername(),
                testUser.getPassword()));
    }

    @Test
    @DisplayName("Mock")
    public void mockTest(){
        //User to be tested
        myLogin = new Login();
        userTest = new User("john","123");
        loginMock = mock(Login.class);
        when(loginMock.loginButton("john","123")).thenReturn("validated");
        Assertions.assertEquals("validated", myLogin.loginButton(userTest.getUsername(),
                userTest.getPassword()));

    }
}
