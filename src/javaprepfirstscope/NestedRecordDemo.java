package javaprepfirstscope;

public class NestedRecordDemo {
    public static void main(String[] args) {


        // Record without NestedRecord instance because Patient record is implicitly static
        NestedRecord.Patient patient = new NestedRecord.Patient("Wilson", "Shrestha");
        System.out.println(patient.firstName());
        System.out.println(patient.lastName());
        NestedRecord.Patient patient1 = new NestedRecord().createPatient("Spider", "Man");
        System.out.println(patient1.firstName());
        System.out.println(patient1.lastName());
    }
}
