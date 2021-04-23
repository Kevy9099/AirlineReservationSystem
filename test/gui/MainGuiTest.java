package gui;

import main.AirlineReservation.Main;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;


public class MainGuiTest extends AssertJSwingJUnitTestCase {
  private FrameFixture window;
  JDesktopPane pane;

  @BeforeEach
  @Override
  protected void onSetUp() {
    Main main = new Main();
    window = new FrameFixture(main);
    window.show();
  }

  @Test
  public void customerMenu() {
    window.menuItem("customerMenu").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void addCustomer() {
    window.menuItem("customerMenu").click().requireVisible();
    window.menuItem("addCustomer").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void searchCustomer() {
    window.menuItem("customerMenu").click().requireVisible();
    window.menuItem("searchCustomer").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void ticketsMenu() {
    window.menuItem("ticketsMenu").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void bookTicket() {
    window.menuItem("ticketsMenu").click().requireVisible();
    window.menuItem("bookTicket").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void ticketReport() {
    window.menuItem("ticketsMenu").click().requireVisible();
    window.menuItem("ticketReport").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void flightMenu() {
    window.menuItem("flightMenu").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void addFlight() {
    window.menuItem("flightMenu").click().requireVisible();
    window.menuItem("addFlight").click().requireVisible();
    window.cleanUp();
  }

  @Test
  public void userMenu() {
    window.menuItem("userMenu").click().requireVisible();
    window.cleanUp();
  }


}