import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            if (name != null) {
                this.name = name;
            } else throw new NullPointerException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + name.hashCode();
            return result;
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> comStud = new HashSet<>();
        for (Student student1 : list1) {

            for (Student student2 : list2) {
                if (student1.equals(student2)) {
                    comStud.add(student1);
                }
            }
        }
        return comStud;
    }
}
