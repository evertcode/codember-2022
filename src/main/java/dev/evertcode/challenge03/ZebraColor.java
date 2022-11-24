package dev.evertcode.challenge03;

import dev.evertcode.utils.Codember;
import dev.evertcode.utils.FileData;

/**
 * ZebraColor
 * <p/>
 *
 * @author evertcode.
 * @version 1.0.0 created on 23/11/2022 10:20 a.m.
 */
public class ZebraColor implements Codember {
  @Override
  public void solution() {
    var maxZebra = 1;
    var currentZebra = 1;
    var data = FileData.data("src/main/resources/colors.txt");

    if(data.isPresent()){
      var colors =  data.get()
          .replace(" ", "")
          .replace("\"", "")
          .replace("[", "")
          .replace("]", "")
          .split(",");

      var lastColor = colors[0];

      System.out.printf("submit %d@%s%n", maxZebra, lastColor);
    }
  }
}
