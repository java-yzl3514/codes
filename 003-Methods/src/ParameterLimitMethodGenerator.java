/**
 * @author Onder Sahin
 */
public class ParameterLimitMethodGenerator {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(" public static void test255ParameterMethod(");
        for(int i = 1; i <= 255; i++){
            sb.append("int p").append(i);
            if(i < 255){
                sb.append(", ");
            }
            if(i % 10 == 0){
                sb.append("\n");
            }
        }
        sb.append(") { } \n\n\n");

        sb.append("test255ParameterMethod(");

        for(int i = 1; i <= 255; i++){
            sb.append(i);
            if(i < 255){
                sb.append(", ");
            }
            if(i % 10 == 0){
                sb.append("\n");
            }
        }

        sb.append(");");


        System.out.println(sb);
    }
}
