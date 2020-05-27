package ua.com.foxminded.symbolstaticstics.provider;

import java.util.WeakHashMap;
import java.util.Map;

public class CacheProviderImpl implements CacheProvider<String, Map<Character, Integer>> {
   private final Map<String, Map<Character, Integer>> cacheItems;

   public CacheProviderImpl() {
      cacheItems = new WeakHashMap<>();
   }

   @Override
   public Map<Character, Integer> get(String text) {
      return cacheItems.get(text);
   }

   @Override
   public void put(String text, Map<Character, Integer> symbolToCounter) {
      cacheItems.put(text, symbolToCounter);
   }

   @Override
   public boolean isPresent(String text) {
      return cacheItems.containsKey(text);
   }
}
