public class EjemploStringTestRendimientoConcat {
    public static void main(String[] args) {
    String a = "a";
    String b = "b";
    String c = a;

    StringBuilder sb = new StringBuilder(a);
    long inicio = System.currentTimeMillis();

    for (int i = 0; i < 100000; i++){
        // c = c.concat(a).concat(b).concat("\n"); // 500 => 0ms, 1000 => 16ms, 10000 => 125ms, 100000 => 4114
        // c += a + b + "\n"; // 500 => 16ms, 1000 = 16ms, 10000 => 63, 100000 = 2059ms
        sb.append(a).append(b).append("\n"); // 500 => 0ms, 1000 => 0ms, 10000 => 0ms, 100000 => 16ms

    }

    long fin = System.currentTimeMillis();
    System.out.println(fin - inicio);
    System.out.println("c = " + c);
        System.out.println("sb = " + sb);
    }
}
