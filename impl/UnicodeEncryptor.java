package encryptdecrypt.impl;

import encryptdecrypt.EncryptMethod;

public class UnicodeEncryptor implements EncryptMethod {

    @Override
    public String encrypt(String line, int key) {
        StringBuilder encryptMessage = new StringBuilder();

        for(int i = 0; i < line.length(); i++){
            encryptMessage.append((char) (line.charAt(i) + key));
        }
        return encryptMessage.toString();
    }
}
