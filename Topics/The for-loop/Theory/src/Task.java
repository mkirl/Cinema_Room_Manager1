import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // start coding here
    int start = scanner.nextInt();
    int end = scanner.nextInt();
    int diff = end - start;
    long total = start;
    for (int x = 1; x < diff; x++) {
      total *= (total+x);
    }
    System.out.println(total);

  }
}
