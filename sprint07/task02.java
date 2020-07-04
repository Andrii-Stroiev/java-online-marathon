import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();

    String date() default "today";
}

class Util {
    public static void review(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Review.class)) {
                Review review = clazz.getAnnotation(Review.class);

                System.out.println("Class " + className + " was reviewed " + (review.date().equals("today") ? LocalDate.now() : review.date()) + " by " + review.reviewer() + ".");
            } else System.out.println("Class " + className + " isn't marked as Reviewed");
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}
