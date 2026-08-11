package javaprepfirstscope;

// T must be Number or its subclass (Integer,Long etc.)
// Upper Bound extends
public class GenericBoundClassDemo <T extends Number> {
    private final T value;

    public GenericBoundClassDemo(T value){
        this.value = value;
    }

    // can call all Number methods: doubleValue(), intValue()
    public double getDoubleValue(){
        return value.doubleValue();
    }

    public static void main(String[] args) {
        var boundGeneric = new GenericBoundClassDemo<Integer>(21);
        var boundGenericLong = new GenericBoundClassDemo<Long>(21321321323L);
        System.out.println(boundGeneric.getDoubleValue());
        System.out.println(boundGenericLong.getDoubleValue());
    }

}
