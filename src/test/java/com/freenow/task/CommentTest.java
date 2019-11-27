package com.freenow.task;

import com.freenow.task.api.PostApi;
import com.freenow.task.api.UserApi;
import com.freenow.task.models.Comment;
import com.freenow.task.models.Post;
import com.freenow.task.utils.Patterns;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.junit.jupiter.api.Assertions.assertAll;

class CommentTest extends TestBase {
    private final UserApi userApi = new UserApi();
    private final PostApi postApi = new PostApi();

    @ParameterizedTest
    @ValueSource(strings = {"Samantha"})
    void emailTest(String username) {
        final Pattern emailRegex = Patterns.getEmailPattern();
        final int maxEmailLength = 64;

        // get user id
        int id = userApi.getIdByUsername(username);

        // get posts list
        List<Post> posts = postApi.getByUserId(id);

        List<Executable> assertionsList = new ArrayList<>();
        for (Post post : posts) {
            // get comments list
            List<Comment> comments = postApi.getCommentByPostId(post.getId());

            for (Comment comment : comments) {
                String reason = "Comment #" + comment.getId();
                assertionsList.add(() -> assertThat(reason, comment.getEmail(), matchesRegex(emailRegex)));
                assertionsList.add(() -> assertThat(reason, comment.getEmail().length(), lessThanOrEqualTo(maxEmailLength)));
            }
        }

        assertAll(assertionsList);
    }
}
