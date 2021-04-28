package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected Logger logger;

    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }
}
