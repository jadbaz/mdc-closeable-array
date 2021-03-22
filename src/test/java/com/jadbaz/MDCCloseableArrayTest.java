package com.jadbaz;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MDCCloseableArrayTest {
    private static final Logger log = LoggerFactory.getLogger(MDCCloseableArrayTest.class);

    @Test
    public void testPut() {
        log.info("Before");

        try(final MDCCloseableArray.Instance closeable1 = MDCCloseableArray
                .put("key1", "val1")
                .put("key2", "val2")
        ) {
            log.info("Inside");
            try(final MDCCloseableArray.Instance closeable2 = MDCCloseableArray
                    .put("key3", "val3")
                    .put("key4", "val3")
            ) {
                log.info("Inside inside");
            }
        }

        log.info("After");
    }
}
