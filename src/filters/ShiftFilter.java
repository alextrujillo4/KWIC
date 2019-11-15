package filters;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ShiftFilter extends Filter<String> {
  @Override
  public List<String> run(List<String> input) {
    List<String> result = new ArrayList<String>();    
    for (String s : input) {
      result.addAll(getShiftedStrings(s));
    }
    
    return result;
  }

  List<String> getShiftedStrings(String s) {
    ArrayList<String> shiftedStrings = new ArrayList<String>();
    ArrayList<String> segments = new ArrayList(Arrays.asList(s.split(" ")));

    shiftedStrings.add(stringFromList(segments));

    int size = segments.size();
    
    for (int i = 0; i < size - 1; i++) {
      String temp = segments.get(segments.size() - 1);
      segments.remove(segments.size() - 1);
      segments.add(0, temp);
      shiftedStrings.add(stringFromList(segments));
    }
  
    return shiftedStrings;
  }

  String stringFromList(List<String> segments) {
    StringBuffer sb = new StringBuffer();
      
    for (String s : segments) {
       sb.append(s);
       sb.append(" ");
    }

    return sb.toString().trim();
  }
}