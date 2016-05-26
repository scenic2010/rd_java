package scenic.study.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by scenic on 2015/5/3.
 */
public class BinaryTreeNote {
    private Object data;
    private BinaryTreeNote parent;
    private BinaryTreeNote lChild;
    private BinaryTreeNote rChild;
    private int height;
    private int level;
    private int size;

    public BinaryTreeNote(){

    }

    public BinaryTreeNote(Object obj){
        this.data = obj;
        height=0;
        size = 1;
        level = 0;
        parent = lChild = rChild = null;

    }

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public boolean hasParent(){
        return parent !=  null;
    }

    public boolean hasLChild(){
        return lChild != null;
    }

    public boolean hasRChild(){
        return rChild != null;
    }

    public boolean isLeaf(){
        return !hasLChild() && !hasRChild();
    }

    public boolean isLChild(){
        return hasParent() && this == parent.lChild;
    }

    public boolean isRChild(){
        return hasParent() && this== parent.rChild;
    }

    /**
     * 当增加新的节点的时候需要进行更新
     */
    public void updateHeight(){
        int newHeight = 0;
        if(hasLChild()) newHeight = Math.max(newHeight,1 + lChild.height);
        if(hasRChild()) newHeight = Math.max(newHeight,1 + rChild.height);
        if(height == newHeight){
            return;
        }
        height = newHeight;

        if(hasParent()){
            parent.updateHeight();
        }
    }

    public void updateLevel(){
        if(hasParent()){
            level = getParent().level + 1;
        }
        if(hasLChild()){
            getLChild().updateLevel();
        }
        if(hasRChild()){
            getRChild().updateLevel();
        }
    }

    public BinaryTreeNote getParent(){
        return parent;
    }

    public void setParent(BinaryTreeNote note){
        this.parent = note;
    }

    public BinaryTreeNote getLChild(){
        return lChild;
    }

    public BinaryTreeNote getRChild(){
        return rChild;
    }


    public int getSize(){
        return size;
    }

    public void updateSize(){
        int size  = 1;
        if(hasLChild()) size += getLChild().getSize();
        if(hasRChild()) size += getRChild().getSize();
        this.size = size;

        if(hasParent()) getParent().updateSize();
    }


    public void sever(){
        if(!hasParent()){
            return;
        }
        if(isLChild()){
            parent.lChild = null;
        }
        if(isRChild()){
            parent.rChild = null;
        }
        parent.updateHeight();
        parent.updateSize();
        parent.updateLevel();
        parent = null;
    }

    public BinaryTreeNote setLChild(BinaryTreeNote note){
        BinaryTreeNote old = getLChild();
        if(hasLChild()){
            getLChild().sever();
        }
        if(note != null){
            note.sever();
            this.lChild = note;
            note.parent = this;
            updateSize();
            updateHeight();
            updateLevel();
        }
        return old;
    }

    public BinaryTreeNote setRChild(BinaryTreeNote note){
        BinaryTreeNote old = note;

        if(hasRChild()){
            getRChild().sever();
        }

        if(note != null){
            this.rChild = note;
            note.parent = this;
            updateHeight();
            updateSize();
            updateLevel();
        }

        return old;
    }

    ////////////////level order

    public List<BinaryTreeNote> levelOrder(){
        LinkedList<BinaryTreeNote> list = new LinkedList<BinaryTreeNote>();
        levelOrderByQueue(this,list);
//        levelOrderPrint();
        return list;
    }

    private void levelOrderByQueue(BinaryTreeNote note,List<BinaryTreeNote> list){
        if(note == null){
            return;
        }
        Queue<BinaryTreeNote> queue  = new LinkedList<BinaryTreeNote>();

        queue.add(note);
        while (!queue.isEmpty()){
            BinaryTreeNote p = queue.poll();
            list.add(p);
            if(p.hasLChild()){
                queue.add(p.getLChild());
            }

            if(p.hasRChild()){
                queue.add(p.getRChild());
            }
        }
    }

