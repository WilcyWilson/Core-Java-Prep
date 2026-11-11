## Everything about Boolean and boolean in Java
<details>

<summary>
  <h2>Click to reveal.</h2>
</summary>


#### Is boolean a primitive type or an object wrapper?
<details>
  <summary>
    Click to reveal answer.
  </summary>
  
      A primitive data type.
</details>

#### Is Boolean a primitive type or an object wrapper?
<details>
  <summary>
    Click to reveal answer.
  </summary>
  
      An object wrapper class.
</details>


#### Where is a local boolean variable typically stored in memory?
<details>
  <summary>
    Click to reveal answer.
  </summary>

     On the **stack**. If its a local variable inside a method. In the heap if its a class field

<img width="1296" height="336" alt="image" src="https://github.com/user-attachments/assets/4004a05a-abfb-4a3c-b924-3662a79892c7" />
</details>

#### Where is a Boolean object stored in memory?
<details>
  <summary>
    Click to reveal answer.
  </summary>

     On the heap.
</details>

#### What is the default value of a boolean class field?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    false
</details>

#### What is the default value of a Boolean class field?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    null
</details>

#### Can a primitive boolean store a null value?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    No.
</details>

#### Why is Boolean used instead of boolean in Java Collections?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Java Generics do not support primitive data types.
</details>

#### What is the term for automatically converting a boolean to a Boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Autoboxing.
</details>

#### What is the term for automatically converting a Boolean to a boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Unboxing.
</details>

#### Which method does the compiler inject during autoboxing of a boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Boolean.valueOf()
</details>

#### Which method does the compiler inject during unboxing of a Boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    booleanValue()
</details>

#### What happens at runtime when Java attempts to unbox a null Boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    A NullPointerException is thrown.
</details>

#### Why is boolean preferred over Boolean for high-performance loops?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    To avoid the memory overhead and GC pressure caused by creating wrapper objects.
</details>

#### What is the null-safe way to check if a Boolean variable is true?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Boolean.TRUE.equals(variable)
</details>

#### How many bits of information does a boolean logically represent?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    1 bit.
</details>

#### Why does Boolean have more memory overhead than boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It includes an object header in addition to the primitive value.
</details>

#### What is the short-circuit behavior of the && operator?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It skips the right-hand side if the left-hand side is false.
</details>

#### What is the short-circuit behavior of the || operator?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It skips the right-hand side if the left-hand side is true.
</details>

#### How does the & operator differ from && when used with booleans?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    & evaluates both sides regardless of the first value (no short-circuiting).
</details>

#### How does the | operator differ from || when used with booleans?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    | evaluates both sides regardless of the first value (no short-circuiting).
</details>

#### What is the result of true ^ true in Java?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    false
</details>

#### Which operator returns true only if the two boolean inputs are different?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    The XOR operator (^).
</details>

#### What is the result of the Logical NOT (!) operator applied to true?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    false
</details>

#### Why should .equals() be used instead of == to compare two Boolean objects?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    == compares memory references, while .equals() compares logical values.
</details>

#### What is the fundamental difference between boolean and Boolean in Java?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    boolean is a primitive data type, while Boolean is an object wrapper class.
</details>

#### What is the default value of a boolean variable when declared as a class field?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    false
</details>

#### What is the default value of a Boolean object reference when declared as a class field?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    null
</details>

#### Why does a Boolean object have higher memory overhead than a boolean primitive?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It is stored on the heap and includes an object header plus the internal primitive value.
</details>

#### Why can't you store boolean primitives directly in a List or Map?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Java Generics do not support primitives; they require **object types** like Boolean.
</details>

#### What is the result of attempting to call a method like .toString() on a boolean primitive?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    A **compilation error** (primitives do not have methods).
</details>

#### How does the Java compiler perform autoboxing for a boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It automatically converts the primitive boolean to a Boolean object using Boolean.valueOf().
</details>

#### How does the Java compiler perform unboxing for a Boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It extracts the primitive value by automatically calling the booleanValue() method.
</details>

#### What is the "Hidden Danger" of unboxing a Boolean object that is null?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It throws a NullPointerException (NPE) because the compiler tries to call .booleanValue() on a null reference.
</details>

#### Why is using Boolean in a massive loop for mathematical/logical operations inefficient?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It causes performance degradation due to constant object creation and increased Garbage Collection pressure.
</details>

#### Why is it dangerous to rely on == when comparing wrapper objects like Integer or Boolean?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    The == operator compares memory references (addresses) rather than logical values.
</details>

#### How can you safely check if a Boolean object is true without risking a NullPointerException?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Use Boolean.TRUE.equals(yourObject).
</details>

#### How does the short-circuit AND operator (&&) behave if the left operand is false?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It skips evaluation of the right operand because the overall result is guaranteed to be false.
</details>

#### How does the short-circuit OR operator (||) behave if the left operand is true?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It skips evaluation of the right operand because the overall result is guaranteed to be true.
</details>

#### In what specific scenario is a short-circuit AND (&&) commonly used to prevent crashes?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    To perform a null check before accessing a member: if (user != null && user.isActive()).
</details>

#### What is the difference between the logical AND (&&) and the bitwise AND (&) when used on booleans?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    && is short-circuiting, while & forces evaluation of both sides regardless of the first result.
</details>

#### What is the logical result of the Exclusive OR (^) operator?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It returns true only if the two inputs are different (one true, one false).
</details>

#### What is the result of the expression true ^ true in Java?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    false
</details>

#### What does the logical NOT (!) operator do to a boolean value?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It flips the value (e.g., !true becomes false).
</details>
   
</details>

## Java Access Modifiers and Non-Access Modifiers
<details>
  
<summary>
  <h2>Click to reveal.</h2>
</summary>

#### What is an object header in Java?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    An object header in Java is a small block of metadata stored at the beginning of every object in heap memory. It serves as the runtime identity card for the object, allowing the Java Virtual Machine (JVM) to perform memory management, garbage collection, and synchronization.
</details>

#### In the context of Java memory, where is a static field stored?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    In the Metaspace (part of the class metadata), rather than within individual heap objects.
</details>

#### How many copies of a static field exist if a class has 1,000 instantiated objects?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Exactly one copy, shared by all instances.
</details>

#### What is the primary limitation of a static method regarding instance members?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It cannot access instance fields or instance methods because it lacks a this parameter.
</details>

#### Why can a static field be accessed even if no objects of that class have been created?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    Because static members belong to the class itself and are initialized when the class is loaded.
</details>

#### What is the effect of the final keyword on a variable?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It ensures the variable can be assigned only once; its value becomes a constant.

  <img width="1502" height="666" alt="image" src="https://github.com/user-attachments/assets/6b3bd749-17d5-4b52-9b33-772c8e37946b" />
</details>

#### When must a final instance field be initialized?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    By the end of every constructor execution.

  <img width="1504" height="1010" alt="image" src="https://github.com/user-attachments/assets/ebb8a9fe-ad98-4986-8eb0-de043cb80fe0" />

</details>

#### How does marking a method as final affect the inheritance hierarchy?
<details>
  <summary>
    Click to reveal answer.
  </summary>

    It prevents any subclass from overriding that specific method.

</details>

</details>

# Java Concurrency in Practice
One of the challenges of developing concurrent programs in Java is the mismatch between the concurrency
features offered by the platform and how developers need to think about concurrency in their programs.

Threads are the easiest way to tap the computing power of multiprocessor systems. As processor counts increase exploiting
concurrency effectively will only become more important.
