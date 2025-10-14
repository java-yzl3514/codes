/**
 * @author Onder Sahin
 */
public class LocalVariableLimitMethodGenerator {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int variableCount = 25_000;

        sb.append(" public static void violateCodeLength(){\n");

        for (int i = 0; i < variableCount; i++) {
            sb.append(" int v").append(i).append("=").append(i).append(";\n");
        }

        sb.append("}");
        System.out.println(sb);
    }
}
