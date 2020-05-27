package ua.com.foxminded.symbolstaticstics.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class SymbolCountViewProviderImplTest {
   private final SymbolCountViewProviderImpl view = new SymbolCountViewProviderImpl();

   @Test
   void provideViewShouldReturnCountOfCharacterInInputText() {
      Map<Character, Integer> symbolToCounter = new LinkedHashMap<>();

      symbolToCounter.put('T', 1);

      symbolToCounter.put('e', 1);

      symbolToCounter.put('s', 1);

      symbolToCounter.put('t', 1);

      String actual = view.provideView(symbolToCounter);
      
      String expected = "\"T\" = 1\r\n" + 
                        "\"e\" = 1\r\n" + 
                        "\"s\" = 1\r\n" + 
                        "\"t\" = 1";
      
      assertEquals(expected, actual);
   }
}
