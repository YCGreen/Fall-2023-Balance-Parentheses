
/**
 * @author Yael Green MCON264
 */
public class Main {
    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("Please enter valid text file.");
            System.exit(1);
        }

       if(BalanceParentheses.isWff(args[0])) {
           System.out.println("Input is well-formed");
       }
       else {
           System.out.println("Input is badly formed");
       }


    }
}