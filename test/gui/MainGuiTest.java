package gui;

import main.AirlineReservation.Main;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MainGuiTest extends AssertJSwingJUnitTestCase {

  private FrameFixture screen;

  @BeforeEach
  @Override
  protected void onSetUp() {
    Main main = new Main();
    screen = new FrameFixture(main);
    screen.show();
  }

  @Test
  public void customerMenu() {
    screen.menuItem("customerMenu").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void addCustomer() {
    screen.menuItem("customerMenu").click().requireVisible();
    screen.menuItem("addCustomer").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void searchCustomer() {
    screen.menuItem("customerMenu").click().requireVisible();
    screen.menuItem("searchCustomer").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void TicketsMenu() {
    screen.menuItem("ticketsMenu").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void bookTicket() {
    screen.menuItem("ticketsMenu").click().requireVisible();
    screen.menuItem("bookTicket").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void ticketReport() {
    screen.menuItem("ticketsMenu").click().requireVisible();
    screen.menuItem("ticketReport").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void flightMenu() {
    screen.menuItem("flightMenu").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void addFlight() {
    screen.menuItem("flightMenu").click().requireVisible();
    screen.menuItem("addFlight").click().requireVisible();
    screen.cleanUp();
  }


  @Test
  public void userMenu() {
    screen.menuItem("userMenu").click().requireVisible();
    screen.cleanUp();
  }

  @Test
  public void userCreation() {
    screen.menuItem("userMenu").click().requireVisible();
    screen.menuItem("userCreation").click().requireVisible();
    screen.cleanUp();
  }


}