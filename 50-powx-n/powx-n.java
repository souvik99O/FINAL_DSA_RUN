class Solution {
    public double myPow(double x, int n) {
        if(n >= 0)
            return f(n, x);
        else {
            return 1.0 / f(-(long)n, x);  // Cast to long to handle Integer.MIN_VALUE
        }
    }

    public static double f(long n, double x) {  // Changed to long
        if(n == 0)
            return 1;
        
        if(n % 2 == 0) {
            double half = f(n/2, x);
            return half * half;
        } else {
            return x * f(n-1, x);
        }
    }
}
