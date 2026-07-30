package javaprepfirstscope;

public class PortectedScopeSamePacakge {
    public static void main(String[] args) {
        ProtectedScope ps = new ProtectedScope();
        System.out.println(ps.b);
        System.out.println(ps.getB());
    }
}
