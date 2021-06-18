package AdderAdapter;

import IntegerAdder.IntegerAdder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharToIntAdapter implements AdderAdapter {
    private String inputFilename;
    private final String adaptedFilename = "temp.txt";
    IntegerAdder adder;

    public CharToIntAdapter(String filename) {
        this.inputFilename = filename;
    }

    public CharToIntAdapter() {

    }


    public String getInputFilename() {
        return inputFilename;
    }

    public void setInputFilename(String inputFilename) {
        this.inputFilename = inputFilename;
    }

    @Override
    public void fileConverter(){
        try {
            Scanner sc = new Scanner(new FileReader(inputFilename));
            FileWriter fileWriter = new FileWriter(adaptedFilename);
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String charset[] = s.split(" ");

                for(String str : charset){
                    char c[] = str.toCharArray();

                    for(char ch : c){
                        Integer ascii = (int)ch;
                        fileWriter.write(ascii.toString() + " ");
                    }
                }
            }
            sc.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e1){
            System.err.println("IO Exception while writing the file: " + e1.getMessage());
        }
    }

    @Override
    public Integer calculateSum() {
        fileConverter();
        adder = new IntegerAdder(adaptedFilename);
        return adder.calculateSum();
    }
}
