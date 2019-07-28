package encryptdecrypt.context;

import encryptdecrypt.DecryptMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Decryptor {

    private DecryptMethod method;

    public void setMethod(DecryptMethod method){
        this.method = method;
    }

    public void decrypt(String inFile, String outFile, int key){

        try(Scanner sc = new Scanner(new File(inFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile))) {
            while (sc.hasNextLine()){

                String decryptLine = this.method.decrypt(sc.nextLine(), key);
                out.write(decryptLine);
                out.newLine();
            }

        }catch (IOException e){
            System.out.println("An exception occurs %s" +  e.getMessage());
        }
    }
}
