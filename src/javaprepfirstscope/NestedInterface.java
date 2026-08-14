package javaprepfirstscope;

public class NestedInterface {
    public interface ImplicitlyStaticInterface {
        void display();
    }

    public class Implementer implements ImplicitlyStaticInterface {

        @Override
        public void display() {
            System.out.println("display");
        }
    }
}

