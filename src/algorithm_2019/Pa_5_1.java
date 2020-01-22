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
        WordNode superNode;

        public WordNode(String word, String mean, WordNode superNode) {
            this.word = word;
            this.mean = mean;
            this.superNode = superNode;
        }

    }

    static class WordTree {
        WordNode root = null;
        int size = 0;

        WordNode find(String target) {
            WordNode curr = this.root;
            while(curr != null) {
                if(curr.word.compareTo(target)==0) {
                    return curr;
                } else if (curr.word.compareTo(target) < 0) {
                    curr = curr.rightNode;
                } else
                    curr = curr.leftNode;
            }
            return null;
        }

        public int getSize() {
            return size;
        }

        void add(String word, String mean) {
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
                this.root = new WordNode(word, mean, null);
            } else if (prev.word.compareTo(word) > 0) {
                prev.leftNode = new WordNode(word, mean, prev);
            } else
                prev.rightNode = new WordNode(word, mean, prev);

            this.size++;
        }

        void delete(String target) {
            WordNode z = find(target), y, x;
            if (z.leftNode == null || z.rightNode==null)
                y = z;
            else
                y = successor(z);
            if (y.leftNode != null) {
                x = y.leftNode;
            } else {
                x = y.rightNode;
            }
            if (x != null) {
                x.superNode = y.superNode;
            }
            if (z.superNode == null) {
                this.root = x;
            } else if ( y == y.superNode.leftNode )
                y.superNode.leftNode = x;
            else
                y.superNode.rightNode = x;
            if(y!=z){
                z.word = y.word;
                z.mean = y.mean;
                y = null;
            }
        }

        private WordNode successor(WordNode curr) {
            if(curr.rightNode != null) {
                WordNode tmp = curr.rightNode;
                WordNode tmp2 = curr;
                while(tmp != null) {
                    tmp2 = tmp;
                    tmp = tmp.leftNode;
                }
                return tmp2;
            }
            WordNode y = curr.superNode;
            while(y!=null && curr == y.rightNode) {
                curr = y;
                y = y.superNode;
            }
            return y;
        }

        void deleteAll(String fileName) throws NoSuchElementException, FileNotFoundException {
            String path = "E:\\practice\\algorithm\\src\\algorithm_2019\\resource\\";
            path += fileName;
            Scanner fileScanner = new Scanner(new File(path));

            String word;

            while(true) {
                word = fileScanner.next();
                delete(word);
            }
        }
    }

    public static void main(String[] args) {
        WordTree wordTree = new WordTree();
        try {
            initDictionary(wordTree);
        } catch (NoSuchElementException ignore) {
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        String command, arg;

        while(true) {
            System.out.print("$ ");
            command = sc.next();
            if(command.equals("size")) {
                System.out.println(wordTree.size);
            } else if (command.equals("find")) {
                arg = sc.next();
                WordNode target = wordTree.find(arg);
                if (target != null) {
                    System.out.println(target.mean);
                } else
                    System.out.println("There's not exist such word.");
            } else if (command.equals("add")) {
                System.out.print("word: ");
                String word = sc.next();
                System.out.print("class: ");
                String mean = "(";
                sc.nextLine();
                mean = mean + sc.nextLine();
                if(mean.equals("("))
                    mean += ") ";
                else
                    mean += ".) ";
                System.out.print("meaning: ");
                mean += sc.nextLine();
                wordTree.add(word, mean);
            } else if (command.equals("delete")) {
                arg = sc.next();
                wordTree.delete(arg);
            } else if (command.equals("deleteall")) {
                arg = sc.next();
                try {
                    wordTree.deleteAll(arg);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (command.equals("exit"))
                break;
            else{
                System.out.println("Wrong Command.");
            }
        }
    }

    private static void initDictionary(WordTree wordTree) throws NoSuchElementException, FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("E:\\practice\\algorithm\\src\\algorithm_2019\\resource\\shuffled_dict.txt"));

        String word, mean;
        while(true) {
            word = fileScanner.next();
            mean = fileScanner.nextLine();
            wordTree.add(word,mean);
        }
    }

}
