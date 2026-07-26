package differentscope;

import currentscope.ProtectedScope;

public class ProtectedScopeTest extends ProtectedScope {
    public static void main(String[] args) {
        ProtectedScopeTest protectedScope = new ProtectedScopeTest();
        System.out.println(protectedScope.b);
        protectedScope.abc();
    }
}
