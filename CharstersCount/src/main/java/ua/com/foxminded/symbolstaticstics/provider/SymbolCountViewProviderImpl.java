package ua.com.foxminded.symbolstaticstics.provider;

import java.util.Map;

public class SymbolCountViewProviderImpl implements SymbolViewProvider {
   private static final String VIEW_TEMPLATE = "\"%s\" = %s\r\n";
   
   @Override
   public String provideView(Map<Character, Integer> symbolToCounter) {
      StringBuilder result = new StringBuilder();
      
      symbolToCounter.forEach((key, value) -> result.append(String.format(VIEW_TEMPLATE, key, value)));

      return result.toString().trim();
   }
}
