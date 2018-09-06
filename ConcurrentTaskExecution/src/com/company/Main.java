package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Worker implements Runnable {

    Worker() {
    }

    @Override
    public void run() {
        Thread t = new Thread();
        t.start();
    }


    class ExecutedTasks {

        public final List<Runnable> successful = new ArrayList<>();
        public final Set<Runnable> failed = new HashSet<>();
        public final Set<Runnable> timedOut = new HashSet<>();


        public ExecutedTasks execute(Collection<Runnable> actions, long timeoutMillis) throws InterruptedException {

            for (Runnable action : actions) {
                Worker w = new Worker();
                Thread t = new Thread(w);
                t.start();
            }
            ExecutedTasks result = new ExecutedTasks();
            //your code here...
            return result;
        }
    }
}
