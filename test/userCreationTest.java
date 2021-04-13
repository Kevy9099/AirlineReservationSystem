import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class userCreationTest {
    userCreation myCreation;
    userInfo myUserInfo;

    @InjectMocks
    userCreation userMock;
    @Mock
    userInfo testUserMock;

    @BeforeEach
    public void setup() {
        myCreation = new userCreation();
        userCreation.txtuserid.setText("CS005");
        userCreation.txtfirstname.setText("Abc");
        userCreation.txtlastname.setText("EXY");
        userCreation.txtusername.setText("gimim");
        userCreation.txtpassword.setText("42424");
    }

    @Test
    @DisplayName("Positive Testing With Correct User Infomation")
    public void testCreationBtnPositive() {
        myUserInfo = new userInfo("CS005", "Abc", "EXY", "gimim", "42424");
        userCreation.jButton1.doClick();
        myCreation.userCreationButton(myUserInfo.getId(), myUserInfo.getFirstname(), myUserInfo.getLastname(), myUserInfo.getUsername(), myUserInfo.getPassword());
        Assertions.assertEquals("User Created...", myCreation.userCreationButton(myUserInfo.getId(), myUserInfo.getFirstname(), myUserInfo.getLastname(), myUserInfo.getUsername(), myUserInfo.getPassword()));
    }

    @Test
    @DisplayName("Negative Testing With Null Parameters")
    public void testCreationBtnNegative() {
        myUserInfo = new userInfo(null, null, null, null, null);
        Assertions.assertEquals("Incorrect Fields", myCreation
                .userCreationButton(myUserInfo.getId(), myUserInfo.getFirstname(), myUserInfo.getLastname(), myUserInfo.getUsername(), myUserInfo.getPassword()));
    }

    @Test
    @DisplayName("Mock")
    public void mockTest() {
        myCreation = new userCreation();
        testUserMock = new userInfo("CS005", "Abc", "EXY", "gimim", "42424");
        userMock = mock(userCreation.class);
        when(userMock.userCreationButton("CS005", "Abc", "EXY", "gimim", "42424")).thenReturn("User Created");
        Assertions.assertEquals("User Created...", myCreation
                .userCreationButton(testUserMock.getId(), testUserMock.getFirstname(), testUserMock.getLastname(), testUserMock.getUsername(), testUserMock.getPassword()));
    }
}