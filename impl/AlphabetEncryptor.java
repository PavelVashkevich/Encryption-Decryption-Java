package encryptdecrypt.impl;

import encryptdecrypt.EncryptMethod;

public class AlphabetEncryptor implements EncryptMethod {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String line, int key){

        StringBuilder encryptMessage = new StringBuilder();
        for(int i = 0; i < line.length(); i++){

            char ch = line.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isUpperCase(ch)){
                    alphabet = alphabet.toUpperCase();
                }else {
                    alphabet = alphabet.toLowerCase();
                }

                int indexOfLetterPlusKey = alphabet.indexOf(ch) + key;
                if(indexOfLetterPlusKey > alphabet.length() ){
                    encryptMessage.append(alphabet.charAt(indexOfLetterPlusKey - alphabet.length()));
                }else {
                    encryptMessage.append(alphabet.charAt(indexOfLetterPlusKey));
                }
            }else {
                encryptMessage.append(ch);
            }
        }

        return encryptMessage.toString();
    }
}