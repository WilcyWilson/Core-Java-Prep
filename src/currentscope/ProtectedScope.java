package currentscope;

public class ProtectedScope{
    protected final String b = "abc";
    private int total = 200;
    protected void abc(){
        System.out.println("Inside abc");
        System.out.println(b);
    }

    public String getB() {
        return b + "rtx";
    }

    private void deposit(int value){
        total = total + value;
    }

    private int getter (){
        return total;
    }
}

