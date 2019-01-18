package javatips.fsabino.important_tips.comparable_vs_comparator.comparator_java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SortTest {

    private List<Employee> employees = null;

    @Before
    public void initData() {
        employees = new ArrayList<Employee>();
        employees.add(new Employee("Franco", 28, 50000.00, 3476));
        employees.add(new Employee("Belen", 24, 4000.00, 34761));
        employees.add(new Employee("Tomas", 22, 0.00, 34762));
        employees.add(new Employee("Edgardo", 55, 55000.00, 34763));
    }

    @Test
    public void whenComparing_thenSortedByName() {
        Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
        employees.sort(employeeNameComparator);
        assertEquals("Belen", employees.get(0).getName());
        assertEquals("Tomas", employees.get(3).getName());
    }

    @Test
    public void whenComparingWithComparator_thenSortedByNameDesc() {
        Comparator<Employee> employeeNameDescComparator = Comparator.comparing(Employee::getName, (em1, em2) -> {
            return em2.compareTo(em1);
        });
        employees.sort(employeeNameDescComparator);
        assertEquals("Belen", employees.get(3).getName());
        assertEquals("Tomas", employees.get(0).getName());
    }

    @Test
    public void whenComparingWithComparator_thenSortedByNameDesc_reverseOrder() {
        Comparator<Employee> employeeNameDescComparatorReverse = Comparator.comparing(Employee::getName, Comparator.reverseOrder());
        employees.sort(employeeNameDescComparatorReverse);
        assertEquals("Belen", employees.get(3).getName());
        assertEquals("Tomas", employees.get(0).getName());
    }

    @Test
    public void whenComparingInt_thenSortedByAge() {
        Comparator<Employee> employeeAgeComparator = Comparator.comparingInt(Employee::getAge);
        employees.sort(employeeAgeComparator);
        assertEquals("Tomas", employees.get(0).getName());
        assertEquals("Edgardo", employees.get(3).getName());
    }

    @Test
    public void whenNaturalOrder_thenSortedByName() {
        Comparator<Employee> employeeNaturalComparator = Comparator.<Employee>naturalOrder();

        employees.sort(employeeNaturalComparator);
        assertEquals("Belen", employees.get(0).getName());
        assertEquals("Tomas", employees.get(3).getName());
    }

    @Test
    public void whenNaturalOrder_thenSortedByNameReverse() {
        Comparator<Employee> employeeNaturalComparator = Comparator.<Employee>reverseOrder();

        employees.sort(employeeNaturalComparator);
        assertEquals("Belen", employees.get(3).getName());
        assertEquals("Tomas", employees.get(0).getName());
    }

    @Test
    public void whenThenComparing_thenSortedByAgeName() {

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Franco", 22, 50000.00, 3476));
        employees.add(new Employee("Franco", 22, 4000.00, 34761));
        employees.add(new Employee("Franco", 22, 0.00, 34762));
        employees.add(new Employee("Franco", 22, 55000.00, 34763));

        Comparator<Employee> comparatorSalaryReverse = Comparator.comparingDouble(Employee::getSalary).reversed();
        Comparator<Employee> comparatorAgeAndNameAndSalary = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName)
                .thenComparing(comparatorSalaryReverse);
        employees.sort(comparatorAgeAndNameAndSalary);

        assertEquals(34763, employees.get(0).getMobile());
        assertEquals(34762, employees.get(3).getMobile());
    }
}

