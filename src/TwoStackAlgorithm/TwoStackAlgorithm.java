package TwoStackAlgorithm;


import java.util.Scanner;

/**
 * Dijkstra Two-Stack Algorithm
 * [https://en.wikipedia.org/wiki/Edsger_W._Dijkstra]
 * <p>
 * Short description:
 * 1. the algorithm takes a mathematical expression with properly balanced parentheses as input
 * 2. reads expression character by character
 * 3. if it is a number, push on top of the values stack
 * 4. if it is an operator [*+-/%], push on top of the operators stack
 * 5. if it is a left parenthesis "(", ignore it and move on to the next character
 * 6. if it is a right parenthesis ")":
 * a) pop an operator and two values from their respective stacks
 * b) evaluate the corresponding operation
 * c) push the result on top of the values stack
 * <p>
 * <p>
 * For example we can input "( ( 4 * 1 ) + ( ( 1 + 2 ) * 3 ) )" and it should evaluate it correctly
 * Using white space between each character is optional, so it should work without it as well
 */

public class TwoStackAlgorithm {

    public static void main(String[] args) throws Exception {

        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter an expression: ");

        String expression = reader.nextLine();

        System.out.println("\nThis expression evaluates to:");

        System.out.println(evaluate(expression));


    }

    /**
     * Returns the result of the expression that is passed as a parameter in the form of a String
     *
     * @param expression the expression to be evaluated
     * @return the final result of the expression
     */

    public static int evaluate(String expression) throws Exception {
        /*
         * Initialize the two stacks that we need to use in the algorithm
         */
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        /*
         * The string operations contains the symbols of arithmetic operations that the algorithm supports
         * It is mainly used to check whether the character represents an arithmetic operation
         */
        String operations = "+-–*/%";

        /*
         * Iterate through every character of the expression using a for loop
         */

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                /*
                 * If the character is a digit
                 * Initialize new String variable called value
                 * It will be used to store the numeric value of the number and later converted back to an Integer
                 * The reason we are using a String is because of the possibility of the number being a multiple-digit
                 * number. In case of a multiple-digit number, String data type makes it easy to concatenate digits.
                 * The string value is initially set to the first digit
                 */
                String value = "";
                value += expression.charAt(i);

                /*
                 * Initialize a new variable j which will be used for the while loop
                 * Set j initially to i+1 because the while loop will be checking characters after the character at i
                 * This loop is used to check if the number has multiple digits
                 * If it detects that it does have multiple digits it will append those digits to the variable value
                 */
                int j = i + 1;
                while (j < expression.length()) {
                    if (Character.isDigit(expression.charAt(j))) {
                        value += expression.charAt(j);
                    } else {
                        break;
                    }
                    j++;
                }

                /*
                 * Push the number on the values stack
                 */
                values.push(Integer.parseInt(value));

                /*
                 * Set the value of i back to j-1 so that it doesn't iterate over the same characters again
                 */
                i = j - 1;
            } else if (operations.indexOf(expression.charAt(i)) >= 0) {
                /*
                 * If the character at the position i is any of the arithmetic symbols contained in the String
                 * variable called operations, add that character to the operators stack
                 */
                operators.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                /*
                 * If the character is a right parenthesis, pop two values and an operator from their respective stacks
                 * and perform the corresponding arithmetic operation on those two values
                 * After that, push the resultant value on top of the values stack
                 */

                if (!operators.isEmpty()) {
                    int result = 0;
                    int value1 = values.pop();
                    int value2 = values.pop();
                    char operation = operators.pop();
                    switch (operation) {
                        case '+':
                            result = value1 + value2;
                            break;
                        case '-':
                            result = value2 - value1;
                            break;
                        case '*':
                            result = value1 * value2;
                            break;
                        case '/':
                            result = value2 / value1;
                            break;
                        case '%':
                            result = value2 % value1;
                            break;
                        case '–':
                            result = value2 - value1;
                            break;
                        default:
                            break;
                    }
                    values.push(result);
                }

            }
        }

        return values.pop();
    }

}
