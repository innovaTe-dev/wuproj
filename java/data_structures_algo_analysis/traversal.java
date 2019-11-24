public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(root, sb);
    return sb.toString();
}
private void toString(Node<E> node, StringBuilder sb) {
    if(node == null) return;
    toString(node.left, sb);
    sb.append(node.data);
    toString(node.right, sb);
}