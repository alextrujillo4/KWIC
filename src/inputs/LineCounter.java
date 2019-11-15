package inputs;

import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;
import pipeline.PipeLine;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LineCounter {
    private ArrayList <String> originalArray;
    private ArrayList <String> filearray;


    public LineCounter() {
        filearray  = new ArrayList<String>() ;
        originalArray  = new ArrayList<String>() ;
    }

    public  void readFile(String filename) throws FileNotFoundException, IOException{
        File file =  new File(LineCounter.class.getResource(filename).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            originalArray.add(st);
            filearray.add(st);

        }

    }

    public void printLines() {
        System.out.println(filearray.size());
        int i = 0;
        for (String aFilearray : filearray) {
            System.out.println( i +". " + aFilearray);
            i++;
        }
    }



    public void setDeleteLines(Scanner scanner) {
        for (String s : scanner.nextLine().split(",")) {
            try {
                filearray.set(Integer.parseInt(s), null);
            } catch (NumberFormatException err) {
                //
            }
        }

        filearray.removeAll(Collections.singleton(null));
    }

    public void deleteStopWords() {
        for (int i = 0; i < filearray.size(); i++) {
            for (String w : originalArray) {
                filearray.set(i, filearray.get(i).replace(w, ""));
            }
        }
    }

    public ArrayList<String> getFilearray() {
        return filearray;
    }

    public void setFiltersToList(String filter) {
        PipeLine<String> pipeline = new PipeLine<String>()
                .addFilter(new LowerCaseFilter())
                .addFilter(new ShiftFilter())
                .addFilter(new SortFilter(filter));

        filearray = pipeline.run(filearray);
    }
}