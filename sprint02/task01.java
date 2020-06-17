 class Person {
     int age;
     String name;
     String healthInfo;

    public Person(int age, String name, String healthInfo) {
         this.age = age;
         this.name = name;
         this.healthInfo = healthInfo;
     }

     String getHealthStatus(){ return name +" " + healthInfo; }
 }

 class Adult extends  Person{
    private String passportNumber;

     public Adult(int age, String name, String healthInfo, String passportNumber) {
         super(age, name, healthInfo);
         this.passportNumber = passportNumber;
     }

 }

 class Child extends Person{
   private String childIDNumber;

   public Child(int age, String name, String healthInfo, String childIDNumber){
       super(age, name, healthInfo);
       this.childIDNumber = childIDNumber;

     }
   
 }
