package chronos;

import bootstrap.Driver;
import domain.ApplicationConfig;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalWatchTest {
    private LocalWatch localWatch;
    private ApplicationConfig applicationConfig;

    @Before
    public void setUp() {
        System.out.println("This is a test");
        try {
            this.applicationConfig = new ApplicationConfig(
                    "--debug.logging false --repeat.interval.seconds 5 --timezone America/New_York".split(" "));
            Driver.configureConsoleLogging(applicationConfig.getDebugLogging());
            this.localWatch = new LocalWatch(applicationConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLocalWatch() {
        System.out.println("Test called. ");
        localWatch.setDateTime(1647491131547l);
        //localWatch.setDateTime(localWatch.getDateTime().withMillis(1647361224l));
        //System.out.println(localWatch.getDateTime());
        assertEquals("sdf", "sdf");
        System.out.println("new datetime1 = " + localWatch.getDateTime());
    }
}
