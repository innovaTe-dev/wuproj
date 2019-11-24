private void quickSort(E[] data, int start, int end) {
    if (start <= end) return;
    int pivot = split(data, start, end);
    quickSort(data, start, pivot - 1);
    quickSort(data, pivot + 1, end);
}