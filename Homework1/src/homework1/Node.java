/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author Dell
 */
public class Node {
        Node left;
        Node right;
        char key;
        public Node(char data) {
            this.key = data;
        }
        public String toString() {
        return Character.toString(key);
    }
}
