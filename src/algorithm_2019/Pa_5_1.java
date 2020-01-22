package algorithm_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pa_5_1 {

    static class WordNode {
        String word;
        String mean;
        WordNode leftNode = null;
        WordNode rightNode = null;

        public WordNode(String word, String mean) {
            this.word = word;
            this.mean = mean;
        }
    }

    static class WordTree {
        WordNode root = null;
        int size = 0;

        void find(String target) {
            WordNode curr = this.root;
            while(curr != null) {
                if(curr.word.compareTo(target)==0) {
                    System.out.println(curr.mean);
                    return;
                } else if (curr.word.compareTo(target) < 0) {
                    curr = curr.rightNode;
                } else
                    curr = curr.leftNode;
            }
            System.out.println("There's not exist such word.");
        }

        public int getSize() {
            return size;
        }

        void add(String word, String mean) {
            if(this.size == 106434) {
                System.out.println("hi");
            }
            WordNode curr = this.root;
            WordNode prev = null;

            while(curr!=null) {
                prev = curr;
                if(curr.word.compareTo(word) > 0)
                    curr = curr.leftNode;
                else
                    curr = curr.rightNode;
            }

            if(prev == null) {
                this.root = new WordNode(word, mean);
            } else if (prev.word.compareTo(word) > 0) {
                prev.leftNode = new WordNode(word, mean);
            } else
                prev.rightNode = new WordNode(word, mean);

            this.size++;
        }

//        boolean delete(String target) {
//
//        }
//
//        boolean deleteAll(String fileName) {
//
//        }

    }

    public static void main(String[] args) {
        WordTree wordTree = new WordTree();
        try {
            initDictionary(wordTree);
        } catch (NoSuchElementException ignore) {
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }

//        while(true) {
//            System.out.println("$ ");
//        }
    }

    private static void initDictionary(WordTree wordTree) throws NoSuchElementException, FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("D:\\java\\practice\\algorithm\\src\\algorithm_2019\\resource\\shuffled_dict.txt"));

        String word, mean;
        while(true) {
            word = fileScanner.next();
            mean = fileScanner.nextLine();
            wordTree.add(word,mean);
        }
    }

}
