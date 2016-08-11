package org.codingmatters.dzone.chemicals;

/**
 * Created by nelt on 8/11/16.
 */
public class Conformity {

    public static Conformity conform() {
        return new Conformity(true);
    }

    public static Conformity notConform() {
        return new Conformity(false);
    }



    private final Boolean conform;

    private Conformity(Boolean conform) {
        this.conform = conform;
    }

    public Boolean isConform() {
        return conform;
    }
}
