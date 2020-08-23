
package AdapterIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MultiSet<E> extends AbstractCollection<E> {
    private HashMap<E, Integer> map;
    private int count;
    
    public MultiSet() {
        map   = new HashMap<E, Integer>();
        count = 0;
    }
    
    public MultiSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public boolean add(E e) {
        if(map.containsKey(e))
            map.put(e, map.get(e) + 1);
        else
            map.put(e, 1);
            
        count++;
            
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;

        Iterator<? extends E> itr = c.iterator();
        
        while (itr.hasNext())
            result = result || add(itr.next());
            
        return result;
    }

    @Override 
    public Iterator<E> iterator() {        
        return new MultiSetIterator<E>(this);
    }
    
    @Override
    public int size() {
        // Code korrigieren.
        return count;
    }

    public int get(E e)
    {
        return map.get(e);
    }
    public Set<E> toSet() {
        // Code korrigieren.
        return map.keySet();
        //return Collections.emptySet();
    }
    
    @Override    
    public String toString() {
        String result = "";
        
        for (E e: map.keySet())
            for (int i = 0; i < map.get(e); i++)
                result += e.toString();
                
        return result;
    }


    @Override
    public boolean contains(Object o) {
        // Code ergaenzen.
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        if(!map.containsKey(o))
            return false;
        if(map.get(o) == 1)
            map.remove(o);
        else
            map.put((E)o,map.get(o)-1);
        count--;
        return true;
    }

   

    @Override
    public void clear() {
        count = 0;
        map.clear();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // Code ergaenzen.
        for(var e : c)
        {
            if (!map.containsKey(e))
                return false;
        }
        return true;
    }

    @Override 
    public boolean isEmpty() {        
        // Code ergaenzen.
        return count==0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // Code ergaenzen.
        boolean ret=false;
        for(var e : c)
            ret = ret || remove(e);
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean ret = false;
        Iterator<E> it = iterator();
        while (it.hasNext())
        {
            if(!c.contains(it))
            {
                ret = true;
                it.remove();
            }
        }
        return ret;
    }
    
    @Override    
    public Object[] toArray()
    {
        // Code ergaenzen.
        Object[] o = new Object[count];
        int index = 0;
        Iterator<E> it = iterator();
        while (it.hasNext())
        {
            o[index] = it.next();
            index++;
        }

        return o;
    }
   
    /*
     * Sehr trickreiche Methode, zu schwierig fuer d).
     */    
    @Override    
    public <T> T[] toArray(T[] a) {
        T[] b = (T[]) java.lang.reflect.Array.newInstance(
                          a.getClass().getComponentType(), count);
        int index = 0;
                          
        for (E e: map.keySet())
            for (int i = 0; i < map.get(e); i++)
                b[index++] = (T) e;
                
        return b;
    }
}
