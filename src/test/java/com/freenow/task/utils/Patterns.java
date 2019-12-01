package com.freenow.task.utils;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

public class Patterns {
    // todo handle duplicate symbols
    private static final String emailPattern =
            "^(?![._\\-+])[a-zA-Z0-9_.+-]*[a-zA-Z0-9]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]*[a-zA-Z0-9]+$";

    public static Pattern getEmailPattern() {
        return Pattern.compile(emailPattern);
    }

    @Tag("unit")
    @ParameterizedTest
    @ValueSource(strings = {"q@q.q", "Q.q_w-w+1@foo1-bar2.foo.bar"})
    void validEmailTest(String email) {
        assertThat(email, matchesPattern(emailPattern));
    }

    @Tag("unit")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "",
            "@.",
            "q@.q",
            "@q.q",
            "q@",
            "q@q.",
            ".@q.q",
            "_@q.q",
            "-@q.q",
            "+@q.q",
            "q@q+q.q",
            "q@q_q.q",
            "q@q@q.q",
            "q@@q.q",
    })
    void invalidEmailTest(String email) {
        assertThat(email, not(matchesPattern(emailPattern)));
    }
}
