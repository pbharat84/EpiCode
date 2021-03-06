package com.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author translated from c++ by Blazheev Alexander
 */
public class PrimeSieve {
    // @include
    // Given n, return the primes from 1 to n.
    public static ArrayList<Integer> generate_primes_from_1_to_n(int n) {
        int size = (int)Math.floor(0.5 * (n - 3)) + 1;
        // is_prime[i] represents (2i + 3) is prime or not.
        ArrayList<Integer> primes = new ArrayList<Integer>();  // stores the primes from 1 to n.
        primes.add(2);
        boolean is_prime[] = new boolean[size];
        Arrays.fill(is_prime, true);
        for (long i = 0; i < size; ++i) {
            if (is_prime[(int) i]) {
                int p = (int) ((i << 1) + 3);
                primes.add(p);
                // Sieving from p^2, whose index is 2i^2 + 6i + 3.
                for (long j = ((i * i) << 1) + 6 * i + 3; j < size; j += p) {
                    is_prime[(int) j] = false;
                }
            }
        }
        return primes;
    }
    // @exclude

    public static void main(String[] args) {
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            System.out.println("n = " + n);
            ArrayList<Integer> primes = generate_primes_from_1_to_n(n);
            for(Integer prime : primes) {
                for(int j = 2; j < prime; ++j) {
                    assert (prime % j != 0);
                }
            }
        } else {
            Random r = new Random();
            for (int times = 0; times < 100; ++times) {
                int n = r.nextInt(999999) + 2;
                System.out.println("n = " + n);
                ArrayList<Integer> primes = generate_primes_from_1_to_n(n);
                for(Integer prime : primes) {
                    for(int j = 2; j < prime; ++j) {
                        assert (prime % j != 0);
                    }
                }
            }
        }

    }
}
