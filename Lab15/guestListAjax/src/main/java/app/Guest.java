
package app;
/*
 * Guess has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levi
 * @since 110114
 */
public class Guest {
    private String first = "no first set yet";
    private String last = "no last set yet";
    public Guest() {
    }
    
        public Guest(String first, String last) {
            this.first = first;
            this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }




}
