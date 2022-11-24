package dev.evertcode.challenge04;

import dev.evertcode.utils.Codember;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * BitCoin
 * <p/>
 *
 * @author @evertcode.
 * @version 1.0.0 created on 22/11/2022 05:01 p.m.
 */
public class BitCoin implements Codember {

  private static final int MIN = 11098;
  private static final int MAX = 98123;
  private static final String REPLACE_TARGET = "5";

  @Override
  public void solution() {
    var passwords = new ArrayList<>();
    var range = IntStream.rangeClosed(MIN, MAX);

    range.forEach(item -> {
      var value = String.valueOf(item);
      var sortedValue = Arrays.stream(value.split(""))
          .map(Integer::valueOf)
          .sorted()
          .map(String::valueOf)
          .collect(Collectors.joining(""));

      if(value.replace(REPLACE_TARGET, "").length() <= 3
          && sortedValue.equals(value)){
        passwords.add(value);
      }
    });

    System.out.printf("submit %d-%s%n", passwords.size(), passwords.get(55));
  }
}
