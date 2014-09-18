public class SelectionSorter extends Sorter {
    public void sort(int[] array) {
        for(int i=0;i+1<array.length;i++) {
            int imin = i;
            for(int j=i+1;j<array.length;j++) {
                if(array[j] < array[imin]) {
                    imin = j;
                }
            }
            swap(array,imin,i);
        }
    }
}
