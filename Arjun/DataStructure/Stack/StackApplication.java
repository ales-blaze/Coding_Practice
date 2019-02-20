import org.hamcrest.internal.ArrayIterator;

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

public class StackApplication {
    public boolean bracketMatch(String input){
        if(input == "") return false;
        char[] charArray = input.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        for(int index = 0 ; index < charArray.length ;index++){
            switch(charArray[index]){
                case '(':
                case '{':
                case '[':
                    charStack.push(charArray[index]);
                    break;
                case ')' :
                    if(charStack.peek().equals('('))
                        charStack.pop();
                    break;
                case '}':
                    if(charStack.peek().equals('{'))
                        charStack.pop();
                    break;
                case ']':
                    if(charStack.peek().equals('['))
                        charStack.pop();
                    break;
                default:
                    return false;
            }
        }
        if(!charStack.empty()) return false;
        return true;
    }

    public String infixToPostfix(String input){
        if(input == "") return null;
        Stack<Character> expressionStack = new Stack<Character>();
        StringBuilder sBuilder = new StringBuilder(10);
        for(int index = 0 ; index < input.length() ; index++){
            char c = input.charAt(index);
            if(c == '('){
                expressionStack.push(c);
            }
            else if(c == ')'){
                while(expressionStack.peek() != '(' && !expressionStack.isEmpty()){
                    sBuilder.append(expressionStack.pop());
                }
                if(expressionStack.peek() != '('){
                    System.err.print("Invalid Expression");
                    System.exit(-1);
                }
                else
                    expressionStack.pop();
            }
            else if(isOperator(c)){
                if ( expressionStack.isEmpty() || expressionPrecedence( expressionStack.peek()) < expressionPrecedence(c)){
                    expressionStack.push(c);
                }
                else{
                    // we will pop operators from the stack until the precedence of the operator in the stack is less than the precedence of the operator to  push on the stack
                    while(!expressionStack.isEmpty()){
                        if (expressionPrecedence(c) <= expressionPrecedence(expressionStack.peek())){
                            sBuilder.append(expressionStack.pop());
                        }
                        else break;
                    }
                    expressionStack.push(c);
                }
            }
            else{
                sBuilder.append(c);
            }
        }
        //after scannin checkin
        if(!expressionStack.empty()){
            while(!expressionStack.empty()){
                sBuilder.append(expressionStack.pop());
            }
        }
        return sBuilder.toString();
    }

    private boolean isOperator(char operator){
        switch (operator){
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
                default: return false;
        }
    }
    private int expressionPrecedence(char operator){
        switch (operator){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
            case '%':
                return 2;
            case '^':
                return 3;
                default:
                    return -1;
        }
    }

    public String infixToPrefix(String input) {
        Stack<Character> stack = new Stack<>();
        String intermediate = null;
        Character c = null;

        for(int index = 0 ; index < input.length() ; index++) {
            stack.push(input.charAt(index));
        }
        StringBuilder stringBuilder = new StringBuilder(4);
        while(!stack.isEmpty()){
             c = stack.pop();
             if(c == '('){
                 stringBuilder.append(')');
                 continue;
             }
             else if(c == ')'){
                 stringBuilder.append('(');
                 continue;
             }
             else{
                 stringBuilder.append(c);
             }
        }
        stack = null;

        intermediate = this.infixToPostfix(stringBuilder.toString());
        stringBuilder = new StringBuilder(intermediate);

        return stringBuilder.reverse().toString();
//        String output = null;
//        for(int index = intermediate.length() -1  ; index >= 0; index++){
//            output += intermediate.charAt(index);
//        }
//        return output;
    }
    public String PrefixToPostfix(String input){
        StringBuilder stringBuilder = new StringBuilder(5);
        stringBuilder.append(input);
        return stringBuilder.reverse().toString();
    }

    public  String prefixToInfix(String input){
        Stack<String> stack = new Stack<>();
        //read expression from the backward
        //while readin' poppin an pushin
        Character character = null;
        for(int index = input.length() - 1 ; index >= 0 ; index--){
             character = input.charAt(index);
             try {
                 if (isOperator(character)) {
                     String firstOperand = stack.pop();
                     String secondOperand = stack.pop();
                     String tempExpression = firstOperand + character + secondOperand;

                     stack.push(tempExpression);
                 } else {
                     stack.push(character.toString());
                 }
             }catch (EmptyStackException ese){
                 System.err.print("Invalid Expression");
                 break;
             }
        }
        return stack.pop();
    }

    //PostFix to infix left
}