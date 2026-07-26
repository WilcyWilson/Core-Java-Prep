package currentscope;

public class ProtectedScope{
    protected final String b = "abc";
    protected void abc(){
        System.out.println("Inside abc");
        System.out.println(b);
    }

    public String getB() {
        return b + "rtx";
    }
}

