import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

abstract class TestBase {
    @BeforeAll
    static void setup() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }
}
