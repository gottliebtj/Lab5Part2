import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MfParser {

  public void mapCommands(String fileName){
    Map<String, String> map = new HashMap<String, String>();
    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
        if (line.length()>0 && line.indexOf(':')>0) {
          String [] splitLine = line.split(":");
          //System.out.println(splitLine[1]);
          //add to the map
          map.put(splitLine[0],splitLine[1]);
        }
      // read next line
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

  //  return map;
    Graph g = new Graph(map.size());
    g.findCycles();
    System.out.println("Targets Mapped To Dependencies: "+map.size());
    System.out.println("No Cycles Detected");

  }


}
