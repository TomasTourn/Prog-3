package TP_Arboles.Ejercicio1;


import TP_Arboles.Ejercicio1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    public Integer getRoot() {
        return this.root.getValue();
    }


    public boolean hasElem(Integer elem) {
        return hasElem(root, elem);
    }

    private boolean hasElem(TreeNode actual, Integer elem) {
        if (actual.getValue().equals(elem)) {//si es igual devuelvo true
            return true;
        } else if (actual.getValue() > elem) {//si es menor chequeo q haya un nodo izquierdo, si lo hay lo paso como raiz, si no encuentra es false
            if (actual.getLeft() == null) {
                return false;
            }
            return hasElem(actual.getLeft(), elem);
        } else {
            if (actual.getRight() == null) {
                return false;
            }
            return hasElem(actual.getRight(), elem);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Integer getMaxElement() {
        if (this.root != null) {
            return getMaxElement(this.root);
        } else return 0;
    }

    private Integer getMaxElement(TreeNode actual) {
        if (actual.getRight() != null) {
            return getMaxElement(actual.getRight());
        } else return actual.getValue();
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(TreeNode actual) {

        if (actual == null) {
            return 0;
        } else {
            int rightHeight = getHeight(actual.getRight());
            int leftHeight = getHeight(actual.getLeft());
            return Math.max(rightHeight, leftHeight) + 1;//returns the maximum height adding 1 to count the root
        }
    }

    public void printPostOrder() {
        printPostOrder(this.root);
    }

    private void printPostOrder(TreeNode current) {
        if (current != null) {
            printPostOrder(current.getLeft());
            printPostOrder(current.getRight());
            System.out.println(current.getValue() + " ");
        }
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode current) {
        if (current != null) {
            System.out.println(current.getValue() + " ");
            printPreOrder(current.getLeft());
            printPreOrder(current.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode current) {
        if (current != null) {
            printInOrder(current.getLeft());
            System.out.println(current.getValue() + " ");
            printInOrder(current.getRight());
        }
    }


    public List<TreeNode> getLongestBranch() {
        List<TreeNode> currentBranch = new ArrayList<>();
        List<TreeNode> longestBranch = new ArrayList<>();
        findLongestBranch(this.root, currentBranch, longestBranch);
        return longestBranch;
    }

    private void findLongestBranch(TreeNode current, List<TreeNode> currentBranch, List<TreeNode> longestBranch) {

        if (current == null) {//reached the end of the branch, time to compare
            if (currentBranch.size() > longestBranch.size()) {
                longestBranch.clear();
                longestBranch.addAll(currentBranch);//updates the longest branch
            }
            return;  //statement to exit the current recursive call
        }
        currentBranch.add(current);
        findLongestBranch(current.getLeft(), currentBranch, longestBranch);
        findLongestBranch(current.getRight(), currentBranch, longestBranch);


        currentBranch.remove(currentBranch.size() - 1);//once it gets to a leaf, starts backtracking

    }

    public List<TreeNode> getFrontera() {
        return getFrontera(this.root);
    }

    private List<TreeNode> getFrontera(TreeNode current) {
        List<TreeNode> frontera = new ArrayList<>();

        if (current == null) {
            return frontera;  // if the current node is empty, returns an empty list
        }

        if (current.getLeft() == null && current.getRight() == null) {
            frontera.add(current); // adds the current node if is a leaf
        }

        // recursive call on left and right childrens
        frontera.addAll(getFrontera(current.getLeft()));
        frontera.addAll(getFrontera(current.getRight()));

        return frontera;
    }

    public List<TreeNode> getElemAtLevel(int targetLevel) {
        List<TreeNode> nodesAtLevel = new ArrayList<>();
        getElemAtLevel(targetLevel, 1, this.root, nodesAtLevel);
        return nodesAtLevel;
    }

    private void getElemAtLevel(int targetLevel, int currentLevel, TreeNode current, List<TreeNode> nodesAtLevel) {
        if (current == null) {
            return;//ends the recursion
        }
        if (targetLevel == currentLevel) {//if levels match, adds the node
            nodesAtLevel.add(current);
        } else {//if not, keeps searching on childrens
            getElemAtLevel(targetLevel, currentLevel + 1, current.getLeft(), nodesAtLevel);
            getElemAtLevel(targetLevel, currentLevel + 1, current.getRight(), nodesAtLevel);
        }
    }

    public boolean delete(Integer value) {

        if (root == null) {
            return false;
        }

        TreeNode parent = null;
        TreeNode current = root;
        Boolean isLeftChild = false;

        while (current != null && !current.getValue().equals(value)) {//while current is not null and is not the value keep searching

            parent = current;
            if (value < current.getValue()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }

        }

        if (current == null)// in case the value is not found
            return false;

        if (current.getLeft() == null && current.getRight() == null)//case 1: leaf node
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

        else if (current.getRight()==null) {//case 2: node has 1 child;
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getRight());
            }
        }
        else {//case 3: has 2 children

            TreeNode successor=getSuccessor(current);
            if (current==root){
                root=successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            }else{
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }
    //helper method to find the smallest node on the right subtree
    private TreeNode getSuccessor(TreeNode node){

        TreeNode successorParent=node;
        TreeNode successor=node;
        TreeNode current= node.getRight();

        while (current!=null){//finds the most left node
            successorParent=current;
            successor= current;
            current=current.getLeft();
        }
        if (successor.getRight()!=null){
            successorParent.setLeft(successor.getRight());//connects the parent with the right child of successor
            successor.setRight(node.getRight());//changes successor child for the deleted node child
        }
        return successor;
    }

    public int sum(){
        return sum(this.root);
    }
    private int sum(TreeNode current){

        if (current==null){
            return 0;
        }
        if (current.getRight()!=null && current.getLeft()!=null){//has both children, recursive call to both
            return current.getValue()+sum(current.getRight())+sum(current.getLeft());
        } else if (current.getRight()==null) {//recursive call to left child
            return current.getValue()+sum(current.getLeft());
        }else{
            return current.getValue()+sum(current.getRight());
        }
    }

    //option 1 more optimized
    public List<Integer>leafsBigger(Integer value){
        List<Integer>leafs=new ArrayList<>();
        leafsBigger(value,this.root,leafs);
        return leafs;
    }

    private void leafsBigger(Integer value,TreeNode current,List<Integer> leafs){

        if (current.getRight()==null && current.getLeft()==null && value<current.getValue()){
            leafs.add(current.getValue());
        }
        else if (current.getRight()==null){
            leafsBigger(value,current.getLeft(),leafs);
        }else if (current.getLeft()==null){
            leafsBigger(value,current.getRight(),leafs);
        }else {
            leafsBigger(value,current.getRight(),leafs);
            leafsBigger(value,current.getLeft(),leafs);
        }
    }

    //option 2 less optimized
    public List<Integer> leafsBiggerThan(Integer value){
        return leafsBiggerThan(value,this.root);
    }
    private List<Integer> leafsBiggerThan(Integer value, TreeNode current){

        List<Integer> leafs=new ArrayList<>();

        if (current.getRight()==null && current.getLeft()==null && value<current.getValue()){
            leafs.add(current.getValue());
        }
        else if (current.getRight()==null){
            leafs.addAll(leafsBiggerThan(value,current.getLeft()));
        }else if (current.getLeft()==null){
            leafs.addAll(leafsBiggerThan(value,current.getRight()));
        }else {
            leafs.addAll(leafsBiggerThan(value,current.getRight()));
            leafs.addAll(leafsBiggerThan(value,current.getLeft()));
        }

        return leafs;
    }


}




