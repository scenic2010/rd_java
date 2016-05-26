package scenic.study.datastructure.tree.deprecated;

/**
 * Created by scenic on 2015/4/18.
 */
public class BinaryTree {

    private Note root;

    public static void main(String[] args) {
        new BinaryTree().run();
    }

    private void run() {

        int datas[] = {5,9,0, 1, 2,  6, 7, 8};

        for (int i = 0; i < datas.length; i++) {
            insertWithOder(datas[i]);
        }

        printTree(root);
        System.out.println();
        new TreeUtils(root).printAsGraphics();

    }

    public void insertWithOder(int data) {
        if (root == null) {
            root = new Note(data);
            return;
        }

        Note iterator = root;
        Note parent;
        while (true) {
            parent = iterator;
            //大的放在右边
            if (data >= iterator.data) {
                iterator = iterator.right;
                if (iterator == null) {
                    parent.right = new Note(data);

                    return;
                }
            } else {
                iterator = iterator.left;
                if (iterator == null) {
                    parent.left = new Note(data);
                    return;
                }
            }
        }

    }


    private void printTree(Note node) {

        if (node == null) return;

        // left, node itself, right

        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);

    }


}
