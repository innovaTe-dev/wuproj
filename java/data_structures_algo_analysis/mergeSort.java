private void mergeSort(int[] data, int start, int end) {
    if(start <= end) return;
    int mid = (start + end) / 2;
    mergeSort(data, start, mid);
    mergeSort(data, mid + 1, end);
    merge(data, start, mid, end);
}