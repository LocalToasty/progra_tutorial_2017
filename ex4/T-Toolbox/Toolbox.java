public class Toolbox {
  private Tool[] tools;
  private int capacity; // noch freien Felder
  private String name;

  public Toolbox(String name, int capacity) {
    this.name = name;
    tools = new Tool[capacity];
    this.capacity = capacity;
  }

  public Toolbox(String name, Tool... tools) {
    this.name = name;
    this.tools = tools;

    capacity = 0;
    for (Tool t : tools) {
      if (t == null) {
        capacity++;
      }
    }
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }

  public Tool getTool(int i) {
    if (i < 0 || i >= tools.length)
      return null;
    
    return tools[i];
  }

  private static final int powerToolSize = 3;

  private boolean checkRoomForPowerTool(Wrapper w) {
    for (int i = 0; i <= tools.length - powerToolSize; i++) {
      if (tools[i] == null) {

        boolean room = true;
        for (int j = 0; j < powerToolSize; j++) {
          if (tools[i + j] != null) {
            i += j;
            room = false;
          }
        }

        if (room == true) {
          w.set(i);
          return true;
        }
      }
    }

    return false;
  }

  public boolean checkRoomForPowerTool() { return checkRoomForPowerTool(new Wrapper(0)); }

  public void addTool(Tool tool) {
    switch(tool) {
    case Materials:
      for (Tool t : tools) {
        if (t == Tool.Materials) {
          return;
        }
        else if (t == null) {
          t = tool;
          capacity--;
        }
      }
      break;

    case SimpleTool:
      for (Tool t : tools) {
        if (t == null) {
          t = tool;
          capacity--;
        }
      }
      break;

    case PowerTool:
      Wrapper w = new Wrapper(0);
      if (checkRoomForPowerTool(w)) {
        tools[w.get()] = tool;
        capacity -= powerToolSize;
      }
      break;
    }
  }
}
