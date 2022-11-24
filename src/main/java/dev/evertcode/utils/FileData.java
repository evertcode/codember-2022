package dev.evertcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * FileData
 * <p/>
 *
 * @author evertcode.
 * @version 1.0.0 created on 23/11/2022 06:24 p.m.
 */
public final class FileData {

  public static Optional<String> data(final String urlFile) {
    try{
      var lines = Files.lines(Paths.get(urlFile));
      var data = lines.collect(Collectors.joining(""));

      lines.close();

      return Optional.of(data);
    }catch (final IOException ioException){
      return Optional.empty();
    }
  }
}
