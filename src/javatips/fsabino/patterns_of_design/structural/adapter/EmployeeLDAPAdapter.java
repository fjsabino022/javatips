package javatips.fsabino.patterns_of_design.structural.adapter;

public class EmployeeLDAPAdapter implements Employee {

    private EmployeeLDAP instance;

    public EmployeeLDAPAdapter (EmployeeLDAP employeeLDAP) {
      this.instance = employeeLDAP;
    }

    @Override
    public String getId() {
        return this.instance.getCn();
    }

    @Override
    public String getFirstName() {
        return this.instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return this.instance.getSurname();
    }

    @Override
    public String getEmail() {
        return this.instance.getMail();
    }

    @Override
    public String toString() {
        return "EmployeeLDAPAdapter{" +
                "instance=" + instance +
                '}';
    }
}
