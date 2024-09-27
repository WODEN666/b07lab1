public class Driver {
    public static void main(String [] args) {
        double [] coeff = {6, -2, 5};
        int [] expo = {0, 1, 3};
        Polynomial p1 = new  Polynomial(coeff, expo);
        Polynomial p2 = new  Polynomial("Desktop/text.txt");

        Polynomial product = p1.multiply(p2);
        product.saveToFile("Desktop/p1.txt");
        System.out.println("p2(0.1)" + p2.evaluate(0.1));



    }
}