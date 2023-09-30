package binarySearchTree;

public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }


        public BST insert(int value) {
            if (value < this.value) {
                if (left ==null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }

            }
            return this;
        }

        public boolean contains(int value) {
            if (value > this.value) {
                if (right != null) {
                    return right.contains(value);
                } else {
                    return false;
                }
            } else if (value < this.value) {
                if (left != null) {
                    return left.contains(value);
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        right = right.right;
                        left = right.left;
                    }
                } else if (parent.left ==  this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getMinValue() {
            if (left != null) {
                return left.getMinValue();
            } else {
                return this.value;
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.left.left = new BST(2);
        bst.left.left.left = new BST(1);
        bst.left.right = new BST(5);


        bst.right = new BST(15);
        bst.right.right = new BST(22);
        bst.right.left = new BST(13);
        bst.right.left.right = new BST(14);


//        System.out.println(bst.contains(12));
        BST bstNew = bst.insert(16);
        System.out.println(bstNew);
    }
}
