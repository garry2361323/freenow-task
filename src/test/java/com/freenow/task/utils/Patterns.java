package com.freenow.task.utils;

import org.hamcrest.core.Every;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

public abstract class Patterns {
    // todo handle duplicate symbols
    private static final String emailPattern =
            "^(?![._\\-+])[a-zA-Z0-9_.+-]*[a-zA-Z0-9]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]*[a-zA-Z0-9]+$";

    public static Pattern getEmailPattern() {
        // Patterns.verifyEmailPattern();
        return Pattern.compile(emailPattern);
    }

    @SuppressWarnings("unused")
    private static void verifyEmailPattern() {
        var validEmails = new ArrayList<String>() {{
            add("q@q.q");
            add("Q.q_w-w+1@foo1-bar2.foo.bar");
        }};
        var invalidEmails = new ArrayList<String>() {{
            add(null);
            add("");
            add("@.");
            add("q@.q");
            add("@q.q");
            add("q@");
            add("q@q.");
            add(".@q.q");
            add("_@q.q");
            add("-@q.q");
            add("+@q.q");
            add("q@q+q.q");
            add("q@q_q.q");
            add("q@q@q.q");
            add("q@@q.q");
        }};
        assertThat(validEmails, Every.everyItem(matchesPattern(emailPattern)));
        assertThat(invalidEmails, Every.everyItem(not(matchesPattern(emailPattern))));
    }
}
