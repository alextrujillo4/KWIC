package filters;

import java.util.List;
import java.util.Collections;

public class LowerCaseFilter extends Filter<String> {
  @Override
  public List<String> run(List<String> input) {
  
    for (int i = 0; i < input.size(); i++) {
      input.set(i, input.get(i).toLowerCase());
    }

    return input;
  }
}