package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestExecutionWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Helpers.takeScreenshot();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Helpers.takeScreenshot();
    }
}
