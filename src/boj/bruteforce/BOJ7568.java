package boj.bruteforce;

import java.util.Scanner;

public class BOJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < people.length; i++) {
            int rank = 1;
            for (int j = 0; j < people.length; j++) {
                if(people[j].weight > people[i].weight && people[j].height > people[i].height)
                    rank++;
            }
            people[i].rank = rank;
        }
        for (Person person : people) {
            System.out.print(person.rank + " ");
        }

    }

    static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}