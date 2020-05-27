package ua.com.foxminded.symbolstaticstics.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolStaticticsCounterImpl implements SymbolStaticticsCounter {
   private static final String TEXT_SEPARATOR = "";

   @Override
   public Map<Character, Integer> provideSybolStaticstics(String text) {
      Map<Character, Integer> charactersCount = new LinkedHashMap<>();

      String[] symbols = text.split(TEXT_SEPARATOR);

      for (int i = 0; i < symbols.length; i++) {
         charactersCount.merge(symbols[i].toCharArray()[0], 1, Integer::sum);
      }

      return charactersCount;
   }
}
