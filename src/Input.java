package src;

import java.util.Scanner;

class IO {
    static public void println() {
        System.out.println();
    }
    
    static public void println(Object str) {
        System.out.println(str);
    }
    
    static public void print(Object str) {
        System.out.print(str);
    }
    
    static public void printf(String str, Object... args) {
        System.out.printf(str, args);
    }

    static private Scanner scan = new Scanner(System.in);

    static public String input() {
        return scan.nextLine();
    }
    
    static public int inputInt() {
        return Integer.parseInt(scan.nextLine()); 
    }
    
    static public float inputFloat() {
        return Float.parseFloat(scan.nextLine());
            
    }
    
    static public double inputDouble() {
        return Double.parseDouble(scan.nextLine());
    }

    static public String[] inputParts() {
        return scan.nextLine().split(" ");
    }

    static public int strToInt(String str) {
        return Integer.parseInt(str);
    }
    
    static public float strToFloat(String str) {
        return Float.parseFloat(str);
    }
    
    static public double strToDouble(String str) {
        return Double.parseDouble(str);
    }

    static public String inputNext() {
        return scan.next();
    }
    
    static public int inputNextInt() {
        return scan.nextInt();
    }
    
    static public float inputNextFloat() {
        return scan.nextFloat();
    }
    
    static public double inputNextDouble() {
        return scan.nextDouble();
    }

    static public void closeScanner() {
        if (scan != null) {
            scan.close();
        }
    }
}