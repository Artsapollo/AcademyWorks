package Lesson9;

public class MathematicUtil {

    static int mult(int a, int b) throws Exception {
        int result = a * b;

        if (a == b) throw new Exception("Numbers are equals");
        if (a == 0 || b == 0) throw new CheckException("Numbers are equals 0");

        return result;
    }

    static int div(int a, int b) throws UncheckException {
        int result = a / b;

        if (b == 0) throw new UncheckException("B equals 0");

        return result;

    }

}
