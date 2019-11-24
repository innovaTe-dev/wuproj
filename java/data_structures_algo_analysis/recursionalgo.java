public int countNodes() {
    return countNodes(root);
}
private int countNodes(Node<E> node) {
    if(node == null) return 0;
    return countNodes(node.left) + countNodes(node.right) + 1;
}