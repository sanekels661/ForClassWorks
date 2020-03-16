package stream.singleton;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SingletonAtomic {

    private static AtomicReference<SingletonAtomic> INSTANCE;
    private final int id;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private SingletonAtomic(int id){
        this.id = id;
        INSTANCE = new AtomicReference<>();
    }
    public static SingletonAtomic getInstance(){

        if(INSTANCE == null){
            SingletonAtomic s = new SingletonAtomic(counter.getAndIncrement());
            INSTANCE.compareAndSet(null, s);
        }
        return getInstance();
    }
}