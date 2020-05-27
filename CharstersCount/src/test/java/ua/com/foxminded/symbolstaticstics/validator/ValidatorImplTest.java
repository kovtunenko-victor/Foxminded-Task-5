package ua.com.foxminded.symbolstaticstics.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidatorImplTest {
   private ValidatorImpl validator = new ValidatorImpl();
   
   @Test
   void validateShouldThrowExceptionIfSentenceIsEmptyString() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         validator.validate("");
      });

      assertEquals("Text is empty", exception.getMessage());
   }
   
   @Test
   void validateShouldThrowExceptionIfSentenceIsNull() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         validator.validate(null);
      });

      assertEquals("Text is null", exception.getMessage());
   }
}
