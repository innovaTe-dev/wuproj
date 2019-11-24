public class MyBST<E extends Comparable<E>> {
    private Node<E> root = null;
    private class Node<E> {
        private E data = null;
        private Node<E> left = null;
        private Node<E> right = null;
    }
    public void add(E data) {
        root = add(root, data);
    }
    private Node<E> add(Node<E> node, E data) {
        if(node == null) {
            Node<E> newNode = new Node<E>();
            newNode.data = data;
            return newNode;
        }
        if(node.data.compareTo(data) > 0) {
            node.left = add(node.left, data);
        }
        else {
            node.right = add(node.right, data);
        }
        return node;
    }
    
}