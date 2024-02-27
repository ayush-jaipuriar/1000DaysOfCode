package JavaTheory;

public class PassByValueVsReference {
    public static void main(String[] args) {
        // Example to demonstrate pass by value
        Integer x = 10;
        modifyPrimitive(x);
        System.out.println("Value of x after modification: " + x);

        // Example to demonstrate pass by reference 
        StringBuilder str = new StringBuilder("Hello");
        modifyReference(str);
        System.out.println("Value of str after modification: " + str);
    }

    public static void modifyPrimitive(int a) {
        a = 20;
    }

    public static void modifyReference(StringBuilder s) {
        s.append(" World!");
    }
}
