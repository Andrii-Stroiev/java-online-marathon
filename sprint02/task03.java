import java.util.*;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;


    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getStudyYears() == student.getStudyYears() &&
                getStudyPlace().equals(student.getStudyPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudyPlace(), getStudyYears());
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getExperienceYears() == worker.getExperienceYears() &&
                getWorkPosition().equals(worker.getWorkPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkPosition(), getExperienceYears());
    }
}

class StudentStudyYearsComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getStudyYears() > s2.getStudyYears()) {
            return 1;
        }
        if (s1.getStudyYears() < s2.getStudyYears()) {
            return -1;
        } else return 0;
    }
}

class WorkerExperienceYearsComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker w1, Worker w2) {
        if (w1.getExperienceYears() > w2.getExperienceYears()) {
            return 1;
        }
        if (w1.getExperienceYears() < w2.getExperienceYears()) {
            return -1;
        } else return 0;
    }
}

class MyUtils {

    public List<Person> maxDuration(List<Person> persons) {
        List<Person> mostExperiencedPersons = new ArrayList<>();
        List<Worker> workers = new ArrayList<Worker>();
        List<Student> students = new ArrayList<Student>();


        for (Person person : persons) {
            if (person instanceof Student) {
                students.add((Student) person);
            }
            if (person instanceof Worker) {
                workers.add((Worker) person);
            }
        }
        WorkerExperienceYearsComparator workerComparator = new WorkerExperienceYearsComparator();
        for (Worker worker : workers) {
            if (Collections.max(workers, workerComparator).getExperienceYears() == worker.getExperienceYears()) {
                mostExperiencedPersons.add(worker);
            }
        }
        StudentStudyYearsComparator studentComparator = new StudentStudyYearsComparator();
        for (Student student : students) {
            if (Collections.max(students, studentComparator).getStudyYears() == student.getStudyYears()) {
                mostExperiencedPersons.add(student);
            }
        }
        return mostExperiencedPersons;
    }
}
