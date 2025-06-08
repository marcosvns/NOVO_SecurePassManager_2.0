package app.service;

import app.model.Credential;
import java.util.ArrayList;
import java.util.List;

//gerencia a lista de credenciais na memória
public class PasswordService {
    private final List<Credential> credentials = new ArrayList<>();
    private final EncryptionService encryptionService = new EncryptionService();

    public void addCredential(String service, String username, String password) throws Exception {
        String encrypted = encryptionService.encrypt(password);
        credentials.add(new Credential(service, username, encrypted));
    }

    public void listCredentials() throws Exception {
        for (Credential c : credentials) {
            System.out.println("Serviço: " + c.getService() +
                    ", Usuário: " + c.getUsername() +
                    ", Senha: " + encryptionService.decrypt(c.getEncryptedPassword()));
        }
    }
}
