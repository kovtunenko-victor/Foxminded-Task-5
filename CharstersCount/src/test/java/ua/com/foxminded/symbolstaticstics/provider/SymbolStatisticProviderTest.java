package ua.com.foxminded.symbolstaticstics.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.LinkedHashMap;

import ua.com.foxminded.symbolstaticstics.validator.ValidatorImpl;

class SymbolStatisticProviderTest {
   @Mock
   private ValidatorImpl validator;
   
   @Mock
   private SymbolStaticticsCounterImpl counter;

   @Mock
   private CacheProviderImpl cache;
   
   @Mock
   private SymbolCountViewProviderImpl view;

   private SymbolStatisticProvider statisticProvider; 
   
   @BeforeEach
   public void initMocks() {
       MockitoAnnotations.initMocks(this);
       
       statisticProvider = new SymbolStatisticProvider(validator, counter, cache, view);
   }

   @Test
   void provideSatisticShouldReturnCalculatedCountOfCharacterInInputText() {
      Map<Character, Integer> charactersCount = new LinkedHashMap<Character, Integer>();

      charactersCount.put('T', 1);

      charactersCount.put('e', 1);

      charactersCount.put('s', 1);

      charactersCount.put('t', 1);

      when(counter.provideSybolStaticstics("Test")).thenReturn(charactersCount);

      String result = "\"T\" = 1\r\n" + "\"e\" = 1\r\n" + "\"s\" = 1\r\n" + "\"t\" = 1";

      when(view.provideView(charactersCount)).thenReturn(result);

      String actual = statisticProvider.provideSatistic("Test");

      assertEquals(result, actual);
   }

   @Test
   void provideSatisticShouldThrowIllegalArgumentExceptionIfInputTextIsNull() {
      IllegalArgumentException exception = new IllegalArgumentException();

      doThrow(exception).when(validator).validate(null);

      assertThrows(IllegalArgumentException.class, () -> {
         statisticProvider.provideSatistic(null);
      });
   }

   @Test
   void provideSatisticShouldReturnCountOfCharacterFromCacheInInputText() {
      Map<Character, Integer> charactersCount = new LinkedHashMap<Character, Integer>();

      charactersCount.put('T', 1);

      charactersCount.put('e', 1);

      charactersCount.put('s', 1);

      charactersCount.put('t', 1);

      when(cache.isPresent("Test")).thenReturn(true);

      when(cache.get("Test")).thenReturn(charactersCount);

      String result = "\"T\" = 1\r\n" + "\"e\" = 1\r\n" + "\"s\" = 1\r\n" + "\"t\" = 1";
      
      when(view.provideView(charactersCount)).thenReturn(result);

      String actual = statisticProvider.provideSatistic("Test");

      assertEquals(result, actual);
   }
}
