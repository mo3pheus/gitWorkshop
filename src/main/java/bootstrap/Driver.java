package bootstrap;

import chronos.LocalWatch;
import domain.ApplicationConfig;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {
        try {
            ApplicationConfig applicationConfig = new ApplicationConfig(args);
            configureConsoleLogging(applicationConfig.getDebugLogging());
            logger.info("Successfully accepted application properties.");
            ScheduledExecutorService scheduledExecutorService
                    = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.scheduleAtFixedRate(new LocalWatch(applicationConfig),
                    0l, applicationConfig.getRepeatIntervalSeconds().longValue(), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void configureConsoleLogging(boolean debug) {
        ConsoleAppender ca = new ConsoleAppender();
        if (!debug) {
            ca.setThreshold(Level.toLevel(Priority.INFO_INT));
        } else {
            ca.setThreshold(Level.toLevel(Priority.DEBUG_INT));
        }
        ca.setLayout(new EnhancedPatternLayout("%-6d [%25.35t] %-5p %40.80c - %m%n"));
        ca.activateOptions();
        org.apache.log4j.Logger.getRootLogger().addAppender(ca);
    }
}
