public void remove(E target) {
    root = remove(root, target);
    size--;
}
private Node<E> remove(Node<E> node, E target) {
    if (node.data.compareTo(target) == 0) {
        if(node.left == null) {
            return node.right;
        }
        else if(node.right == null) {
            return node.left;
        }
        else {
            Node<E> pred = node.left;
            while(pred.right != null) {
                pred = pred.right;
            }
            node.data = pred.data;
            node.left = remove(node.left, pred.data);
            return node;
        }
    }
    else if(node.data.compareTo(target) > 0) {
        node.left = remove(node.left, target);
    }
    else {
        node.right = remove(node.right, target);
    }
    return node;
}