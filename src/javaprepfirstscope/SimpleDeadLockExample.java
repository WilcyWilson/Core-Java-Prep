package javaprepfirstscope;

public class SimpleDeadLockExample {
    static class Util{
        static void sleep(long millis){
            try{
                Thread.sleep(millis);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    class Shared{
        synchronized void test1(Shared other){
            System.out.println(Thread.currentThread().getName() + " enters test1 of " + this); // the 'this' is the object whose lock we hold
            Util.sleep(1000);
            other.test2(); // Next line for both thread. Acquire the other object's lock
            System.out.println(Thread.currentThread().getName() + " enters test1 of " + this);
        }

        synchronized void test2(){
            System.out.println(Thread.currentThread().getName() + " enters test2 of " + this);
            Util.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " enters test2 of " + this);
        }
    }

    // Thread1 holds lock(s1) --> waiting for lock(s2)
    // Thread2 holds lock(s2) --> waiting for lock(s1)

    void main() {
        Shared objectA = new Shared();
        Shared objectB = new Shared();
        Thread t1 = new Thread(() -> objectA.test1(objectB), "Thread1");
        t1.start();
        Thread t2 = new Thread(() -> objectB.test1(objectA),"Thread2");
        t2.start();
        Util.sleep(200);
    }
}
