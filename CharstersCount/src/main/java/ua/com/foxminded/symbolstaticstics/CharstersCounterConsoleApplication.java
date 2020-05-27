package ua.com.foxminded.symbolstaticstics;

import ua.com.foxminded.symbolstaticstics.provider.CacheProviderImpl;
import ua.com.foxminded.symbolstaticstics.provider.SymbolStaticticsCounterImpl;
import ua.com.foxminded.symbolstaticstics.provider.SymbolStatisticProvider;
import ua.com.foxminded.symbolstaticstics.provider.SymbolCountViewProviderImpl;
import ua.com.foxminded.symbolstaticstics.reader.ConsoleReader;
import ua.com.foxminded.symbolstaticstics.reader.ConsoleReaderImpl;
import ua.com.foxminded.symbolstaticstics.validator.ValidatorImpl;

public class CharstersCounterConsoleApplication {
   public static void main(String[] args) {
      ConsoleReader reader = new ConsoleReaderImpl();

      SymbolStatisticProvider counter = new SymbolStatisticProvider(new ValidatorImpl(), new SymbolStaticticsCounterImpl(),
            new CacheProviderImpl(), new SymbolCountViewProviderImpl());
      
      boolean needContinue = true;
      
      while (needContinue) {
         String readLine = reader.read();
         
         if(readLine.equals("exit")) {
            needContinue = false;
         }
         
         System.out.println(counter.provideSatistic(readLine));
      }
   }
}
