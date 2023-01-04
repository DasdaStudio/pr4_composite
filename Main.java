import Exceptions.EmployeeInRegistryException;
import Exceptions.FieldLengthLimitException;
import Exceptions.IncorrectSalaryException;

public class Main {
    public static void main(String[] args){

        Registry hr = Registry.getRegistry();

        Manager ceo = null;
        try{
            ceo = new Manager("Aria", "Stark", 1500, 1000, 0);
            System.out.println(ceo);
            hr.addWorker(ceo);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee salesHead = null;
        try{
            salesHead = new Employee("John", "Snow", 4500, ceo.id);
            System.out.println(salesHead);
            hr.addWorker(salesHead);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee marketingHead = null;
        try{
            marketingHead = new Employee("Daenerys", "Targaryen", 4500, ceo.id);
            System.out.println(marketingHead);
            hr.addWorker(marketingHead);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee emp1 = null;
        try{
            emp1 = new Employee(" Cersei", "Lannister", 1000, salesHead.id);
            System.out.println(emp1);
            hr.addWorker(emp1);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        ceo.add(salesHead);
        ceo.add(marketingHead);

        salesHead.add(emp1);

        System.out.println("\nEmployee List:");
        System.out.println(ceo);
        for (Employee headEmployee : ceo.getSubordinates()) {
            System.out.print("  ");
            System.out.println(headEmployee);

            for (Employee emp : headEmployee.getSubordinates()){
                System.out.print("       ");
                System.out.println(emp);
            }
        }

    }
}