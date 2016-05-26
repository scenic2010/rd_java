package scenic.study.datastructure.tree.deprecated;


import scenic.study.datastructure.tree.deprecated.Note;

import java.util.ArrayList;

import java.util.Stack;

/**
 * Created by scenic on 2015/4/18.
 */
public class TreeUtils {

    Note root;
    int row;

    TreeUtils(Note root) {
        this.root = root;
    }

    int depth(Note root) {
        int ldepth, rdepth;
        if (root == null) {
            return 0;
        } else {
            ldepth = depth(root.left);
            rdepth = depth(root.right);
            return ldepth > rdepth ? ldepth + 1 : rdepth + 1;
        }
    }

    private int get2_N(int n) {
        //cacle 2的n次放
        int vale = 1;
        for (int i = 0; i < n; i++) {
            vale *= 2;
        }
        return vale;
    }


    private void print(Note note){
        if(note == null){
            return;
        }
        Note left = note.left;
        Note right = note.right;

        print(right);
        System.out.print(note.data + " ");
        print(left);

    }

    public void printAsGraphics() {

        print(root);

//        while (true){
//            Note left = root.left;
//            Note right = root.right;
//        }


//        ArrayList[] lists = fillTheArray();
//
//        System.out.println();
//        for (int i = 0; i < lists.length; i++) {
//            ArrayList list = lists[i];
//            for (int j = 0; j < list.size(); j++) {
//                String data = (String) list.get(j);
//                System.out.print(data);
//            }
//            System.out.println("");
//        }

    }

    private ArrayList[] fillTheArray() {
        //计算数的深度

        Note note = root;

        int depth = depth(note);

        ArrayList<String>[] lists = new ArrayList[depth+4];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<String>();
        }

        Stack<Note> mStack = new Stack<Note>();
        Note iterator = root;
        while (true) {
            if (iterator != null) {
                int data = iterator.data;
                System.out.print(data + " ");
                lists[row].add(data+"\t");
            }

            if (iterator != null) {
                mStack.push(iterator);
                iterator = iterator.left;
                row++;
                if(iterator ==null){
                    lists[row].add("null\t");
                    row --;

                }
            } else {

                if (mStack.isEmpty()) {
                    return lists;
                } else {
                    Note parent = mStack.pop();
                    iterator = parent.right;
                    if(iterator != null){
                        row++;
                    }else {
                        lists[row].add("null\t");
                        row--;
                    }

                    if(mStack.size() == 0){
                        row = 1;
                    }
                }
            }
        }
    }
}
