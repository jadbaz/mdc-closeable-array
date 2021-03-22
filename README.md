# MDC Closeable Array
## Usage
- Build it
- Add it to your jar classpath (can't be bothered to publish to maven)
- Make sure you have added MDC output to your log config so you can validate this
- Then try something like this:
```
import com.jadbaz.MDCCloseableArray;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(MDCCloseableArrayTest.class);

    @Test
    public static void main() {
        try(final MDCCloseableArray.Instance closeable1 = MDCCloseableArray
                .put("key1", "val1")
                .put("key2", "val2")
        ) {
            log.info("Inside");
        }
    }
}
```