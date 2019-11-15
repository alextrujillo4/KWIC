package filters;

import java.util.List;
import java.util.Collections;

public class SortFilter extends Filter<String> {
  @Override
  public List<String> run(List<String> input) {
    Collections.sort(input, String.CASE_INSENSITIVE_ORDER);
    return input;
  }
}