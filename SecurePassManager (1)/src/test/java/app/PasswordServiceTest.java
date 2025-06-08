package app;

import app.service.PasswordService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testa o serviço de gerenciamento de senhas
public class PasswordServiceTest {
    @Test
    public void testAddCredential() throws Exception {
        PasswordService ps = new PasswordService();
        ps.addCredential("GitHub", "user123", "senha123");
        assertTrue(true);
    }
}
