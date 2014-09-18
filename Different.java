public class Different {
    public static void main(String[] args) {
        Double val1 = Double.parseDouble(args[0]);
        Double err1 = Double.parseDouble(args[1]);
        Double val2 = Double.parseDouble(args[2]);
        Double err2 = Double.parseDouble(args[3]);
        double diff = Math.abs(val1-val2);
        double err = Math.sqrt(err1*err1+err2*err2);
        System.out.printf("%.2f\n",diff/err);
    }
}
