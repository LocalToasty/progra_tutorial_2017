public class List {
  public static List EMPTY = new List(null, 0);

  private List next;
  private int value;

  public List(List n, int v) {
    next = n;
    value = v;
  }

  public List getNext() {
    return next;
  }

  public int getValue() {
    return value;
  }

  public boolean isEmpty() {
    return this == EMPTY;
  }

  public int length() {
    if (isEmpty()) {
      return 0;
    } else {
      return 1 + next.length();
    }
  }

  public String toString() {
    if (!isEmpty()) {
      if (next.isEmpty()) {
        return "" + value;
      } else {
        return "" + value + ", " + next;
      }
    } else {
      return "";
    }
  }

  public List getSublist(int length) {
    if (length == 0 || isEmpty()) {
      return EMPTY;
    }

    return new List(next.getSublist(length - 1), value);
  }
}
