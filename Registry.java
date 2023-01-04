import Exceptions.EmployeeInRegistryException;

import java.util.ArrayList;

public class Registry {

    static Registry instance = null;

    private ArrayList<Employee> workers = new ArrayList<>();

    private Registry(){}

    public static Registry getRegistry(){
        if (instance == null) instance = new Registry();

        return instance;
    }

    public void addWorker (Employee emp) throws EmployeeInRegistryException {
        if(workers.contains(emp)){
            throw new EmployeeInRegistryException("Employee " + emp.name + " is already exist");
        } else {
            workers.add(emp);
        }
    }

    public void printList(){
        for(Employee emp:workers){
            System.out.println(emp);
        }
    }
}