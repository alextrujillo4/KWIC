package filters;

import java.util.List;

public abstract class Filter<T> {
  public abstract List<T> run(List<T> input);
}