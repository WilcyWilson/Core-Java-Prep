## Everything about Boolean and boolean in Java
<details>


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

      
</details>

# Java Concurrency in Practice
One of the challenges of developing concurrent programs in Java is the mismatch between the concurrency
features offered by the platform and how developers need to think about concurrency in their programs.

Threads are the easiest way to tap the computing power of multiprocessor systems. As processor counts increase exploiting
concurrency effectively will only become more important.
