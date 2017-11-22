public class Drachenkurve {

  public static void kurveR(Canvas s, int i) {
    if (i <= 0) {
      s.drawForward(10);
    } else {
      kurveR(s, i - 1);
      s.rotate(90);
      kurveL(s, i - 1);
    }
  }

  public static void kurveL(Canvas s, int i) {
    if (i <= 0) {
      s.drawForward(10);
    } else {
      kurveR(s, i - 1);
      s.rotate(-90);
      kurveL(s, i - 1);
    }
  }

	public static void main(String[] args) {
		Canvas s = new Canvas();
		s.rotate(180); // Rotiert die aktuelle Ausrichtung nach oben
		kurveR(s, 4);
	}
}
