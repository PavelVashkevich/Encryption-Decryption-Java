package encryptdecrypt;

import encryptdecrypt.context.Decryptor;
import encryptdecrypt.context.Encryptor;
import encryptdecrypt.impl.AlphabetDecryptor;
import encryptdecrypt.impl.AlphabetEncryptor;
import encryptdecrypt.impl.UnicodeDecryptor;
import encryptdecrypt.impl.UnicodeEncryptor;

import java.io.File;

public class CipherFactory {

    private String[] args;
    private String mode;
    private String inFile;
    private String alg;
    private String outFile;
    private int key;

    CipherFactory(String[] args) {
        this.args = args;
        parseArgs();
    }

    private void parseArgs() {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                    if (!(mode.equals("enc")) && !(mode.equals("dec"))) {
                        throw new IllegalArgumentException("Your mode " + mode + " is wrong. Choose -enc or -dec");
                    }
                    i++;
                } else if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                    i++;
                } else if (args[i].equals("-in")) {
                    inFile = args[i + 1];
                    if (!(new File(inFile).exists())) {
                        throw new IllegalArgumentException("File " + inFile + " isn't exist");
                    }
                    i++;
                } else if (args[i].equals("-out")) {
                    outFile = args[i + 1];
                    i++;
                } else if (args[i].equals("-alg")) {
                    alg = args[i + 1];
                    if (!(alg.equals("shift")) && !(alg.equals("unicode"))) {
                        throw new IllegalArgumentException("Specified algorithm " + alg + " isn't exist");
                    }
                    i++;
                }
            }
        } catch (RuntimeException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public void useCipher(){
        if(mode.equalsIgnoreCase("enc")){

            Encryptor encryptor = new Encryptor();

            if(alg.equals("shift")){
                encryptor.setMethod(new AlphabetEncryptor());
                encryptor.encrypt(inFile, outFile, key);
            }else if(alg.equals("unicode")){
                encryptor.setMethod(new UnicodeEncryptor());
                encryptor.encrypt(inFile, outFile, key);
            }

        }else if(mode.equalsIgnoreCase("dec")){

            Decryptor decryptor = new Decryptor();

            if(alg.equals("shift")){
                decryptor.setMethod(new AlphabetDecryptor());
                decryptor.decrypt(inFile, outFile, key);
            }else if(alg.equals("unicode")){
                decryptor.setMethod(new UnicodeDecryptor());
                decryptor.decrypt(inFile, outFile, key);
            }
        }
    }
}
