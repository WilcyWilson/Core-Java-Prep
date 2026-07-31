package javaprepfirstscope;

public class NestedRecord {

    //Implicitly static
    public record Patient(String firstName, String lastName) {
    }

    public Patient createPatient(String firstName, String lastName) {
        System.out.println("Calling for inside class method");
        return new Patient(firstName, lastName);
    }
}

