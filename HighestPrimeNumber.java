package com.company;

public class HighestPrimeNumber {

    public static void findPrime(int num){

        int p;

        boolean[] bool = new boolean[num +1];

        for(int i=0; i<=num;i++){
            bool[i] = true;
        }

        for(p = 2; p*p <=num; p++) {

            if (bool[p]) {// if it is true explore all possibilities

                for (int j = p * p; j <= num; j += p) {
                    bool[j] = false;
                }

            }
        }

        // Print all prime numbers
        for(int i = 2; i <= num; i++)
        {
            if(bool[i] == true)
                System.out.print(i + " ");
        }
    }


    public static void main(String args[]){

        findPrime(100);


    }


}
