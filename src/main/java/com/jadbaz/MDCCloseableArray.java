package com.jadbaz;

import org.slf4j.MDC;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class MDCCloseableArray {
    public static class Instance implements Closeable {
        final List<MDC.MDCCloseable> mdcCloseableList = new ArrayList<>();
        public Instance put(String key, String val) {
            mdcCloseableList.add(MDC.putCloseable(key, val));
            return this;
        }

        @Override
        public void close() {
            for (MDC.MDCCloseable mdcCloseable : mdcCloseableList) {
                mdcCloseable.close();
            }
        }
    }
    public static Instance put(String key, String val) {
        Instance instance = new Instance();
        instance.put(key, val);
        return instance;
    }
}
