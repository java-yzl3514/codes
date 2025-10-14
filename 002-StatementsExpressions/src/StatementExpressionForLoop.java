/**
 * @author Onder Sahin
 */
/* Aşağıdaki for döngüsünü StatementExpression açısından değerlendiriniz
   Aşağıdaki for döngüsü yazımı problem çözümlerinde tercih edilmez. Okunaklılığı/algıyı
   bozan bir yazım tarzıdır. Burada amaç : ForInit ve ForUpdate kısımları için StatementExpression ve
   birden fazla StatementExpression kullanımını göstermektir.
 */
public class StatementExpressionForLoop {

    public static void main(String[] args) {

        int i = 10;
        for (foo(); i > 0; System.out.println(i), i--, foo()) ;

        for (int k = 1, j = 10; k < j ; k++, j--) {
            System.out.printf("k = %d,  j=%d%n", k, j);
        }

    }

    public static void foo() {
        System.out.println("foo()");
    }


}

