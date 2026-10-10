package javaprepfirstscope;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        String filename = "exception.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            TableException originalException = new TableException("Database connection timed out.");
            out.writeObject(originalException);
            System.out.println("Exception successfully serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If you comment out the serialization and change the serialVersionUID. This is the error we get.
        //javaprepfirstscope.TableException; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
        //Changing back to the same version works
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            TableException loadedException = (TableException) in.readObject();
            System.out.println("Exception deserialized");
            System.out.println("Loaded Message: " + loadedException.getMessage());
        } catch (IOException | ClassNotFoundException e) { // | represents multi catch statement
            e.printStackTrace();
        }
    }
}
