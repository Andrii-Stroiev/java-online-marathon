 class PersonComparator implements Comparator<Person>{
     @Override
     public int compare(Person p1, Person p2) {
         return p1.toString().compareTo(p2.toString()) ;
     }

 }
 class EmployeeComparator implements Comparator<Employee>{
     @Override
     public int compare(Employee e1, Employee e2) {
         return e1.toString().compareTo(e2.toString()) ;
     }
 }
 class DeveloperComparator implements Comparator<Developer>{
     @Override
     public int compare(Developer d1, Developer d2) {
         return d1.toString().compareTo(d2.toString()) ;
     }
 }
 class Utility{
    public static  <T extends Person> void sortPeople(T[] people, Comparator<? super T> comparator){
        Arrays.sort(people,comparator);
    }

 }
