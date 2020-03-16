package stream.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonAtomic {

    private static AtomicReference<SingletonAtomic> INSTANCE;

    private SingletonAtomic(){
        INSTANCE = new AtomicReference<>();
    }
    public static SingletonAtomic getInstance(){

        if(INSTANCE == null){
            SingletonAtomic s = new SingletonAtomic();
            INSTANCE.compareAndSet(s, null);
        }
        return getInstance();
    }
}