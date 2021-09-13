public class BSTTester {

    public static void main(String[] args) {
        LinkedBST<Integer> iBST = new LinkedBST<Integer>();
        iBST.add(8);
        iBST.add(2);
        iBST.add(12);
        iBST.add(1);
        iBST.add(4);
        iBST.add(10);
        iBST.add(16);
        iBST.printPreorder();
        iBST.printInorder();
        System.out.println(iBST.search(4));
        iBST.remove(4);
        iBST.remove(8);
        iBST.printInorder();

    }
}
