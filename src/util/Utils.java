package util;

/**
 * @author dominikerlich
 * @created 04/05/2022
 * @project MP1
 */
public class Utils {
   public static boolean validateString(String text) {
      if (text == null) {
          return false;
      }
       return !text.isBlank();
   }
}
