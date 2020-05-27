package ua.com.foxminded.symbolstaticstics.provider;

import java.util.Map;

public interface SymbolViewProvider {
    String provideView(Map<Character, Integer> symbolToCounter);
}
