package encryptdecrypt.context;

import encryptdecrypt.EncryptMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryptor {

    private EncryptMethod method;

    public void setMethod(EncryptMethod method){
        this.method = method;
    }

    public void encrypt(String inFile, String outFile, int key){

        try(Scanner sc = new Scanner(new File(inFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {

            while(sc.hasNextLine()){
                String encryptLine = this.method.encrypt(sc.nextLine(), key);
                out.write(encryptLine);
                out.newLine();
            }

        }catch (IOException e){
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
