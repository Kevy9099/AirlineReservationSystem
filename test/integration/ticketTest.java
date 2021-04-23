package integration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import main.AirlineReservation.CustomerId;
import main.AirlineReservation.ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ticketTest {

  ticket ticket;
  CustomerId id;

  @InjectMocks
  ticket ticketMock;
  @Mock
  CustomerId idMock;

  @BeforeEach
  public void setUp() {
    ticket = new ticket();
  }

  @Test
  @DisplayName("Positive Testing")
  public void positiveTest() {
    id = new CustomerId("CS001");
    ticket.jButton4.doClick();
    ticket.customerIdButton(id.getCustomerID());
    Assertions.assertEquals("validated", ticket.customerIdButton((id.getCustomerID())));
  }

  @Test
  @DisplayName("Negative Testing")
  public void negativeTest() {
    id = new CustomerId(null);
    Assertions.assertEquals("Incorrect Id.", ticket.customerIdButton(id.getCustomerID()));
  }

  @Test
  @DisplayName("Input Validation")
  public void inputTest() {
    id = new CustomerId("Fake Id");
    Assertions.assertEquals("Customer Id not Found", ticket.customerIdButton(id.getCustomerID()));
  }

  @Test
  @DisplayName("Mock")
  public void mockTest() {
    ticket = new ticket();
    idMock = new CustomerId("CS003");
    ticketMock = mock(ticket.class);
    when(ticketMock.customerIdButton("CS003")).thenReturn("validated");
    Assertions.assertEquals("validated", ticket.customerIdButton(idMock.getCustomerID()));
  }
}