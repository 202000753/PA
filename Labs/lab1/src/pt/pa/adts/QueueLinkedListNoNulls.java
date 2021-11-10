package pt.pa.adts;

/**
 *  Nuno Reis
 *  nº 202000753
 */

public class QueueLinkedListNoNulls extends QueueLinkedList{
    public QueueLinkedListNoNulls() {
        super();
    }

    @Override
    public void enqueue(Object element) {
        if (element == null) throw new NullNotAllowedException();

        super.enqueue(element);
    }
}
