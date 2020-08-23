package AdapterIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MultiSetIterator<E> implements Iterator<E> {
    private MultiSet<E> multiSet;
    private Iterator<E> keyItr;
    private E current;
    private int nr;
    private int max;
      
    public MultiSetIterator(MultiSet<E> m) { 
        multiSet = m;
        keyItr   = m.toSet().iterator();
        current  = null;
        nr       = 0;
        max      = 0;
    } 
      
    @Override
    public boolean hasNext() {
        // Code korrigieren.
        //return false;
        if(nr<max)
            return true;
        return keyItr.hasNext();
    } 
    
    @Override
    public E next() {  
        // Code korrigieren.
        if(nr==max)
        {
            current = keyItr.next();
            nr = 1;
            max = multiSet.get(current);
            return current;
        }
        nr++;
        return current;
    } 
      
    @Override
    public void remove() { 
        // Sehr schwierig. Man kann sich ums Loeschen druecken, indem man
        // jedes Mal einen Fehler erzeugt.

        throw new UnsupportedOperationException(); 
    }
}
