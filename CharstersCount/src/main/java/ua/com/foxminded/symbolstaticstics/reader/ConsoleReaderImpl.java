package ua.com.foxminded.symbolstaticstics.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderImpl implements ConsoleReader {
   @Override
   public String read() {
      try {
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) {
            @Override
            public void close() {
            }
         })) {
            return reader.readLine();
         }
      } catch (NumberFormatException | IOException ex) {
         throw new IllegalArgumentException(ex);
      }
   }
}
