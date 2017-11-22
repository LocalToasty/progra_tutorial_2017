import java.util.Arrays;

public class ArraySum {
  int arraySum(int[] xs) {
    return arraySumHelper(0, xs, 0);
  }

  int arraySumHelper(int i, int[] a, int sum) {
    if (i == a.length) {
      return sum;
    } else {
      return arraySumHelper(i + 1, a, sum + a[i]);
    }
  }

  int arraySumHelper2(int i, int[] a) {
    if (i == a.length) {
      return 0;
    } else {
      return a[i] + arraySumHelper2(i + 1, a);
    }
  }
  //
  //  int arraySum3(int[] a) {
  //    if (a.length == 0) {
  //      return 0;
  //    } if (a.length == 1) {
  //      return a[0];
  //    } else {
  //      return a[0] + arraySum3(Arrays.copyArrayRange(a, 1, a.length));
  //    }
  //  }
}
