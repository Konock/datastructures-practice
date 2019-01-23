public class TestObject {
    String description;

    TestObject(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
