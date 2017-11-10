public class Mensch {
  String name;
  Pilz[] korb;
  int anzahl = 0;

  boolean hatPlatz() {
    for (Pilz p : korb) {
      if (p == null)
        return true;
    }

    return false;
  }

  void ausgabe() {
    System.out.println(name + ':');
    for (Pilz p : korb) {
      if (p != null) {
        System.out.println(p.name);
      }
    }
  }
}
