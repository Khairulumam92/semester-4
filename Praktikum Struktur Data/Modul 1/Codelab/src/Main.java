// Generic Container class
class Container<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class Main {
    public static void main(String[] args) {
        Container<Integer> numberContainer = new Container<>();
        numberContainer.setContent(23);
        Integer number = numberContainer.getContent();
        System.out.println("Integer value: " + number);

        Container<String> textContainer = new Container<>();
        textContainer.setContent("Hello Semester 4!");
        String message = textContainer.getContent();
        System.out.println("String value: " + message);
    }
}