    public void levelOrderPrint(){
        BinaryTreeNote note = this;
        if(note == null){
            return;
        }

        Queue<BinaryTreeNote> queue  = new LinkedList<BinaryTreeNote>();

        queue.add(note);
        int level = -1;
        while (!queue.isEmpty()){
            BinaryTreeNote p = queue.poll();

            if(level != p.level){
                System.out.println();
                level = p.level;
            }

            System.out.print(p + "   ");

            if(p.hasLChild()){
                queue.add(p.getLChild());
            }

            if(p.hasRChild()){
                queue.add(p.getRChild());
            }
        }
    }

    ////////////////end level order



    //////post order
    public List<BinaryTreeNote> postOrder() {
        LinkedList<BinaryTreeNote> list = new LinkedList<BinaryTreeNote>();
        postOrderRecursion(this,list);
//        postOrder(this,list);
        return list;
    }

    private void postOrderRecursion(BinaryTreeNote note , List<BinaryTreeNote> list){
        if(note == null){
            return;
        }

        postOrderRecursion(note.getLChild(), list);
        postOrderRecursion(note.getRChild(), list);
        list.add(note);


    }

    private void postOrder(BinaryTreeNote note, List<BinaryTreeNote> list){
        if(note == null){
            return;
        }

        BinaryTreeNote cursor = note;

        Stack<BinaryTreeNote> stack = new Stack<BinaryTreeNote>();

        while (cursor != null || !stack.empty()){
            while (cursor != null){
                //先左后右，不断的深入

                stack.push(cursor);

                if(cursor.hasLChild()){
                    cursor = cursor.getLChild();
                }else {
                    cursor = cursor.getRChild();
                }
            }

            System.out.println("============print the stack=======================");
            System.out.println(stack);
            System.out.println("============finish print the stack=================");

            if(!stack.isEmpty()){
                cursor = stack.pop();
                list.add(cursor);
//                list.addLast(cursor);
                System.out.println("add " + cursor.getData());
            }
            System.out.println("=============begin add in while =====");
            while (!stack.isEmpty() && stack.peek().getRChild() == cursor){
                cursor = stack.pop();
//                list.addLast(cursor);
                list.add(cursor);
                System.out.println("add " + cursor.getData());
            }

            if(!stack.isEmpty()){
                cursor = stack.peek().getRChild();
            }else {
                cursor = null;
            }
        }
    }

    /////post order end


    ////////inOrder start
    public List<BinaryTreeNote> inOrder(){
        List<BinaryTreeNote> list = new LinkedList<BinaryTreeNote>();
        inOrderRecursion(this,list);
        return list;
    }

    private void inOrderRecursion(BinaryTreeNote note , List<BinaryTreeNote> list){
        if(note == null){
            return;
        }
        inOrderRecursion(note.getLChild(), list);
        list.add(note);
        inOrderRecursion(note.getRChild(), list);
    }
    //////////inOrder end


    ////////preOrder start////////
    public List<BinaryTreeNote> preOrder(){
        List<BinaryTreeNote> list = new LinkedList<BinaryTreeNote>();
        if(false){
            preOrderRecursion(this, list);
        }else {
            preOrder(this,list);
        }
        return list;
    }

    private void preOrderRecursion(BinaryTreeNote note, List<BinaryTreeNote> linkedList){
        if(note == null){
            return;
        }
        linkedList.add(note);
        preOrderRecursion(note.getLChild(), linkedList);
        preOrderRecursion(note.getRChild(), linkedList);
    }


    private void preOrder(BinaryTreeNote note,List<BinaryTreeNote> list){
        if(note == null){
            return;
        }
        BinaryTreeNote cursor = note;
        Stack<BinaryTreeNote> stack = new Stack<BinaryTreeNote>();
        while (cursor != null || !stack.empty()){
            if(cursor != null){
                list.add(cursor);
                stack.add(cursor);
                cursor = cursor.getLChild();
            }else {
                BinaryTreeNote parent = stack.pop();
                cursor = parent.getRChild();
            }
        }
    }
    ////////preOrder finish////////


    @Override
    public String toString() {
        return data.toString();
    }

//    @Override
//    public String toString() {
//        return data.toString() + "(" +
//                "h:" + height +
//                " size:" + size +
//                " level " +  level +
//                ")";
//    }


}
