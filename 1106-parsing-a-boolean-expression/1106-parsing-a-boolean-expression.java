class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==')'){
                boolean hasTrue = false, hasFalse = false;
                while(st.peek()!='('){
                    char temp = st.pop();
                    if(temp=='t'){
                        hasTrue = true;
                    }else if(temp=='f'){
                        hasFalse = true;
                    }
                }
                st.pop(); // popping out '('
                char op = st.pop(); // op -> operation
                st.push(evaluate(hasTrue,hasFalse,op)); // pushing the result of evaluation of a subExpression
            }else{
                st.push(ch);
            }
        }
        return st.pop() == 't';
    }

    private char evaluate(boolean hasTrue,boolean hasFalse,char op){
        boolean result;
        if(op == '|'){
            result = hasTrue;
        }else if(op == '&'){
            result = !hasFalse;
        }else{
            result = !hasTrue;
        }
        return result? 't': 'f';
    }
}