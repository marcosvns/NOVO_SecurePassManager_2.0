package app.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.security.MessageDigest;

//Responsável por verificar se a senha foi exposta
public class LeakChecker {
    private final OkHttpClient client = new OkHttpClient();

    public boolean isPasswordLeaked(String password) throws Exception {
        String sha1 = sha1(password).toUpperCase();
        String prefix = sha1.substring(0, 5);
        String suffix = sha1.substring(5);

        Request request = new Request.Builder()
                .url("https://api.pwnedpasswords.com/range/" + prefix)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return false;
            return response.body().string().contains(suffix);
        }
    }

    private String sha1(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] result = md.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
