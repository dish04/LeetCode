class vlaid_parantheses {
    public boolean isValid(String string) {
        char[] s = string.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s){
            if( c == '[' || c == '{' || c=='(') stack.push(c);
            //System.out.print(stack);
            if(c == ']' || c == '}' || c==')'){
                if(stack.isEmpty()) return false;
                char t = stack.pop();
                //System.out.println();
                //System.out.println(t);
                switch(c){
                    case ']':
                        if (t!='[') 
                            return false;
                        break;
                    case '}':
                        if (t!='{') 
                            return false;
                        break;
                    case ')':
                        if (t!='(') 
                            return false;
                        break;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
