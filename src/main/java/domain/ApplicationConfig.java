package domain;

public class ApplicationConfig {
    private Boolean debugLogging;
    private String timezone;
    private Integer repeatIntervalSeconds;

    public ApplicationConfig(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--timezone")) {
                timezone = args[i + 1];
            }
            if (args[i].equals("--debug.logging")) {
                debugLogging = Boolean.parseBoolean(args[i + 1]);
            }
            if (args[i].equals("--repeat.interval.seconds")) {
                repeatIntervalSeconds = Integer.parseInt(args[i + 1]);
            }
        }
    }

    public Boolean getDebugLogging() {
        return debugLogging;
    }

    public void setDebugLogging(Boolean debugLogging) {
        this.debugLogging = debugLogging;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getRepeatIntervalSeconds() {
        return repeatIntervalSeconds;
    }

    public void setRepeatIntervalSeconds(Integer repeatIntervalSeconds) {
        this.repeatIntervalSeconds = repeatIntervalSeconds;
    }
}
