package dev.evertcode.challenge01;

import dev.evertcode.utils.Codember;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * challenge01
 * <p/>
 *
 * @author evertcode.
 * @version 1.0.0 created on 23/11/2022 06:32 p.m.
 */
public class Twitter implements Codember {

  @Override
  public void solution() {

    try {
      var content = Files.readString(Paths.get("src/main/resources/users.txt"));
      final Supplier<Predicate<HashMap<String, String>>> filterByProperties = () -> map ->
          map.containsKey("usr")
              && map.containsKey("eme") && map.containsKey("psw")
              && map.containsKey("age") && map.containsKey("loc") && map.containsKey(
              "fll");
      var result = Arrays.stream(content.split("\r\n\r\n"))
          .map(str -> str.replace("\r\n", " "))
          .map(str -> str.split(" "))
          .map(this::arrayToMap)
          .filter(filterByProperties.get())
          .collect(Collectors.toList());

      var length = result.size();

      System.out.printf("submit %d%s", length, result.get(length - 1).get("usr"));

    } catch (final IOException ioException) {
      System.err.printf("%s: %s", ioException.getMessage(), ioException);
    }
  }

  private HashMap<String, String> arrayToMap(final String[] arr) {
    var map = new HashMap<String, String>();

    Arrays.stream(arr).forEach(item -> {
      BiConsumer<HashMap<String, String>, String> consumer = (m, i) -> {
        var val = i.split(":");

        m.put(val[0], val[1]);
      };
      consumer.accept(map, item);
    });

    return map;
  }
}
