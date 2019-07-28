package encryptdecrypt.impl;

import encryptdecrypt.DecryptMethod;

public class UnicodeDecryptor implements DecryptMethod {

    @Override
    public String decrypt(String line, int key) {

        StringBuilder decryptMessage = new StringBuilder();

        for(int i = 0; i < line.length(); i++){
            decryptMessage.append((char) (line.charAt(i) - key));
        }
        return decryptMessage.toString();
    }
}
