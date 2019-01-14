package DataStructure.Stack;

import java.util.Stack;

public class ExpressionEvaluation {
    static String postFix;
        //public static char[] operatorSet = {'+','-','*','/','%','^'};
        private int operatorPrecedence(char operator){
            switch(operator){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                case '%':
                    return 2;
                case '^':
                    return 3;
                default:
                    return -1;
            }
        }

        public String infixToPostfix(String expression){
            Stack<Character> stack = new Stack<Character>();
            StringBuilder stringBuilder = new StringBuilder(20);
            //trim the expression
            char[] expressionArray = expression.toCharArray();
            //scan it
            for(int counter = 0; counter < expressionArray.length;counter++){

                if((expressionArray[counter] >= 'a' && expressionArray[counter] <= 'z' ) || (expressionArray[counter] >= 'A' && expressionArray[counter] <='Z')){
                    stringBuilder.append(expressionArray[counter]);
                }

               else if(expressionArray[counter] == '(') {
                    stack.push('(');
                }

                else if(expressionArray[counter] == ')') {
                    while (stack.peek() != '(') {
                        if (stack.isEmpty()) {
                            System.err.println("Not a Valid expression!");
                        }
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                }
                else{
                    //((Character)stack.peek()) == '('
                    if((  stack.isEmpty() || operatorPrecedence(expressionArray[counter]) > operatorPrecedence(stack.peek()))){
                        stack.push(expressionArray[counter]);
                    }
                    else {
                        while(operatorPrecedence(expressionArray[counter]) <= operatorPrecedence(stack.peek())) {
                            if(stack.peek() == '('){
                                break;
                            }
                            stringBuilder.append(stack.pop());
                            if(stack.isEmpty()){
                                break;
                            }
                        }
                        stack.push(expressionArray[counter]);
                        }
                    }
                }
                while(!(stack.isEmpty())){
                    stringBuilder.append(stack.pop());
            }
            return stringBuilder.toString();
        }

        public void posfixEvaluation(String postfixExpression){
            Stack<Integer> stack = new Stack<>();
            char[] postfixExpressionArray = postfixExpression.toCharArray();

            for(int index = 0 ; index < postfixExpressionArray.length ;index++){

                if((postfixExpressionArray[index] >= '1' && postfixExpressionArray[index] <= '9')) {//|| (postfixExpressionArray[index] >= 'A' && postfixExpressionArray[index] <= 'Z') ){
                    stack.push(postfixExpressionArray[index] - '0');
                }
                else{
                    if(stack.peek() == null) return;

                    int number2 = stack.pop();
                    int number1 = stack.pop();
                    int result = 0;

                    switch(postfixExpressionArray[index]){
                        case '+':
                            result = number1 + number2;
                            break;
                        case '-':
                            result = number1 - number2;
                            break;
                        case '*':
                            result = number1 * number2;
                            break;
                        case '/':
                            result = number2 != 0 ? number1 / number2 : 0;
                            break;
                        case '%':
                            result = number2 != 0 ? number1 % number2 : 0;
                            break;
                        case '^':
                            result = number1;
                            for(int temporary = 1 ; temporary <= number2 ; temporary++ ){
                                result *= number1;
                            }
                            break;
                            default:
                                System.out.println("Operator Not Avaliable!");
                    }
                    stack.push(result);
                }
            }
            System.out.println("Result of the expression is: "+stack.pop());
        }

    public static void main(String[] args) {
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        String expression = "231*+9-";
        String expression1 ="232*^2+";
        expressionEvaluation.posfixEvaluation(expression1);
//        String string = "a+b*c*(d+e*j)";
//        String result = expressionEvaluation.infixToPostfix(string);
//        System.out.println(expressionEvaluation.infixToPostfix(string));
    }
        }
