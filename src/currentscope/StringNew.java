package currentscope;

public non-sealed class StringNew extends SealedClass {
    public int a = 1;
    public static void b(int c){
//        System.out.print(a);
    }

    public void abc(){
        StaticClass.ABC();
    }

    @Override
    public void aVoid() {
        System.out.println("This is a void method");
    }

//    public static void main(String[] args) {
//        StaticClass.ABC();
//        StringNew s=new StringNew();
//        s.abc();
//    }

    public static void main(String[] args) {
        StringNew s1 = new StringNew();
        s1.aVoid();
    }
}

