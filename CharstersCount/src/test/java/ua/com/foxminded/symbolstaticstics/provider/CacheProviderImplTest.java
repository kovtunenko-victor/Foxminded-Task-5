package ua.com.foxminded.symbolstaticstics.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CacheProviderImplTest {
   private final CacheProviderImpl cacheProvider = new CacheProviderImpl();
   
   @Test
   void getShouldReturnCacheItemMapIfTextFindedInCache() {
      cacheProvider.put("Test", new HashMap<>());
      
      Map<Character, Integer> cacheItem = cacheProvider.get("Test");

      assertNotNull(cacheItem);
   }
   
   @Test
   void getShouldReturnNullIfTextNotFindedInCache() {      
      Map<Character, Integer> cacheItem = cacheProvider.get("Test");
      
      assertNull(cacheItem);
   }
   
   @Test
   void putShouldInsertIntoCacheItemsTextAndCacheItemMapIfPassTextAndCacheItemMap() {
      cacheProvider.put("Test", new HashMap<>());
      
      Map<Character, Integer> cacheItem = cacheProvider.get("Test");
      
      assertNotNull(cacheItem);
   }
   
   @Test
   void isPresentShouldReturnTrueIfTextFindedInCache() {   
      cacheProvider.put("Test", new HashMap<>());
      
      assertEquals(true,  cacheProvider.isPresent("Test"));
   }
   
   @Test
   void isPresentShouldReturnFalseIfTextNotFindedInCache() {
      assertEquals(false,  cacheProvider.isPresent("Test"));
   }
}
