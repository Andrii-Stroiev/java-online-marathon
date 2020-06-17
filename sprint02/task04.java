
import java.math.BigDecimal;
import java.util.*;


class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                getName().equals(employee.getName()) &&
                getPayment().equals(employee.getPayment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience(), getPayment());
    }
}

class Manager extends Employee {
    private double coefficient;


    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return new BigDecimal(coefficient).multiply(super.getPayment());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.getCoefficient(), getCoefficient()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCoefficient());
    }
}

class EmployeeExperienceComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getExperience() > emp2.getExperience()) {
            return 1;
        }
        if (emp1.getExperience() < emp2.getExperience()) {
            return -1;
        } else return 0;
    }
}

class EmployeePaymentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getPayment().compareTo(emp2.getPayment());
    }
}

class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> allEmployees = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Manager> manager = new ArrayList<>();

        for (Employee emp : workers) {
            if (emp != null) {
                if (emp instanceof Manager) {
                    manager.add((Manager) emp);
                } else employees.add(emp);
            }
        }
        EmployeeExperienceComparator employeeExperienceComparator = new EmployeeExperienceComparator();
        EmployeePaymentComparator employeePaymentComparator = new EmployeePaymentComparator();
        for (Employee emp : employees) {
            if ((Collections.max(employees, employeeExperienceComparator).getExperience() == emp.getExperience()) ||
                    (Collections.max(employees, employeePaymentComparator).getPayment().equals(emp.getPayment()))) {
                allEmployees.add(emp);
            }
        }
        for (Manager man : manager) {
            if ((Collections.max(manager, employeeExperienceComparator).getExperience() == man.getExperience()) ||
                    (Collections.max(manager, employeePaymentComparator).getPayment().equals(man.getPayment()))) {
                allEmployees.add(man);
            }
        }
        return allEmployees;
    }
}
