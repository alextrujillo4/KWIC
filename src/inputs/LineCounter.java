package inputs;

import java.io.*;
import java.util.ArrayList;

public class LineCounter {
    private ArrayList <String> filearray;

    public LineCounter() {
        filearray  = new ArrayList<String>() ;
    }

    public  void readFile() throws FileNotFoundException, IOException{
        File file =  new File(LineCounter.class.getResource("KWIC2_input.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            filearray.add(st);

    }

    public void printArray() {
        System.out.println(filearray.size());
        for (String aFilearray : filearray) {
            System.out.println(aFilearray);
        }
    }


}