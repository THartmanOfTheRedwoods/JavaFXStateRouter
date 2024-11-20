package edu.redwoods.cis18.javafxstaterouter;

import java.util.Map;
import java.util.HashMap;

public class MainAppDataSingleton {

    private final Map<String, Object> data;

    // Private constructor so instances of services.configuration.Configuration can't be called from external class.
    private MainAppDataSingleton(){
        data = new HashMap<>();
    }

    public void remove(String dataKey, Object dataValue) {
        data.remove(dataKey, dataValue);
    }

    public void add(String dataKey, Object dataValue) {
        data.put(dataKey, dataValue);
    }

    public Object get(String dataKey) {
        return data.get(dataKey);
    }

    // Private static inner class with static instance.
    // Class doesn't load until getInstance is called.
    // Thread-Safe because SingletonHelper class and INSTANCE are static.
    // Returns a single instance of Outer class services.configuration.Configuration and can because its in services.configuration.Configuration's scope.
    private static class SingletonHelper {
        private static final MainAppDataSingleton INSTANCE = new MainAppDataSingleton();
    }

    // Static getInstance method for accessing Singleton Object in a thread safe manner.
    public static MainAppDataSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
