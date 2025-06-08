package app;

import app.util.PasswordGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {
    @Test
    public void testGeneratedPasswordLength() {
        int length = 20;
        String password = PasswordGenerator.generate(length);
        assertEquals(length, password.length());
    }

    @Test
    public void testGeneratedPasswordNotEmpty() {
        String password = PasswordGenerator.generate(10);
        assertNotNull(password);
        assertFalse(password.isEmpty());
    }
}
