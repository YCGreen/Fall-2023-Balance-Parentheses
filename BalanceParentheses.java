import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.FileReader;

public class BalanceParentheses {
    /**
     * isWff: verifies whether statement in given file is well-formed
     * @param filePath: filepath to read text from
     * @return boolean: if text is balanced
     */
    public static boolean isWff(String filePath) {
        boolean isWff = true;
        Stack<Character> stack = new Stack<>();
        String textStr = "";

        try (FileReader fr = new FileReader(filePath)) {
            textStr = Files.readString(Path.of(filePath));
        }
        catch (Exception e){
            e.getMessage();
        }

        char[] text = textStr.toCharArray();

        for(int i = 0; i < text.length; i++) {
            if(text[i] == '"') {
                i++;
                while(i < text.length && text[i] != '"') {
                    i++;
                }
            }

            else if(!isValidChar(text[i], stack)) {
                isWff = false;
                break;
            }
        }

        if(!stack.isEmpty()) {

        }

        return isWff;
    }

    /**
     *
     * @param ch: char to pop on stack if open parentheses
     * @return: boolean: if char is a closing parentheses and is not matched in stack
     */
    private static boolean isValidChar(char ch, Stack<Character> stack) {
        boolean retVal = false;
        switch(ch) {
            case '(':
                stack.push(ch);
                retVal = true;
                break;
            case '{':
                stack.push(ch);
                retVal = true;
                break;
            case '[':
                stack.push(ch);
                retVal = true;
                break;
            case ')':
                if (stack.peek() != '(') {
                    break;
                }
                stack.pop();
                break;
            case '}':
                if(stack.peek() != '{') {
                    break;
                }
                stack.pop();
                break;
            case ']':
                if(stack.peek() != '[') {
                    break;
                }
                stack.pop();
                break;
        }

        return retVal;
    }

}
