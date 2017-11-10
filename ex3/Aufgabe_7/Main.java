public class Main {
  public static void main(String[] args) {
    Pilz steinpilz = new Pilz();
    steinpilz.name = "Steinpilz";
    
    Pilz champignon = new Pilz();
    champignon.name = "Champignon";
    
    Pilz pfifferling = new Pilz();
    pfifferling.name = "Pfifferling";
    
    Mensch bonnie = new Mensch();
    bonnie.name = "Bonnie";
    bonnie.korb = new Pilz[3];
    bonnie.anzahl = 0;
    
    Mensch clyde = new Mensch();
    clyde.name = "Clyde";
    clyde.korb = new Pilz[4];
    clyde.anzahl = 0;
    
    Pilz[] wald = {steinpilz, champignon, champignon, pfifferling,
                   steinpilz, pfifferling, champignon};
    
    sammle(wald, bonnie, clyde);
  }
  
  public static void sammle(Pilz[] wald, Mensch... menschen) {
    int i = 0;
    for (Pilz p : wald) {
      while (i < menschen.length && !menschen[i].hatPlatz()) {
        i++;
      }
      
      if (i < menschen.length) { // Mensch mit platz
        menschen[i].korb[menschen[i].anzahl] = p;
        menschen[i].anzahl++;
      }
      
      for (Mensch m : menschen) {
        m.ausgabe();
      }
      System.out.println("---");
    }
  }
}
