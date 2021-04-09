package IntegerAdder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerAdder {
    private String filename;

    public IntegerAdder(String filename) {
        this.filename = filename;
    }

    public IntegerAdder(){
        filename = "";
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<Integer> readFile(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            while(sc.hasNextInt()){
                arrayList.add(sc.nextInt());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return arrayList;
    }

    public Integer calculateSum(ArrayList<Integer> arrayList){
        Integer sum = 0;
        for(Integer i : arrayList){
            sum += i;
        }
        return sum;
    }

    public Integer calculateSum(){
        return calculateSum(readFile());
    }




}
