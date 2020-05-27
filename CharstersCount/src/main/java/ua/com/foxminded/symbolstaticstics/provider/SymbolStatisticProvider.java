package ua.com.foxminded.symbolstaticstics.provider;

import ua.com.foxminded.symbolstaticstics.validator.Validator;

import java.util.Map;

public class SymbolStatisticProvider {
   private final Validator validator;
   private final SymbolStaticticsCounter staticticsCounter;
   private final CacheProvider<String, Map<Character, Integer>> cacheProvider;
   private final SymbolViewProvider viewProvider;

   public SymbolStatisticProvider(Validator validator, SymbolStaticticsCounter staticticsCounter,
         CacheProvider<String, Map<Character, Integer>> cacheProvider, SymbolViewProvider viewProvider) {
      this.validator = validator;
      this.staticticsCounter = staticticsCounter;
      this.cacheProvider = cacheProvider;
      this.viewProvider = viewProvider;
   }

   public String provideSatistic(String text) {
      final Map<Character, Integer> symbolToCounter;

      validator.validate(text);

      if (cacheProvider.isPresent(text)) {
         symbolToCounter = cacheProvider.get(text);
      } else {
         symbolToCounter = staticticsCounter.provideSybolStaticstics(text);
         
         cacheProvider.put(text, symbolToCounter);
      }
      
      return viewProvider.provideView(symbolToCounter);
   }
}
