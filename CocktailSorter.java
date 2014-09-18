public class CocktailSorter extends Sorter {
    public void sort(int[] array) {
        boolean done = false;
        while(!done)  {
            done = true;
            for(int i=1;i<array.length;i++) {
                if(array[i-1] > array[i]) {
                    swap(array,i-1,i);
                    done = false;
                }
            }
            if(done)
                break;
            for(int i=array.length-1;i>=1;i--) {
                if(array[i-1] > array[i]) {
                    swap(array,i-1,i);
                    done = false;
                }
            }
        }
    }
}

