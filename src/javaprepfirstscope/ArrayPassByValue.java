package javaprepfirstscope;

public class ArrayPassByValue {
    private static void modifyValueInsideArray(int[] arr) {
        arr[2] = 111;
    }

    private static void passByValueInsideArray(int[] arr) {
        arr = new int[]{232, 456, 323};
        System.out.println("passByValueInsideArray: " + arr[2]);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        modifyValueInsideArray(arr);

        System.out.println(arr[2]);

        passByValueInsideArray(arr);
        System.out.println("In calling method: " + arr[1]);
    }
}

