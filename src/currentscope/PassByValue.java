package currentscope;

public class PassByValue {
    private int test = 1000;

    void swapPrimitiveValue(int x, int y) {
        System.out.println("Local Value Before Swap");
        System.out.println(x);
        System.out.println(y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("Local Value After Swap");
        System.out.println(x);
        System.out.println(y);
    }

    void swapObjects(PassByValue passByValue1, PassByValue passByValue2) {
        System.out.println("\nMutated Values before swap:");
        passByValue1.getMutatedObject();
        passByValue1.getMutatedObject();

        System.out.println("\nLocal Hashcode Before Swap");
        System.out.println(System.identityHashCode(passByValue1));
        System.out.println(System.identityHashCode(passByValue2));

        // Mutating and then Swapping
        passByValue1.mutateObjects();

        PassByValue tempPassByValue;
        tempPassByValue = passByValue1;
        passByValue1 = passByValue2;
        passByValue2 = tempPassByValue;

        System.out.println("\nLocal Hashcode After Swap");
        System.out.println(System.identityHashCode(passByValue1));
        System.out.println(System.identityHashCode(passByValue2));

        System.out.printf("\nLocal Mutated Values after swap: \n");
        System.out.println("\nPassByValue1 Mutated");
        passByValue1.getMutatedObject();
        System.out.println("\nPassByValue2 Mutated");
        passByValue2.getMutatedObject();
    }

    void mutateObjects() {
        test = test + 10;
    }

    void getMutatedObject() {
        System.out.println(test);
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        System.out.println("Value Before Swap");
        System.out.println(x);
        System.out.println(y);
        PassByValue passByValue = new PassByValue();
        passByValue.swapPrimitiveValue(x, y);
        System.out.println("\nValue After Swap");
        System.out.println(x);
        System.out.println(y);
        PassByValue passByValue1 = new PassByValue();
        PassByValue passByValue2 = new PassByValue();

        System.out.println("\nHashcode before Swap");
        System.out.println(System.identityHashCode(passByValue1));
        System.out.println(System.identityHashCode(passByValue2));
        passByValue.swapObjects(passByValue1, passByValue2);
        System.out.println("\nHashcode after Swap");
        System.out.println(System.identityHashCode(passByValue1));
        System.out.println(System.identityHashCode(passByValue2));

        System.out.println("\nPassByValue1 Mutated");
        passByValue1.getMutatedObject();
        System.out.println("\nPassByValue2 Mutated");
        passByValue2.getMutatedObject();
    }
}
