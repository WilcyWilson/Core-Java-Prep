package javaprepsecondscope;

import javaprepfirstscope.ProtectedScope;

public class ProtectedScopeTest extends ProtectedScope {
    public static void main(String[] args) {
        ProtectedScopeTest protectedScope = new ProtectedScopeTest();
        System.out.println(protectedScope.b);
        protectedScope.abc();
    }
}

