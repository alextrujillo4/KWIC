package inputs;

import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;
import pipeline.PipeLine;

import java.io.*;
import java.util.*;

public class LineCounter {
    private ArrayList <String> originalArray;
    private ArrayList <String> input;
    private Collection<String> stopWords;



    public LineCounter() {
        input = new ArrayList<String>();
        originalArray = new ArrayList<String>();
    }
    public  void readFile(String filename) throws FileNotFoundException, IOException{
        File file =  new File(LineCounter.class.getResource(filename).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            originalArray.add(st);
            input.add(st);

        }

    }

    public List<String> readFileFrom(String filename) throws FileNotFoundException, IOException{
        File file =  new File(LineCounter.class.getResource(filename).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> input = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                input.add(st);
            }

            return input;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void printLines() {
        System.out.println(input.size());
        int i = 0;
        for (String aFilearray : input) {
            System.out.println( i +". " + aFilearray);
            i++;
        }
    }




    public ArrayList<String> getFilearray() {
        return input;
    }


    public void deleteStopWords(Scanner scanner, Collection<String> inputCollection) {
        this.stopWords = inputCollection;
            for (int i = 0; i < input.size(); i++) {
                List<String> cont = new ArrayList(Arrays.asList(input.get(i).split(" ")));
                cont.removeAll(stopWords);
                input.set(i, String.join(" ", cont));
            }

    }

    public void setFilters( String filter) {
        PipeLine<String> pipeline = new PipeLine<String>()
                .addFilter(new LowerCaseFilter())
                .addFilter(new ShiftFilter())
                .addFilter(new SortFilter(filter));
        input = new ArrayList<>(pipeline.run(input));
    }


    public void deleteResultado(int i) {
        input.set(Integer.parseInt(String.valueOf(i)), null);
    }

    public void removeAll() {
        input.removeAll(Collections.singleton(null));
    }
}