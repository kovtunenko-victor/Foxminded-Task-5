package ua.com.foxminded.symbolstaticstics.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class ConsoleReaderImplTest {
   private ConsoleReaderImpl reader = new ConsoleReaderImpl();
   
   private final InputStream systemIn = System.in;
   
   @Test
   void getWordsFromCacheShouldReturnNullCacheItemClassIfSentenceNotFindedInCache() {
      String expected = "Hello world!";
      
      provideInput(expected);

      assertEquals(expected, reader.read());
      
      expected = "Goodbye world!";
      
      provideInput(expected);

      assertEquals(expected, reader.read());
      
      System.setIn(systemIn);
   }
   
   private void provideInput(String data) {
      ByteArrayInputStream testIn;

      testIn = new ByteArrayInputStream(data.getBytes());

      System.setIn(testIn);
   }
}
