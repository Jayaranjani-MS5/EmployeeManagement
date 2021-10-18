package net.javaguides.springboot.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.mindtree.employeemanagerapp.model.Employee;

public class TestEmployee {

	@InjectMocks
	EmployeeMockitoTest manager;

	@Mock
	EmployeeDao dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllEmployeesTest() {
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(1L, "gopi", "yadhav", "gopi@gmail.com");
		Employee empTwo = new Employee(2L, "Alex", "raj", "alex@gmail.com");
		Employee empThree = new Employee(3L, "swathi", "sathya", "swathi@gmail.com");

		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);

		when(dao.getEmployeeList()).thenReturn(list);

		// test
		List<Employee> empList = manager.getEmployeeList();

		assertEquals(3, empList.size());
		verify(dao, times(1)).getEmployeeList();
	}

	@Test
	public void getEmployeeByIdTest() {
		when(dao.getEmployeeById(1)).thenReturn(new Employee(1L, "Lokesh", "Hari", "lokesh@email.com"));

		Employee emp = manager.getEmployeeById(1);

		assertEquals("Lokesh", emp.getFirstName());
		assertEquals("Hari", emp.getLastName());
		assertEquals("lokesh@email.com", emp.getEmailId());
	}

	@Test
	public void createEmployeeTest() {
		Employee emp = new Employee(1L, "malar", "vizhi", "malar@email.com");

		manager.addEmployee(emp);

		verify(dao, times(1)).addEmployee(emp);
	}
}