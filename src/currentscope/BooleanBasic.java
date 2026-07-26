package currentscope;

public final class BooleanBasic extends SealedClass {
    public static void main(String[] args) {
        BooleanBasic b = new BooleanBasic();
        b.aVoid();
        Boolean check = null;
        boolean abc = true;
        String abc2 = "abc";
        if (Boolean.TRUE.equals(check)) {
            System.out.println("true");
        }
    }

    private void spider(String x) {

    }

    @Override
    public void aVoid() {
        BooleanBasic b = new BooleanBasic();
        b.nonAbstract();
    }
}

