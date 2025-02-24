class Practical9factorial {
	public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please enter size,start range and end range");
            return;
        }

        int size = Integer.parseInt(args[0]);
        int startRange = Integer.parseInt(args[1]);
        int endRange = Integer.parseInt(args[2]);

        int[] numbers = new int[size];
        for (int i=0;i<size;i++) {
            long nanoTime = System.nanoTime();
            int num =startRange+(int)(nanoTime%(endRange-startRange+1));
            numbers[i] = num;
        }

        for (int i=0;i<numbers.length;i++) {
            System.out.println("num: " + numbers[i]);
        }

        double avgTimeRecursive = calculateAverageTimeRecursive(numbers);
        System.out.println("recursion time for factorial=" + avgTimeRecursive);

        double avgTimeIterative = calculateAverageTimeIterative(numbers);
        System.out.println("iteration time for factorial= " + avgTimeIterative);
    }

    
    public static long factorialRecursive(int n) {
        if (n==0 || n==1) {
            return 1;
        } else {
            return n*factorialRecursive(n-1);
        }
    }

    public static long factorialIterative(int n) {
        long result=1;
        for (int i=1;i<=n;i++) {
            result*= i;
        }
        return result;
    }

    public static double averageTimeRecursive(int[] numbers) {
        long totaltime = 0;
        for (int i=0;i<numbers.length;i++) {
            long starttime = System.nanoTime();
            factorialRecursive(numbers[i]);
            long endtime = System.nanoTime();
            totaltime+=endtime-starttime;
        }
        return totaltime/(double)numbers.length;
    }

    public static double averageTimeIterative(int[] numbers) {
        long totaltime = 0;
        for (int i=0; i<numbers.length;i++) {
            long starttime = System.nanoTime();
            factorialIterative(numbers[i]);
            long endtime = System.nanoTime();
            totaltime += (endtime-starttime);
        }
        return totaltime/(double)numbers.length;
    }
//String buffer,string builder,string
}
