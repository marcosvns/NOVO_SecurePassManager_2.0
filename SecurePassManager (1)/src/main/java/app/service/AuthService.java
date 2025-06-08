package app.service;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

//Responsável por gerar e validar os códigos "TOTP" para autenticação de dois fatores, utilizando a biblioteca "GoogleAuthenticator"
public class AuthService {
    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();
    private GoogleAuthenticatorKey key;

    public void setup2FA() {
        key = gAuth.createCredentials();
        System.out.println("Sua chave secreta TOTP: " + key.getKey());
    }

    public boolean validateCode(int code) {
        return gAuth.authorize(key.getKey(), code);
    }
}