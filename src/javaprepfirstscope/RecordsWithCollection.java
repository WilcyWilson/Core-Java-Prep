package javaprepfirstscope;

import java.util.ArrayList;
import java.util.List;

// lists can be mutated from the outside and breaks design philosophy of records
// We need to enforce deep immutability in this case
public record RecordsWithCollection(String name, List<String> members) {
    public RecordsWithCollection {
        // Enforcing Deep immutability. List.copyOf() return immutable copy
        members = List.copyOf(members);
    }
}

class RecordImplementation {
    public static void main(String[] args) {
        RecordsWithCollection recordsWithCollection = new RecordsWithCollection("Justice League", new ArrayList<>(List.of("Batman", "Superman")));
        // Throws UnsupportedOperationException
        // Possible when List.copyOf(members) is not implemented in compact constructor but doesn't align with what records are supposed to be
//        recordsWithCollection.members()
//                             .add("Wonder Woman");
    }
}
