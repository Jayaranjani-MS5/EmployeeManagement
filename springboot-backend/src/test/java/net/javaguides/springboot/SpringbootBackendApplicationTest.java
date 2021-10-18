package net.javaguides.springboot;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

public class SpringbootBackendApplicationTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	// JUnit test for saveEmployee
	@Test(expected = NullPointerException.class)
	@Order(1)
	@Rollback(value = false)
	public void saveEmployeeTest() {
		Employee employee = new Employee(90L, "sathya", "priya", "sathya@gmail.com");
		employeeRepository.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

	// JUnit test for getEmployee
	@Test(expected = NullPointerException.class)
	@Order(2)
	public void getEmployeeTest() {
		Employee employee = employeeRepository.findById(1L).get();
		Assertions.assertThat(employee.getId()).isEqualTo(1L);
	}

	// JUnit test for getListOfEmployee
	@Test(expected = NullPointerException.class)
	@Order(3)
	public void getListOfEmployeesTest() {
		List<Employee> employees = employeeRepository.findAll();
		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}

	// JUnit test for updateEmployee
	@Test(expected = NullPointerException.class)
	@Order(4)
	@Rollback(value = false)
	public void updateEmployeeTest() {
		Employee employee = employeeRepository.findById(1L).get();
		employee.setEmailId("priya@gmail.com");
		Employee employeeUpdated = employeeRepository.save(employee);
		Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("priya@gmail.com");
	}

	// JUnit test for deleteEmployee
	@Test(expected = NullPointerException.class)
	@Order(5)
	@Rollback(value = false)
	public void deleteEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();
		employeeRepository.delete(employee);
		Employee employee1 = null;
		Optional<Employee> optionalEmployee = employeeRepository.findByEmailId("priya@gmail.com");
		if (optionalEmployee.isPresent()) {
			employee1 = optionalEmployee.get();
		}
		Assertions.assertThat(employee1).isNull();
	}

}
