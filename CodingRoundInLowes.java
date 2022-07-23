// You have N boxes with numbers 1, 2, ....., N and an array capacities, in which each capacity(1<= i <= N) represents the storage capacity of the ith box. 
// You also have N + 1 type of candies and an array available, in which each available (1 <= i <= N + 1) represents the number of candies available of the ith type.
// The ith box can store the candies of type ith or i+1th (1<= i <= N). Find the maximum number of candies you can store in all the boxes under modulo 10^9 + 7.

// Input Format 
// The first input line contains an integer, N, denoting the number of boxes. The next N lines contain an integer describing the elements in. 
// The next line contains an integer that is equal to N + 1. The next N + 1 lines contain an integer describing the elements in.

// Testcases 
// Input 1
// 1
// 5
// 2
// 2 2
// Output 1
// 4

// Explanation
// Storing 2 candies of each type
// Answer = 2 + 2 = 4

// Input 2
// 2
// 4 5
// 3
// 3 5 2
// Output 2
// 9

// Explanation
// Store 2 candies in box 1 of type 1.
// capacity = {2, 5}
// available = {1, 5, 2}
// Store 2 candies in box 1 of type 2.
// capacity = {0, 5}
// available = {1, 3, 2}
// Store 2 candies in box 2 of type 2.
// capacity = {0, 2}
// available = {1, 0, 2}
// Store 2 candies in box 1 of type 3.
// capacity = {0, 0}
// available = {1, 0, 0}
// Answer = 2 + 2 + 3 + 2 = 9

import java.util.*;

public class CodingRoundInLowes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int capacity[] = new int[N];
        for(int i = 0; i < N; i++) {
            capacity[i] = sc.nextInt();
        }

        int types = sc.nextInt();
        int available[] = new int[types];
        for(int i = 0; i < types; i++) {
            available[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            int total = available[i];
            int size = capacity[i];

            if(size > total) {
                available[i] = 0;
                capacity[i] = size - total;
                count += total;

                int newTotal = available[i+1];
                int newSize = capacity[i];

                if(newSize > newTotal) {
                    available[i + 1] = 0;
                    capacity[i] = newSize - newTotal;
                    count += newTotal;
                } else {
                    available[i + 1] = newTotal - newSize;
                    capacity[i] = 0;
                    count += newSize;
                }
            } else {
                available[i] = total - size;
                capacity[i] = 0;
                count += size;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
