import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Text Editor - Type anything you want!");
        System.out.println("Undo - /z");
        System.out.println("Redo - /r");
        System.out.println("Exit - /exit");

        while (!Objects.equals(text, "/exit")) {
            text = scanner.nextLine();

            if (Objects.equals(text, "/z")) {
                String previousText = textEditor.undo();
                if (previousText != null) {
                    System.out.printf("Undo to: %s%n", previousText);
                }
            }
            else if (Objects.equals(text, "/r")) {
                String nextText = textEditor.redo();
                if (nextText != null) {
                    System.out.printf("Redo to: %s%n", nextText);
                }
            }
            else if (Objects.equals(text, "/exit")) {
                // Nothing but exits out
            }
            else {
                textEditor.add(text);
                System.out.print("Added: ");
                textEditor.printCurrent();
            }
        }
    }
}
