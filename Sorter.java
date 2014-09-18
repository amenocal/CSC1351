import java.util.Random;
import java.util.HashMap;

public abstract class Sorter {
    public final static Random RAND = new Random();
    
    public static int[] create(int size) {
        int[] array = new int[size];
        for(int i=0;i<array.length;i++) {
            array[i] = 1+RAND.nextInt(1000);
        }
        return array;
    }

    public static int[] dup(int[] array) {
        int[] d = new int[array.length];
        for(int i=0;i<d.length;i++)
            d[i] = array[i];
        return d;
    }

    public static boolean comp(int[] array1,int[] array2) {
        if(array1.length != array2.length)
            return false;
        for(int i=0;i<array1.length;i++) {
            if(array1[i] != array2[i])
                return false;
        }
        return true;
    }

    public final void check(int[] array) {
        for(int i=1;i<array.length;i++)
            if(array[i-1] > array[i]) {
                print(array);
                throw new Error();
            }
    }

    public final void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public final void print(int[] array) {
        print(array,0,array.length);
    }

    public final void print(int[] array,int start,int end) {
        System.out.print("array:");
        for(int i=start;i<end;i++) {
            System.out.print(' ');
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public abstract void sort(int[] array);

    public static void usage() {
            System.err.println("usage: Sorter class size tries");
            System.err.println("usage: Sorter class1 class2 size");
    }
    public static void main(String[] args) {
        if(args.length < 3)
            usage();
        try {
            Sorter sorter = (Sorter)Class.forName(args[0]).newInstance();
            int size = Integer.parseInt(args[1]);
            int ntries = Integer.parseInt(args[2]);
            timing(sorter,size,ntries);
            System.exit(0);
        } catch(NumberFormatException nex) {
            ;
        } catch(Exception ex) {
            ex.printStackTrace();
            usage();
            System.exit(2);
        }
        try {
            Sorter sorter1 = (Sorter)Class.forName(args[0]).newInstance();
            Sorter sorter2 = (Sorter)Class.forName(args[1]).newInstance();
            int size = Integer.parseInt(args[2]);
            compare(sorter1,sorter2,size);
        } catch(Exception ex) {
            ex.printStackTrace();
            usage();
            System.exit(3);
        }
    }

    public static void compare(Sorter s1,Sorter s2,int size) {
        int[] a1 = create(size);
        int[] a2 = dup(a1);
        s1.sort(a1);
        s2.sort(a2);
        if(comp(a1,a2))
            System.out.println("The same");
        else
            System.out.println("Different");
    }

    public static void timing(Sorter sorter,int size,int ntries) {
        double sum = 0, sum2 = 0;
        for(int ntry=0;ntry<ntries;ntry++) {
            int[] array = create(size);
            long tstart = System.currentTimeMillis();
            sorter.sort(array);
            long   tend = System.currentTimeMillis();
            sorter.check(array);
            double secs = 0.001*(tend-tstart);
            sum += secs;
            sum2 += secs*secs;
        }
        double avg = sum/ntries;
        double stdv = Math.sqrt((sum2/ntries-avg*avg)*(ntries/(ntries-1)));
        System.out.println();
        System.out.printf("time = %5.3f +/- %5.3f\n",avg,stdv);
    }
}
