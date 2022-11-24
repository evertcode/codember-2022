package dev.evertcode.challenge02;

import dev.evertcode.utils.Codember;
import dev.evertcode.utils.FileData;

/**
 * CatchCybercriminals
 * <p/>
 *
 * @author evertcode.
 * @version 1.0.0 created on 23/11/2022 05:49 p.m.
 */
public class CatchCybercriminals implements Codember {

  @Override
  public void solution() {
    var data = FileData.data("src/main/resources/encrypted.txt");

    if(data.isPresent()){
      var text = data.get();
      var minAscii = 30;
      var maxAscii = 122;

      var decrypted = new StringBuilder();
      var currentLetter = new StringBuilder();


      for(var i = 0; i < text.length(); i++){
        if(' ' == text.charAt(i)){
          decrypted.append(" ");
        }else{
          currentLetter.append(text.charAt(i));

          var num = Integer.parseInt(currentLetter.toString());

          if(num >= minAscii && num <= maxAscii){
            decrypted.append((char) num);
            currentLetter = new StringBuilder();
          }
        }
      }
      System.out.printf("submit %s%n", decrypted);
    }
  }
}
