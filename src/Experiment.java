public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSort(int[] arr, boolean basic) {
        int[] copy = arr.clone();
        long start = System.nanoTime();

        if (basic) sorter.basicSort(copy);
        else sorter.advancedSort(copy);

        return System.nanoTime() - start;
    }

    public long measureSearch(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    public void run() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            int[] random = sorter.generateRandomArray(size);
            int[] sorted = random.clone();
            sorter.advancedSort(sorted);

            long t1 = measureSort(random, true);
            long t2 = measureSort(random, false);
            long t3 = measureSearch(sorted, sorted[size / 2]);

            System.out.println("Size: " + size);
            System.out.println("Insertion: " + t1);
            System.out.println("Merge: " + t2);
            System.out.println("Binary Search: " + t3);
            System.out.println();
        }
    }
}