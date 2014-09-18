public class QuickSorter extends Sorter {
    public void sort(int[] array) {
        sort(array,0,array.length);
    }
    public void sort(int[] array,int start,int end) {
        int n = end - start;
        if(n < 2)
            return;
        int pivot = RAND.nextInt(n)+start;
        int[] next = new int[n];
        int i1 = 0, i2 = n;
        int p = array[pivot];
        for(int i=start;i<end;i++) {
            if(i == pivot)
                continue;
            int v = array[i];
            if(v <= p) {
                next[i1] = v;
                i1++;
            } else {
                i2--;
                next[i2] = v;
            }
        }
        sort(next,0,i1);
        sort(next,i2,n);
        next[i1] = p;
        i1++;
        n = start;
        for(int i=0;i<next.length;i++) {
            array[n] = next[i];
            n++;
        }
    }
}
