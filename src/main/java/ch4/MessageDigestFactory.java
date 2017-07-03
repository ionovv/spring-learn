package ch4;

import java.security.MessageDigest;

public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createinstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
