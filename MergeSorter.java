public class MergeSorter extends Sorter {
    public void sort(int[] array) {
        sort(array,0,array.length);
    }
    public void sort(int[] array,int start,int end) {
        if(end-start < 2)
            return;
        int mid = (end+start)/2;
        sort(array,start,mid);
        sort(array,mid,end);
        int[] first = new int[mid-start];
        int[] second = new int[end-mid];
        for(int i=0;i<first.length;i++) {
            first[i] = array[i+start];
        }
        for(int i=0;i<second.length;i++) {
            second[i] = array[i+mid];
        }
        int i1 = 0, i2 = 0, i = start;
        while(true) {
            if(i1 < first.length && i2 < second.length) {
                if(first[i1] <= second[i2]) {
                    array[i] = first[i1];
                    i1++;
                    i++;
                } else {
                    array[i] = second[i2];
                    i2++;
                    i++;
                }
            } else if(i1 < first.length) {
                array[i] = first[i1];
                i1++;
                i++;
            } else if(i2 < second.length) {
                array[i] = second[i2];
                i2++;
                i++;
            } else {
                break;
            }
        }
    }
}
