package algorithm_2020.pa4;

import java.util.Scanner;

public class Assign1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree addressBook = new BinaryTree();

        while (true) {
            System.out.print("$ ");

            String command = sc.next();
            switch (command) {
                case "read":
                    addressBook.read(sc.next());
                    break;
                case "list":
                    addressBook.list();
                    break;
                case "find":
                    addressBook.find(sc.next());
                    break;
                case "trace":
                    addressBook.trace(sc.next());
                    break;
                case "delete":
                    addressBook.deleteProcess(sc.next());
                    break;
                case "save":
                    addressBook.save(sc.next());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command.");
            }
        }
    }
}
