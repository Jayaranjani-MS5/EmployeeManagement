package net.javaguides.springboot.mockito;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.employeemanagerapp.model.Employee;
 
@Service
public class EmployeeMockitoTest 
{
    @Autowired
    EmployeeDao dao;
     
    public List<Employee> getEmployeeList() {
        return dao.getEmployeeList();
    }
     
    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }
     
    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }
}