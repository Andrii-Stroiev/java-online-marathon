import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Modifier;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value();
}

class TestSuitHandler {
    public static void run(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            TestSuite testSuite = clazz.getAnnotation(TestSuite.class);
            for (int i = 0; i < testSuite.value().length; i++) {
                try {
                    if (clazz.getMethod(testSuite.value()[i]).getParameterCount() == 0 && !Modifier.isStatic(clazz.getMethod(testSuite.value()[i]).getModifiers())) {
                        System.out.println("\t -- Method " + clazz.getSimpleName() + "." + testSuite.value()[i] + " started --");
                        try {
                            clazz.getMethod(testSuite.value()[i]).invoke(clazz.getDeclaredConstructor().newInstance());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("\t -- Method " + clazz.getSimpleName() + "." + testSuite.value()[i] + " finished --");
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("Method with name " + testSuite.value()[i] + " doesn't exists or not public in class " + clazz.getSimpleName());
                }
            }
        } else System.out.println("Class " + clazz.getSimpleName() + " isn't annotated");

    }
}
