package javaprepfirstscope;

import java.util.ArrayList;
import java.util.List;

public class ThreadComparisionPlatformThreadFailure {
    private static final int THREAD_COUNT = 1_00_00;

//    /Users/wilsonshrestha/Library/Java/JavaVirtualMachines/openjdk-27/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=60196 -agentpath:/private/var/folders/w1/sd_c0zrn7ws_1wqn75sjpr6m0000gn/T/idea_libasyncProfiler_dylib_temp_folder/libasyncProfiler.dylib=start,jfr,event=wall,interval=10ms,jfrsync=profile,cstack=no,file=/Users/wilsonshrestha/IdeaSnapshots/ThreadComparision_2026_09_17_174652.jfr,log=/private/var/folders/w1/sd_c0zrn7ws_1wqn75sjpr6m0000gn/T/ThreadComparision_2026_09_17_174652.jfr.log.txt,logLevel=DEBUG -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/wilsonshrestha/IdeaProjects/Core-Java-Prep/out/production/java-prep:/Users/wilsonshrestha/.m2/repository/org/junit/jupiter/junit-jupiter/6.0.0/junit-jupiter-6.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/junit/jupiter/junit-jupiter-api/6.0.0/junit-jupiter-api-6.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/opentest4j/opentest4j/1.3.0/opentest4j-1.3.0.jar:/Users/wilsonshrestha/.m2/repository/org/junit/platform/junit-platform-commons/6.0.0/junit-platform-commons-6.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/apiguardian/apiguardian-api/1.1.2/apiguardian-api-1.1.2.jar:/Users/wilsonshrestha/.m2/repository/org/jspecify/jspecify/1.0.0/jspecify-1.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/junit/jupiter/junit-jupiter-params/6.0.0/junit-jupiter-params-6.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/junit/jupiter/junit-jupiter-engine/6.0.0/junit-jupiter-engine-6.0.0.jar:/Users/wilsonshrestha/.m2/repository/org/junit/platform/junit-platform-engine/6.0.0/junit-platform-engine-6.0.0.jar javaprepfirstscope.ThreadComparision
//[2.962s][warning][os,thread] Failed to start thread "Unknown thread" - pthread_create failed (EAGAIN) for attributes: stacksize: 2048k, guardsize: 16k, detached.
//[2.962s][warning][os,thread] Failed to start the native thread for java.lang.Thread "Thread-4061"
//    Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
//    at java.base/java.lang.Thread.start0(Native Method)
//    at java.base/java.lang.Thread.start(Thread.java:1470)
//    at javaprepfirstscope.ThreadComparision.runThreads(ThreadComparision.java:24)
//    at javaprepfirstscope.ThreadComparision.main(ThreadComparision.java:10)

    static void main() throws InterruptedException {
        // This will result in Out of memory error. MACOS Thread limit is about 4000, keeping platform count below that
        // With 1_00_00 platform threads the stack size shows 2048k, macOS assigned 2 MB native stack
        // to every single platform thread. Spawning 4061 Thread consumed 8 GB of RAM
        runThreads(false);
        Thread.sleep(3000);
        runThreads(true);
    }

    private static void runThreads(boolean virtual) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = virtual
                    ? Thread.ofVirtual()
                            .unstarted(ThreadComparisionPlatformThreadFailure::simulateWork)
                    : Thread.ofPlatform()
                            .unstarted(ThreadComparisionPlatformThreadFailure::simulateWork);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void simulateWork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
