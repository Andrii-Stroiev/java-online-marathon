import java.util.function.Predicate;
import java.util.Set;

class MyUtils {

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> set) {
        Predicate<Integer> predicateFromSet = set.iterator().next();
        for (Predicate<Integer> predicate : set) {
            predicateFromSet = predicate.and(predicateFromSet);
        }
        return predicateFromSet;
    }
}
