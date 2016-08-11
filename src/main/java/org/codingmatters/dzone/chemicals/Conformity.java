package org.codingmatters.dzone.chemicals;

/**
 * Created by nelt on 8/11/16.
 */
public class Conformity {

    public static Conformity conform() {
        return new Conformity(true, "");
    }

    public static Conformity notConform(String reason) {
        return new Conformity(false, reason);
    }



    private final Boolean conform;
    private final String reason;

    private Conformity(Boolean conform, String reason) {
        this.conform = conform;
        this.reason = reason;
    }

    public Boolean isConform() {
        return conform;
    }

    public String getReason() {
        return reason;
    }
}
