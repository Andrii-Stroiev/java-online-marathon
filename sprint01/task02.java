//1. Create an instances of Employee class named 'emp1' and 'emp2'.
//2. Set not null values for 'fullName' and 'salary' properties.
//3. Create array of Employee type with name 'employees' and add two objects created before.
//4. Create variable with name 'employeesInfo' of String type.
//5. Using a loop, iterrate across array and write to variable named 'employeesInfo' info about each employee in next fommat:

Employee emp1 =  new Employee();
Employee emp2 = new Employee();

emp1.fullName = "Andrii Stroiev";
emp1.salary = 1000.0f;

emp2.fullName = "Peter Jonson";
emp2.salary = 2000.0f;

Employee [] employees = new Employee[2];
employees[0] = emp1;
employees[1] = emp2;

 String employeesInfo = "[" ;
 
    for (Employee emp : employees) {
    employeesInfo += String.format("{fullName: \"%s\", salary: %s}",emp.fullName,emp.salary);
     }
         
 employeesInfo = employeesInfo.replace("}{","}, {") +"]";
      
