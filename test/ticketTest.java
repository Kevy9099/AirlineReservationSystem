import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ticketTest {
        ticket myTicket;

        @InjectMocks
        ticket ticketMocks;

        @BeforeEach
        public void setUp() throws Exception {
            myTicket = new ticket();
        }

        @Test
        @DisplayName("Negative values should be rejected.")
        public void testNegative() {
            String price = "-100";
            int ticketPrice = Integer.parseInt(price);
            assertTrue(ticketPrice >= 1, "Negative numbers should not be allowed.");
        }

        @Test
        @DisplayName("Positive values should be accepted.")
        public void testPositive() {
            String price = "100";
            int ticketPrice = Integer.parseInt(price);
            assertTrue(ticketPrice >= 1, "Positive numbers should be allowed.");
        }

        @Test
        @DisplayName("Integers should not be allowed.")
        public void testIntegers() {
            String price = "integer";
            int ticketPrice = Integer.parseInt(price);
            assertTrue(ticketPrice >= 1, "Integers should not be allowed.");
        }

    }