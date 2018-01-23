
public class Homework1 {
    
    public static String input = "251-*32*+";
    public int inputl = input.length();
    
    public void main(String[] args) {
        input = args[0];
        mbt(root);
        infix(root);
        System.out.print("="+calculate(root));
    }
    
    public static class Node {
        Node left;
        Node right;
        char key;
        public Node(char data) {
            this.key = data;
        }
    }
    
    public static boolean isoperator(Node n){
        if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/'){
            return true;
        }else return false;
    }
    
    public static boolean isnottrue(Node n){
        if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/'||n.key=='0'||n.key=='1'||n.key=='2'||n.key=='3'||n.key=='4'||n.key=='5'||n.key=='6'||n.key=='7'||n.key=='8'||n.key=='9'){
            return true;
        }else return false;
    }
    static Node root;
    
    public void mbt(Node n){
        if(root==null){
            root = n;
            inputl--;
        }
        if(isoperator(n)){
            n.right = new Node(input.charAt(inputl));
            inputl--;
            mbt(n.right);
            n.left = new Node(input.charAt(inputl));
            inputl--;
            mbt(n.left);
        }else if(!isnottrue(n)){
            System.out.print("error");
        }
    }
    
    public static Node findleftmost(Node n){
        Node nownode = n;
        if(n.left==null){
            return n;
        }else{
            return findleftmost(nownode);
        }
    }
    
    public static void infix(Node n){
        if (n == root) {
            infix(n.left);
            System.out.print(n.key);
            infix(n.right);
        }else if(isoperator(n)){
            System.out.print("(");
            infix(n.left);
            System.out.print(")");
            infix(n.right);
        }else if(!isnottrue(n)){
            System.out.print(n.key);
        }else{
            System.out.print("error");
        }
    }
    
    public static void inorder(Node n){
        if(isoperator(n)){
            inorder(n.left);
            System.out.print(n.key);
            inorder(n.right);
        }else if(!isnottrue(n)){
            System.out.print(n.key);
        }else{
            System.out.print("error");
        }
    }
    
    public static int calculate(Node n){
        infix(n);
        if(isoperator(n)){
            if(n.key=='+'){
                return calculate(n.left)+calculate(n.right);
            }else if(n.key=='-'){
                return calculate(n.left)-calculate(n.right);
            }else if(n.key=='*'){
                return calculate(n.left)*calculate(n.right);
            }else if(n.key=='/'){
                return calculate(n.left)/calculate(n.right);
            }    
        }else if(!isnottrue(n)){
            return Character.getNumericValue(n.key);
        }
        return 0;
    }
}    