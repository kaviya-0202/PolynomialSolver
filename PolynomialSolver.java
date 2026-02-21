import java.math.BigInteger;
import java.util.*;
import java.io.File;
import org.json.JSONObject;

public class PolynomialSolver {

    public static BigInteger findConstantTerm(List<BigInteger> x, List<BigInteger> y, int k) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {
            BigInteger term = y.get(i);

            for (int j = 0; j < k; j++) {
                if (i != j) {
                    BigInteger numerator = x.get(j).negate();   // (0 - xj)
                    BigInteger denominator = x.get(i).subtract(x.get(j));
                    term = term.multiply(numerator).divide(denominator);
                }
            }

            result = result.add(term);
        }

        return result;
    }

    public static void main(String[] args) {

        try {
        
            Scanner sc = new Scanner(new File("input.json"));
            StringBuilder input = new StringBuilder();

            while (sc.hasNextLine()) {
                input.append(sc.nextLine());
            }
            sc.close();

            JSONObject obj = new JSONObject(input.toString());
            JSONObject keys = obj.getJSONObject("keys");

            int k = keys.getInt("k");

            List<BigInteger> xValues = new ArrayList<>();
            List<BigInteger> yValues = new ArrayList<>();

            for (String key : obj.keySet()) {
                if (!key.equals("keys")) {

                    JSONObject root = obj.getJSONObject(key);

                    int base = Integer.parseInt(root.getString("base"));
                    String value = root.getString("value");

                    BigInteger x = new BigInteger(key);
                    BigInteger y = new BigInteger(value, base);

                    xValues.add(x);
                    yValues.add(y);
                }
            }

            BigInteger constant = findConstantTerm(xValues, yValues, k);

            System.out.println("Constant Term (c): " + constant);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
