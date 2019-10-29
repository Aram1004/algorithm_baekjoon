package algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;


public class Main {
    // Key 값은 비교 가능해야하니 Comparable 를 상속한 클래스이어야 한다.
    public static class BinarySearchTree {

        public Node root ;  // 이진탐색트리의 루트 노드

        public class Node {
            public int key    ; // 노드의 키값이고 이거에 의해 정렬되어 질 것이다.
            public Node left  ; // 왼쪽 서브트리 노드,
            public Node right ; // 오른쪽 서브트리

            public Node(int key) {
                this.key = key;
            }
        }


        public void postorderTraversal(Node node, Consumer<Node> consumer) {
            if(node == null)
                return;

            // left -> right -> root
            postorderTraversal(node.left, consumer);
            postorderTraversal(node.right, consumer);
            if(consumer != null) consumer.accept(node);
        }


        public static BinarySearchTree newBSTFromPreOrder(int[] key) {
            BinarySearchTree bst = new BinarySearchTree();
            bst.root = bst.buildNodeFromPreorder(key, 0, key.length-1);
            return bst;
        }

        private Node buildNodeFromPreorder(int[] preorder, int start, int end) {
            // base case
            if (start > end) {
                return null;
            }

            Node node = new Node(preorder[start]);

            int i = start;
            while(i <= end) {
                if (preorder[i] > node.key) {
                    break;
                }
                i++;
            }

            node.left = buildNodeFromPreorder(preorder, start + 1, i - 1);
            node.right = buildNodeFromPreorder(preorder, i, end);

            return node;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        while(true) {
            String input = bf.readLine();
            if(input == null || input.isEmpty())
                break;
            list.add(Integer.parseInt(input));

        }

        int[] inputs = list.stream().mapToInt(i -> i.intValue()).toArray();

        BinarySearchTree bst = BinarySearchTree.newBSTFromPreOrder(inputs);
        bst.postorderTraversal(bst.root, (node) -> System.out.println(node.key));
    }

}