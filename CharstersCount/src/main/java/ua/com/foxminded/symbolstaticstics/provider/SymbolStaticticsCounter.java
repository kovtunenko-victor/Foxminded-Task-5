package ua.com.foxminded.symbolstaticstics.provider;

import java.util.Map;

public interface SymbolStaticticsCounter {
   Map<Character, Integer> provideSybolStaticstics(String text);
}
