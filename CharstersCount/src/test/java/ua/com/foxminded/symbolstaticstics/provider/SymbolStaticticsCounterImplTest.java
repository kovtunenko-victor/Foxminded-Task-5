package ua.com.foxminded.symbolstaticstics.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class SymbolStaticticsCounterImplTest {
   private final SymbolStaticticsCounterImpl counter = new SymbolStaticticsCounterImpl();
   
   @Test
   void provideSybolStaticsticsShouldReturnMapSymbolsAndSymbolsCountIfPassSentence() {
      Map<Character, Integer> charactersCount = counter.provideSybolStaticstics("Hello world!");
      
      assertEquals(1, charactersCount.get('H'));
      
      assertEquals(1, charactersCount.get('e'));
      
      assertEquals(3, charactersCount.get('l'));
      
      assertEquals(2, charactersCount.get('o'));
      
      assertEquals(1, charactersCount.get(' '));
      
      assertEquals(1, charactersCount.get('w'));
      
      assertEquals(1, charactersCount.get('r'));
      
      assertEquals(1, charactersCount.get('d'));
      
      assertEquals(1, charactersCount.get('!'));
   }
}
