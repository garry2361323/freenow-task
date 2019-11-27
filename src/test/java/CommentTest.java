import api.User;
import models.Comment;
import models.Post;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.matchesRegex;
import static org.junit.jupiter.api.Assertions.assertAll;

class CommentTest extends TestBase {
    @ParameterizedTest
    @ValueSource(strings = {"Samantha"})
    void emailTest(String username) {
        final int maxEmailLength = 64;
        final Pattern emailRegex = Pattern.compile("^(?![._\\-+])[a-zA-Z0-9_.+-]*[a-zA-Z0-9]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]*[a-zA-Z0-9]+$");

        // get user id
        var id = User.getUserIdByUsername(username);

        // get posts array
        var posts = api.Post.getByUserId(id);

        var assertionsList = new ArrayList<Executable>();
        for (Post post : posts) {
            // get comments array
            var comments = api.Comment.getByPostId(post.getId());

            for (Comment comment : comments) {
                assertionsList.add(() -> assertThat("Comment #" + comment.getId(), comment.getEmail(), matchesRegex(emailRegex)));
                assertionsList.add(() -> assertThat("Comment #" + comment.getId(), comment.getEmail().length(), lessThan(maxEmailLength)));
            }
        }

        assertAll(assertionsList.stream());

        var b = 3;
    }
}
