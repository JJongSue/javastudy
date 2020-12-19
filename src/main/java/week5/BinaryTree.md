# 과제 (Optional)

- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.



## 이진트리

* 각각의 노드가 최대 두 개의 자식 노드를 가지는 트리 자료 구조, 자식 노드를 각 각 왼쪽 자식 노드, 오른쪽 자식노드 라 함



![image](https://user-images.githubusercontent.com/34182908/102679869-69ef9000-41f6-11eb-94e5-cb303eb35374.png)

* 루트 노드 : 가장 최상위의 부모 노드(3)
* 자식 노드, 부모 노드 : 5가 부모인 경우, 1,4가 자식 노드
* 형제 노드 : 부모가 같은 두 노드
* 차수 : 자식의 수
* 깊이 : 루트노드에서 자신까지의 길이, 루트는 깊이 0, 레벨 깊이 + 1
* 높이 : 노드와 노드 사이의 경로의 최대 길이, 크기 : 자기자신및 자손 노드의 수
* 종류 : 한 쪽으로만 치우쳐진 편향 이진트리, 최대의 노드를 가진 포화 이진트리, 왼쪽 부터 차례대로 채워지는 완전 이진트리 등이 있다.
* Node를 통해 만들거나 배열을 통해 만드는 방법이 있다.

![image](https://user-images.githubusercontent.com/34182908/102679966-8d670a80-41f7-11eb-8f5b-2e475cc4963f.png)

```
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
```

```
Node n7 = new Node(7);
Node n5 = new Node(4);
Node n4 = new Node(1);

Node n2 = new Node(5, n4, n5);
Node n3 = new Node(6, null, n7);

Node n1 = new Node(3, n2, n3);
```



## BFS(넓이 우선 탐색)

* 하나의 노드로 부터 시작하여 차례대로 모든 노드를 한 번씩 방문하는 것
* 큐를 이용하여 주로 구현한다



![image](https://user-images.githubusercontent.com/34182908/102679869-69ef9000-41f6-11eb-94e5-cb303eb35374.png)

* 예를 들어 1번부터 시작하면, 1번 노드 값인 3부터 출력하며, 2, 3,4,5,6,7 이런씩으로 하나씩 방문하여 3 5 6 1 4 7이 출력되는 것
* 2번값으로 시작할 경우 5 1 4가 출력

```
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
```

* 자료구조인 큐를 이용하여 가장 상위 노드를 방문하고 각 각의 왼쪽, 오른쪽 자식노드를 큐에 넣고 방문하게 구현

```
System.out.print("BFS : ");
bt.bfs(n1);

System.out.print("DFS : ");
bt.dfs(n1);
System.out.print("3시작 bfs :");
bt.bfs(n3);
```

```
BFS : 3 5 6 1 4 7 DFS : 1 4 5 7 6 3 3시작 bfs :6 7 
```



## DFS(깊이우선 탐색)



```

```

