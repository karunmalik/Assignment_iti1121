
/**
 * @author Marcel Turcotte
 *
 * a queue interface for generic elements <E>
 * 
 * @param <E>
 */
public interface Queue<E> {
    public boolean isEmpty();
    public void enqueue( E o );
    public E dequeue();
}