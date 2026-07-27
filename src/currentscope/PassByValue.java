package currentscope;

import java.util.Arrays;

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

        System.out.println("\nLocal Mutated Values after swap: \n");
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

    // Object Wrapper act like Primitive Type and won't swap the actual value outside the method
    void objectWrapper(String x, Integer y) {
        System.out.println("\nInside Method: Object Wrapper before swap");
        System.out.println(x);
        System.out.println(y);
        x = x + "What";
        y = y + 10;
        System.out.println("\nInside Method: Object Wrapper after swap");
        System.out.println(x);
        System.out.println(y);
    }

    // Arrays are references too
    void arrayTest(int[] arr) {
        System.out.println("\nInside Method: Array before swap");
        System.out.println(Arrays.toString(arr));
        arr[0] = 99; // mutation is visible to caller
        System.out.println("\nInside Method: Array after swap");
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2}; // reassignment is not visible because it's pointing to new memory reference now
        System.out.println(Arrays.toString(arr));
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

        System.out.println("\nObject Wrapper before swap");
        String value1 = "abc";
        Integer value2 = 20;
        System.out.println(value1);
        System.out.println(value2);
        passByValue.objectWrapper(value1, value2);
        System.out.println("\nObject Wrapper after swap");
        System.out.println(value1);
        System.out.println(value2);

        int[] arr = new int[]{20};
        System.out.println("\nOutside Method: Array before swap");
        System.out.println(Arrays.toString(arr));
        passByValue.arrayTest(arr);
        System.out.println("\nOutside Method: Array after swap");
        System.out.println(Arrays.toString(arr));
    }
}
