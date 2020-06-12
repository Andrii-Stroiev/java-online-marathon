//Create a new version of the Employee class that correspond next principles:
//1.All class fields must be private.
//2.Get and set methods must be used to access the class fields.
//3.The class must have a constructors with and without parameters

class Employee {
     private String fullName;
     private float salary;

     public Employee(){};
 
     public Employee(String fullName, float salary) {
         this.fullName = fullName;
         this.salary = salary;
     }

     public String getFullName() {
         return fullName;
     }

     public void setFullName(String fullName) {
         this.fullName = fullName;
     }

     public float getSalary() {
         return salary;
     }

     public void setSalary(float salary) {
         this.salary = salary;
     }
 }
