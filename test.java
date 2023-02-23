import java.util.*;

class test {

  public static String decimalToBinary(int decimal) {
    // if (decimal == 0) {
    //   return "0";
    // }

    StringBuilder binary = new StringBuilder();
    // int absValue = Math.abs(decimal);
    int bit = 0;
    while (bit < 33) {
      int a = decimal & 1;
      binary.append(a);
      bit++;
      decimal >>= 1;
    }

    // if (decimal < 0) {
    //     binary.append('-');
    // }

    return binary.reverse().toString();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = -77;
    System.out.println(decimalToBinary(n) + " " + n);
    int bit = 0;
    while (bit < 32) {
      System.out.println(decimalToBinary(n) + " " + n);
      n >>= 1;
      bit++;
    }
    scn.close();
  }
}
// 1 11111111111111111111111110110011 -77
// 0 00000000000000000000000001001101 77
