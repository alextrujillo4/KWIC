package pipeline;

import filters.Filter;

import java.util.ArrayList;
import java.util.List; 

public class PipeLine<T> {   
  List<Filter<T>> filters = new ArrayList<Filter<T>>();

  public PipeLine<T> addFilter(Filter<T> filter) {
    filters.add(filter);
    return this;
  }

  public List<T> run(List<T> input) {
    List<T> result = input;

    for (Filter<T> filter: filters) {
      result = filter.run(result);
    }

    return result;
  } 
} 