import java.util.*;

/**
 * @param <E> Element type.
 * Iterator through a functional set.
 */
public class FunctionalSetIterator<E> implements Iterator<E> {
  private FunctionalSet<E> set;

  // has to be empty or addset
  private SimpleFunctionalSet<E> current;

  private Set<Object> used;

  private E lastElem;
  private boolean removable;
  
  public FunctionalSetIterator(FunctionalSet<E> functionalSet,
                               SimpleFunctionalSet<E> head)
  {
    set = functionalSet;
    current = head;
    removable = false;
    used = new FunctionalSet<Object>();
    if (current instanceof RemoveSet)
      skipToNextAddOrEmpty();
  }
  
  @Override
  public boolean hasNext() {
    return !(current instanceof EmptySet);
  }
  
  @Override
  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    // current is guaranteed to be addset at this point
    E elem = ((AddSet<E>) current).getElement();
    removable = true;
    lastElem = elem;
    skipToNextAddOrEmpty();

    return elem;
  }

  private void skipToNextAddOrEmpty() {
    while (true) {
      if (current instanceof RemoveSet) {
        used.add(((RemoveSet<E>) current).getObject());
      }
      
      current = current.getRemainingSet();

      if (current instanceof AddSet && !used.contains(((AddSet<E>) current).getElement())) {
        break;
      }
      if (current instanceof EmptySet) {
        break;
      }
    }
  }
  
  @Override
  public void remove() {
    if (removable) {
      set.remove(lastElem);
      removable = false;
    } else {
      throw new IllegalStateException("Next has not been called");
    }
  }
}
