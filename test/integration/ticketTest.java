package integration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import AirlineReservation.CustomerId;
import AirlineReservation.ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/* Unit Test ~ Deliverable #3 */
@RunWith(MockitoJUnitRunner.class)
class ticketTest {
    ticket myTicket;
    CustomerId testId;

    @InjectMocks
    ticket ticketMock;
    @Mock
    CustomerId idTest;

    @BeforeEach
    public void setUp() {
        myTicket = new ticket();
    }

    @Test
    @DisplayName("Positive Testing With Correct Customer Id")
    public void testCustIdBtnPositive(){
        testId = new CustomerId("CS001");
        ticket.jButton4.doClick();
        myTicket.customerIdButton(testId.getCustomerID());
        Assertions.assertEquals("validated", myTicket.customerIdButton((testId.getCustomerID())));
    }

    @Test
    @DisplayName("Negative Testing With Null Parameters")
    public void testCustIdBtnNegative(){
        testId = new CustomerId(null);
        Assertions.assertEquals("Incorrect Id.", myTicket.customerIdButton(testId.getCustomerID()));
    }

    @Test
    @DisplayName("Input validation with correct data type but wrong values")
    public void testLoginButtonInputVal() {
        testId = new CustomerId("Fake Id");
        Assertions.assertEquals("Customer Id not Found", myTicket.customerIdButton(testId.getCustomerID()));
    }

    @Test
    @DisplayName("Mock")
    public void mockTest(){
        myTicket = new ticket();
        idTest = new CustomerId("CS003");
        ticketMock = mock(ticket.class);
        when(ticketMock.customerIdButton("CS003")).thenReturn("validated");
                Assertions.assertEquals("validated", myTicket.customerIdButton(idTest.getCustomerID()));
    }
}

/* Unit Test ~ Deliverable #2 */
//    @Test
//    @DisplayName("Positive values should be accepted.")
//    public void testPositive() {
//        String price = "100";
//        int ticketPrice = Integer.parseInt(price);
//        assertTrue(ticketPrice >= 1, "Positive numbers should be allowed.");
//    }
//
//        @Test
//        @DisplayName("Negative values should be rejected.")
//        public void testNegative() {
//            String price = "-100";
//            int ticketPrice = Integer.parseInt(price);
//            assertTrue(ticketPrice >= 1, "Negative numbers should not be allowed.");
//        }
//
//        @Test
//        @DisplayName("Integers should not be allowed.")
//        public void testIntegers() {
//            String price = "integer";
//            int ticketPrice = Integer.parseInt(price);
//            assertTrue(ticketPrice >= 1, "Integers should not be allowed.");
//        }
//
//    }