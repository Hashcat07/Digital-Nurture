public class SortingAlgorithms {
    public void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swappedSomething = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swappedSomething = true;
                }
            }
            if (!swappedSomething) {
                break;
            }
        }
    }

    public int partition(Order[] arr, int low, int high) {

        double pivot = arr[low].getTotalPrice();
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i].getTotalPrice() <= pivot) {
                i++;
            }
            while (j >= low + 1 && arr[j].getTotalPrice() > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public void swap(Order[] arr, int i, int j) {
        Order temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
}
