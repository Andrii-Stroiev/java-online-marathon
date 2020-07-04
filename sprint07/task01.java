import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface CamelCase {

}
class CheckCamelCase{
    public static final String CAMELCASE_PATTERN = "^[a-z]+[a-zA-Z0-9]*$";

  public static boolean  checkAndPrint(Class clazz){
      final Method[] methods = clazz.getMethods();
      Pattern pattern =Pattern.compile(CAMELCASE_PATTERN);
      String msg ="";

      for (int i = 0; i <methods.length ; i++) {
          if ( methods[i].isAnnotationPresent(CamelCase.class) && !pattern.matcher(methods[i].getName()).matches()){
              msg += "method "+clazz.getSimpleName() +"."+ methods[i].getName() +" doesn't satisfy camelCase naming convention\n";
          }
      }
        if (msg.isEmpty()){
            return true;
        }
        else
            System.out.println(msg);
        return false;
    }
}


class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

public class Class1{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void InCorrect(){}
    @CamelCase
    public void JustMethod(){}
}

public class Class2{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void oneMoreCorrect(){}
}
