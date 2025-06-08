package app;

import app.service.EncryptionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionServiceTest {
    @Test
    public void testEncryptDecrypt() throws Exception {
        EncryptionService es = new EncryptionService();
        String original = "senhaSuperSecreta123!";
        String encrypted = es.encrypt(original);
        String decrypted = es.decrypt(encrypted);
        assertEquals(original, decrypted);
    }
}
