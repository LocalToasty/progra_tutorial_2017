public class Gosper {

  static void gosperLinks(Canvas c, int ordnung, int length) {
    // TODO
  }

  static void gosperRechts(Canvas c, int ordnung, int length) {
    // TODO
  }

  public static void main(String[] args) {
        int ordnung = 4;
        int length = 5;
        boolean links = true;
        switch (args.length) {
            case 3:
              if(args[2].equals("r")) {
                links = false;
              } else if (!args[2].equals("l")) {
                System.out.println(
                    "Unbekannter parameter " + args[2]);
                System.out.println(
                    "Nutze Standardwert l");
              }
            case 2:
                length = Integer.parseInt(args[1]);
                // fall-through
            case 1:
                ordnung = Integer.parseInt(args[0]);
                break;
            default:
                System.out.println(
                    "Verwende Standardwerte: Ordnung 4, Laenge 5, links.");
                System.out.println(
                    "Verwendung: java Gosper [ordnung [laenge [(l|r)]]]");
        }
        if (ordnung < 0) {
            System.out.println("Die Rekursionsordnung muss nicht-negativ sein!");
            return;
        }
        if (length < 1) {
            System.out.println("Die Laenge muss positiv sein!");
            return;
        }
        Canvas c = new Canvas();
        if(links) {
          Gosper.gosperLinks(
              c,
              ordnung,
              length
          );
        } else {
          Gosper.gosperRechts(
              c,
              ordnung,
              length
          );
        }
        c.refresh();
  }
}
