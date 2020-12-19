package week5;

public class BinaryTreeMain {
    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n5 = new Node(4);
        Node n4 = new Node(1);

        Node n2 = new Node(5, n4, n5);
        Node n3 = new Node(6, null, n7);

        Node n1 = new Node(3, n2, n3);

        BinaryTree bt = new BinaryTree();

        System.out.print("BFS : ");
        bt.bfs(n1);

        System.out.print("DFS : ");
        bt.dfs(n1);
        System.out.print("3시작 bfs :");
        bt.bfs(n3);




    }
}
