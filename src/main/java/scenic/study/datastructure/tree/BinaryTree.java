package scenic.study.datastructure.tree;

/**
 * Created by scenic on 2015/5/3.
 */
public class BinaryTree {
    private BinaryTreeNote root;

    public static  void main(String args[]){
        new BinaryTree().run();
    }

    public void run(){
//        test_makeTree1();
        test_makeTree2();
        System.out.println(root.preOrder());
        System.out.println(root.inOrder());
        System.out.println(root.postOrder());
        System.out.println(root.levelOrder());
        System.out.println("===========================");
        root.levelOrderPrint();

    }

    private void test_makeTree2(){
        {
            String[] tree1 = new String[]{
                    "-","+","/","a","x","e","f"
            };

            String[] tree2 = new String[]{
                    "%","b","c"
            };

            BinaryTreeNote xTree= null;

            for (int i = 0; i < tree1.length; i++) {
                BinaryTreeNote temp = add(root,tree1[i]);
                if(i == 0){
                    root = temp;
                }
                if(temp.getData().equals("x")){
                    xTree = temp;
                }
            }

            BinaryTreeNote noteTree2 = createTreeByArrayAndReturnRootNote(tree2);

            xTree.setLChild(noteTree2);

            xTree.setRChild(new BinaryTreeNote("d"));
        }
    }

    private void test_makeTree1() {
        String[] tree1 = new String[]{
            "-","+","/","a","x","e","f"
        };

        String[] tree2 = new String[]{
                "-","b","c"
        };

        BinaryTreeNote xTree= null;

        for (int i = 0; i < tree1.length; i++) {
            BinaryTreeNote temp = add(root,tree1[i]);
            if(i == 0){
                root = temp;
            }
            if(temp.getData().equals("x")){
                xTree = temp;
            }
        }

        BinaryTreeNote noteTree2 = createTreeByArrayAndReturnRootNote(tree2);

        xTree.setLChild(noteTree2);

        xTree.setRChild(new BinaryTreeNote("d"));
    }

    public BinaryTreeNote createTreeByArrayAndReturnRootNote(Object[] objects){
        BinaryTreeNote root = new BinaryTreeNote(objects[0]);
        for (int i = 1; i < objects.length; i++) {
            add(root,objects[i]);
        }
        return root;
    }

    /**
     * 顺序的横向的增加
     * @param object
     */
    public BinaryTreeNote add(BinaryTreeNote root,Object object){

        //create new note
        BinaryTreeNote newTree = new BinaryTreeNote(object);

        if(root != null) {
            BinaryTreeNote cursor = root;
            BinaryTreeNote last;

            while (cursor != null){
                last = cursor;

                //get the left and right child
                BinaryTreeNote lChild = cursor.getLChild();
                BinaryTreeNote rChild = cursor.getRChild();

                if(lChild == null && rChild == null){
                    //如果条件成立，说明已经是叶子节点了

                    newTree.setParent(last);
                    last.setLChild(newTree);
                    cursor = null;
                }else if(lChild != null && rChild == null){
                    newTree.setParent(last);
                    last.setRChild(newTree);
                    cursor = null;
                }else {
                    //以上条件都不满足的话，需要往下进行遍历

                    if(lChild.getLChild() != null && lChild.getRChild() != null &&
                            (rChild.getLChild() == null | rChild.getRChild() == null)){
                        cursor = rChild;
                    }else {
                        cursor = lChild;
                    }
                }
            }
        }
        return newTree;
    }
}
