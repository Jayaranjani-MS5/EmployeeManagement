package net.javaguides.springboot.mockito;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Repository;
import com.mindtree.employeemanagerapp.model.Employee;
 
@Repository
public class EmployeeDao {
     
    private Map<Integer, Employee> employees = new HashMap<>();
     
    public List<Employee> getEmployeeList() 
    {
        List<Employee> list = new ArrayList<>();
        if(list.isEmpty()) {
            list.addAll(employees.values());
        }
        return list;
    }
     
    public Employee getEmployeeById(int id) {
        return employees.get(id);
    }
     
    public void addEmployee(Employee employee) {
        employee.setId(employees.keySet().size() + 1);
        employees.put((int) employee.getId(), employee);
    }
     
    public void updateEmployee(Employee employee) {
    	employees.put((int) employee.getId(), employee);
    }
     
    public void deleteEmployee(int id) {
    	employees.remove(id);
    }
}