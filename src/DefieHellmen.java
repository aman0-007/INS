import java.util.HashSet;
import java.util.Set;

public class DefieHellmen {

    public static void main(String[] args) {
        int P = 23;
        Integer G = findPrimitiveRoot(P);

        if (G != null) {
            System.out.println("Primitive root for " + P + " is: " + G);
        } else {
            System.out.println("No primitive root found or " + P + " is not a prime number.");
            return;
        }

        int a = 4; // Private key of A
        int b = 7; // Private key of B
        System.out.println("Private key of a: " + a);
        System.out.println("Private key of b: " + b);

        // ================= Compute public keys ===============
        int pa = modPow(G, a, P);
        int pb = modPow(G, b, P);
        System.out.println("Public key of a: " + pa);
        System.out.println("Public key of b: " + pb);

        // ================ Key exchange ==============
        int sa = modPow(pb, a, P);
        int sb = modPow(pa, b, P);

        System.out.println("Symmetric key of a: " + sa);
        System.out.println("Symmetric key of b: " + sb);

        // =============== Final check ==============
        if (sa == sb) {
            System.out.println("Keys match.");
        } else {
            System.out.println("Keys do not match.");
        }
    }

    // ==================================== PRIMITIVE ROOT METHODS ============================================= //

    public static Integer findPrimitiveRoot(int number) {
        if (!isPrime(number)) {
            return null;
        }

        int phi = number - 1;
        for (int g = 2; g < number; g++) {
            if (isPrimitiveRoot(g, number, phi)) {
                return g;
            }
        }
        return null;
    }

    private static boolean isPrimitiveRoot(int g, int n, int phi) {
        Set<Integer> set = new HashSet<>();
        for (int power = 1; power <= phi; power++) {
            int result = modPow(g, power, n);
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
        }
        return set.size() == phi;
    }

    private static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
