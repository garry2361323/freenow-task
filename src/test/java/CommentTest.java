import api.User;
import models.Comment;
import models.Post;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.junit.jupiter.api.Assertions.assertAll;

class CommentTest extends TestBase {
    @ParameterizedTest
    @ValueSource(strings = {"Samantha"})
    void emailTest(String username) {
        final Pattern emailRegex = utils.Patterns.getEmailPattern();
        final int maxEmailLength = 64;

        // get user id
        var id = User.getIdByUsername(username);

        // get posts array
        var posts = api.Post.getByUserId(id);

        var assertionsList = new ArrayList<Executable>();
        for (Post post : posts) {
            // get comments array
            var comments = api.Comment.getByPostId(post.getId());

            for (Comment comment : comments) {
                String reason = "Comment #" + comment.getId();
                assertionsList.add(() -> assertThat(reason, comment.getEmail(), matchesRegex(emailRegex)));
                assertionsList.add(() -> assertThat(reason, comment.getEmail().length(), lessThanOrEqualTo(maxEmailLength)));
            }
        }

        assertAll(assertionsList.stream());
    }
}
