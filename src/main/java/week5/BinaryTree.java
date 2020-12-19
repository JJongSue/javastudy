package week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node tmp = q.poll();
            System.out.print(tmp.value + " ");
            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null) q.add(tmp.right);
        }
    }

    void dfs(Node node){
        if(node.left != null) dfs(node.left);
        if(node.right != null) dfs(node.right);
        System.out.print(node.value + " ");
    }


}
