/***
 * //Solution can be faster if i hardcode what the stack is doing into a seperate recursve method and return that. 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class sum_root_to_leaf_numbers {
    class Stack{
        private int[] stack;
        private int length;
        public Stack(int val){
            length = 1;
            stack = new int[1];
            stack[0] = val;
        }

        public Stack(){
            length = 0;
            stack = new int[0];
        }

        public int peek(){
            if(length == 0) return -1;
            return stack[0];
        }

        public int pop(){
            if(length == 0) return -1;
            int popped = stack[0];
            int[] newStack = new int[--length];
            for(int i = 0; i<length; i++) newStack[i] = stack[i+1];
            stack = Arrays.copyOf(newStack,length);
            return popped;
        }

        public void push(int val){
            stack = Arrays.copyOf(stack,++length);
            for(int i = 0; i<length-1; i++)stack[length-1-i] = stack[length-i-2];
            stack[0] = val;
        }

        public int s2i(){
            int sum=0;
            int i=0;
            for(int e : stack){
                //System.out.println(p);
                sum = (sum)+(int)(e*Math.pow(10,i++));
            }
            return sum;
        }
    }
    private Stack stack = new Stack();
    private int Total = 0;
    public int sumNumbers(TreeNode root) {
        stack.push(root.val);
        //System.out.println(stack.peek());
        if(root.left == null && root.right == null){
            //System.out.println("At end "+stack.s2i());
            Total += stack.s2i();
        }
        if(root.left != null){
            sumNumbers(root.left);
            //System.out.println(stack.s2i());
            stack.pop();
        }
        if(root.right != null){
            sumNumbers(root.right);
            //System.out.println(stack.s2i());
            stack.pop();
        }
        //sumNumbers(root.right);
        /*stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.s2i());*/
        return Total;
    }
}
