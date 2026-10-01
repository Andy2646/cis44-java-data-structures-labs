public class SyntaxChecker {
    public static boolean isBalanced(String line) {
        Stack<Character> buffer = new ArrayStack<>(line.length()); // Create empty stack

        // Loop every character in our inputted line
        for (int i = 0; i < line.length(); i++) {
            Character c = line.charAt(i); // Get character at index

            if (c.equals('(') || c.equals('{') || c.equals('[')) { // OPENING SYMBOLS
                buffer.push(c); // add it to stack
            }

            if (c.equals(')') || c.equals('}') || c.equals(']')) { // CLOSING SYMBOLS
                if (buffer.isEmpty()) {return false;} // Check if the stack is empty

                Character popped = buffer.pop(); // Remove the opening symbol from the stack and check if the element matches the closing symbol.

                if (popped.equals('(') && !c.equals(')')) {
                    return false;
                }
                else if (popped.equals('{') && !c.equals('}')) {
                    return false;
                }
                else if (popped.equals('[') && !c.equals(']')) {
                    return false;
                }
            }
        }

        if (buffer.isEmpty()) { // Check if stack is empty to see if its balanced
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
