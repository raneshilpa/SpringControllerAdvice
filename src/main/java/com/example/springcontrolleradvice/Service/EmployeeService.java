package com.example.springcontrolleradvice.Service;

import com.example.springcontrolleradvice.dao.EmpRepository;
import com.example.springcontrolleradvice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmpRepository empRepository;

//    private static List<Employee> list = new ArrayList<>();
//
//    static {
//        list.add(new Employee(1, "Employee 1", 28, "India"));
//        list.add(new Employee(2, "Employee 2", 29, "India"));
//        list.add(new Employee(3, "Employee 3", 30, "India"));
//        list.add(new Employee(4, "Employee 4", 43, "India"));
//        list.add(new Employee(5, "Employee 5", 55, "India"));
//    }

    public List<Employee> getList () {

        List<Employee> list= (List<Employee>)this.empRepository.findAll();
            return list;
        }
    public Employee addEmployee(Employee e)
    {
        Employee result=empRepository.save(e);
        return result;

    }
    public void deleteEmployee(Integer id)
    {
        empRepository.deleteById(id);
    }
    public void updateEmployee(Employee employee , Integer id)
    {
        employee.setId(id);
        empRepository.save(employee);

    }

    public  Employee getEmployee (Integer id)
    {
        Optional<Employee> employee = null;

//        Optional<Employee> theEmployee = list.stream().filter(e -> e.getId() == id).findFirst();
//        if (!theEmployee.isPresent()) {
//            throw new ResourceNotFoundException("Employee not found for the id->"+id);
//        }
//        return theEmployee.get();
        try {
            employee = this.empRepository.findById(id);

        }catch(Exception e)
        {
            e.printStackTrace();
        }

       return employee.get();

    }

}
