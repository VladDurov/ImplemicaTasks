package bonus;

public class Bonus {

    public static class Task1{

        public static int x1;
        public static int x2;

        public static void swap(){

            x1 = x1 + x2;
            x2 = x1 - x2;
            x1 = x1 - x2;

        }

    }

    public static class Task2{

        public static int numberFloor;
        public static int numberAccess;

        public static void search(int n, int m, int numberApartment){

            for (numberAccess = 1; numberAccess*m*n < numberApartment; numberAccess++) {}

            numberFloor = n - (numberAccess*m*n - numberApartment)/m;

        }

    }

    public static class Task3{

        public static int nod4(int a, int b, int c, int d){
            return nod(nod(a, b), nod(c, d));
        }

        static int nod(int a, int b){
            int nod = 1;
            for (int i = 1; i <= (a>b?a:b); i++) {
                if(a%i==0 && b%i==0){
                   nod = i;
                }
            }
            return nod;
        }

    }

    public static class Task4{
        public static int fib(int n){
            if(n <= 1)
                return n;

            return fib(n-1) + fib(n-2);
        }
    }

    public static class Task5{

    }

}
