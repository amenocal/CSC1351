import java.util.*;

/**
 * Testing harness for implementing linked lists.
 * Keeps an ArrayList with the same values and ensures
 * that the tested class works the same.
 **/
public class TestDoub {
    public final static boolean VERBOSE = false;
    DoubList di;
    ArrayList<Integer> ai;

    /** Instantiate with a class name */
    public TestDoub(String cname) throws Exception {
        di = (DoubList)Class.forName(cname).newInstance();
        ai = new ArrayList<Integer>();
    }

    /** Test that list and the shadow array list are the same
     *  when doing forward iteration.
     **/
    public void testForward() {
        int n = 0;
        IntIterator i = di.forward();
        while(i.hasNext()) {
            int v = i.next();
            assert(v == ai.get(n));
            n++;
        }
        assert(n == ai.size());
    }

    /** Test that list and the shadow array list are the same
     *  when doing backward iteration.
     **/
    public void testBackward() {
        int n = ai.size()-1;
        IntIterator i = di.backward();
        while(i.hasNext()) {
            int v = i.next();
            assert(v == ai.get(n));
            n--;
        }
        assert(n < 0);
    }

    public void test() {
        testForward();
        testBackward();
    }

    /** push back on both lists and test. */
    void pushBack(int n) {
        if(VERBOSE)System.out.println("pushBack("+n+")");
        ai.add(n);
        di.pushBack(n);
        test();
    }

    /** push front on both lists and test. */
    void pushFront(int n) {
        if(VERBOSE)System.out.println("pushFront("+n+")");
        ai.add(0,n);
        di.pushFront(n);
        test();
    }
    void popFront() {
        if(VERBOSE)System.out.println("popFront");
        int v = di.popFront();
        assert(v == ai.get(0));
        ai.remove(0);
        test();
    }
    void popBack() {
        if(VERBOSE)System.out.println("popBack");
        int v = di.popBack();
        assert(v == ai.get(ai.size()-1));
        ai.remove(ai.size()-1);
        test();
    }
    /**
     * Usage: java TestDoub DoubClass [seed].
     * If the seed is supplied, then use it, otherwise
     * select a random one. The test randomly adds and
     * removes elements from the list, and tests that
     * forward and backward iteration works properly.
     **/
    public static void main(String[] args) throws Exception {
        try {
            assert(false);
            System.out.println("Turn on assertions");
            System.exit(0);
        } catch(AssertionError ae) {
        }
        TestDoub td = new TestDoub(args[0]);
        Random r = new Random();
        int s = r.nextInt();
        if(args.length == 2)
            s = Integer.parseInt(args[1]);
        System.out.println("Seed = "+s);
        r.setSeed(s);
        for(int i=0;i<10;i++) {
            int n = 2 + r.nextInt(3);
            boolean b = (r.nextInt(2)==0);
            for(int j=0;j<n;j++) {
                if(b)
                    td.pushBack(r.nextInt());
                else
                    td.pushFront(r.nextInt());
            }
            n = r.nextInt(2);
            b = (r.nextInt(2) == 0);
            for(int j=0;j<n;j++) {
                if(b)
                    td.popBack();
                else
                    td.popFront();
            }
        }
        if(VERBOSE)System.out.println(td.ai);
        System.out.println("All tests passed");
    }
}
