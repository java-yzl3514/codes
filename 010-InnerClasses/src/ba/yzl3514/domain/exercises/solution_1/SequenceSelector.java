package ba.yzl3514.domain.exercises.solution_1;

/**
 * Bu sınıfın implementasyonunu devam ettiriniz.
 *
 * @author Onder Sahin
 *
 */
public class SequenceSelector implements Selector{

    private Sequence sequence;

    public SequenceSelector(Sequence sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean end() {
        return false;
    }

    @Override
    public Object current() {
        return null;
    }

    @Override
    public void next() {

    }

}
