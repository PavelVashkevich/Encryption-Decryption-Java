package encryptdecrypt.impl;

import encryptdecrypt.DecryptMethod;

public class AlphabetDecryptor implements DecryptMethod {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    @Override
    public String decrypt(String line, int key) {

        StringBuilder decryptMessage = new StringBuilder();

        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);

            if(Character.isLetter(ch)){

                if(Character.isUpperCase(ch)){
                    alphabet = alphabet.toUpperCase();
                }else {
                    alphabet = alphabet.toLowerCase();
                }

                int indexOfLetterMinusKey = alphabet.indexOf(ch) - key;

                if(indexOfLetterMinusKey < 0){
                    decryptMessage.append(alphabet.charAt(alphabet.length() + indexOfLetterMinusKey));
                }else {
                    decryptMessage.append(alphabet.charAt(indexOfLetterMinusKey));
                }
            }else {
                decryptMessage.append(ch);
            }
        }
        return decryptMessage.toString();
    }
}
