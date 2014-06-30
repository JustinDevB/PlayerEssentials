package jjbat_000.playeressentials.util;

public enum MessageType {
    INFO("$b$o"),
    SUCCESS("$a$o"),
    WARNING("$c$o");

    private String format;

    private MessageType(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
