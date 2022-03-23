package chronos;

import domain.ApplicationConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalWatch implements Runnable {
    private ApplicationConfig applicationConfig;
    private Logger logger = LoggerFactory.getLogger(LocalWatch.class);
    private DateTime dateTime;

    public LocalWatch(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
        this.dateTime = (new DateTime()).withZone(DateTimeZone.forID(applicationConfig.getTimezone()));
        logger.info("Local Watch configured in " + applicationConfig.getTimezone() + " default datetime = " + dateTime);
    }

    @Override
    public void run() {
        Thread.currentThread().setName("localWatch");
        logger.info("Current time = " + dateTime);
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        logger.info("Param datetime is " + dateTime);
        this.dateTime = dateTime;
        logger.info("Current time is = " + this.dateTime);
    }

    public void setDateTime(Long instant) {
        this.dateTime = new DateTime(instant, DateTimeZone.forID(applicationConfig.getTimezone()));
        //logger.info("Datetime = " + dateTime);
    }
}
