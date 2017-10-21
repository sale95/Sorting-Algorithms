public class Algorithm {

    /**
     * This function searches for specific value by dividing array in half on every iteration.
     * @param array Array of type int that we search from.
     * @param key Value of type int that is being searched.
     * @return Returns index of specific value.
     */
    public int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            }
            //If value is less than mid, take left side of array.
            else if (key < array[mid]) {
                right = mid - 1;
            }
            //Take right side of array.
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * This function sorts the array. It finds min value and puts it in sorted subarray on the left side.
     * @param array Array that is being sorted.
     */
    public void selectionSort(int[] array) {
        for (int j = 0; j < array.length-1; j++) {
            int minIndex = j;
            //Find min.
            for (int i = j + 1; i < array.length; i++) {
                if (array[minIndex] > array[i]) {
                    minIndex = i;
                }
            }
            //Swap min with unsorted value.
            int temp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * This function sorts the array. It finds value to insert from unsortd subarray to sorted subarray.
     * @param array Array of type int that will be sorted.
     */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    /**
     * This function sorts the array by recursively dividing in half until it comes to one element then merging.
     * @param arr Array of type int that will be sorted.
     * @param left Integer that represents start of array.
     * @param right Integer that represents end of array.
     */
    void mergeSort(int arr[], int left, int right)
    {
        if (left < right)
        {
            int mid = (left+right)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr , mid+1, right);

            // Merge
            merge(arr, left, mid, right);
        }
    }

    private void merge(int arr[], int left, int mid, int right)
    {
        //sizes of temp arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        //temp arrays
        int leftArray[] = new int[leftSize];
        int rightArray[] = new int[rightSize];

        //Copy to temp arrays
        for (int i = 0; i < leftSize; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < rightSize; ++j)
            rightArray[j] = arr[mid + 1 + j];

        // Merge the temp arrays
        int i = 0;
        int j = 0;
        int index = left;
        while (i < leftSize && j < rightSize)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[index] = leftArray[i];
                i++;
            }
            else
            {
                arr[index] = rightArray[j];
                j++;
            }
            index++;
        }
		
		//Copy what is left.
        while (i < leftSize)
        {
            arr[index] = leftArray[i];
            i++;
            index++;
        }
    }

    /**
     * This function sorts array by recursively partitioning array around pivot value.
     * @param array Array of type int that will be sorted.
     * @param left Start of array.
     * @param right End of array.
     */
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        //Take middle value to be pivot.
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);

        //Partition and sort left half of the array.
        quickSort(array, left, index - 1);
        //Partition and sort right half of the array.
        quickSort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            //While value is less than pivot, move right.
            while (array[left] < pivot) {
                left++;
            }
            //While value is bigger than pivot, move left.
            while(array[right] > pivot) {
                right--;
            }

            //Swap smaller amd bigger value.
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        //Return middle point where values less than pivot are on the left side and bigger are on the right side.
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * This function sorts the array using heap data structure represented as array.
     * @param array Array of type int that will be sorted.
     */
    public void heapSort(int[] array) {
        int n = array.length;

        //Make heap.
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        //Extract root.
        for (int i = n-1; i >= 0; i--)
        {
            //Move root to end.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Heapify again.
            heapify(array, i, 0);
        }
    }

    //Making max heap.
    void heapify(int array[], int n, int i) {
        int largest = i;  // Initialize largest as root
        //Left child.
        int l = 2 * i + 1;
        //Right child.
        int r = 2 * i + 2;

        //If left child is larger than root.
        if (l < n && array[l] > array[largest])
            largest = l;

        // If right child is larger.
        if (r < n && array[r] > array[largest])
            largest = r;

        //If largest is not root.
        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            //Heapify subarray.
            heapify(array, n, largest);
        }
    }

    /**
     * This function prints array.
     * @param array Array of type int that will be printed.
     */
    public void print(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
