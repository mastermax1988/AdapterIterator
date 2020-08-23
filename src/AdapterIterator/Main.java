package AdapterIterator;

import java.util.Iterator;

public class Main {
    //private Main() {
    //}


    public static void main(String[] argumente) {
        MultiSet<String> m = new MultiSet<String>();
        
        m.add("Info");
        m.add("macht");
        m.add("Spaß");
        m.add("macht");
        m.add("Spaß");
        m.add("Spaß");
        
        for (String s: m)
            System.out.println(s);
            
        System.out.println();
        
        m.remove("macht");
        m.remove("macht");

        System.out.println(m);
        System.out.println(m.size());

        Iterator<String> it = m.iterator();
        while (it.hasNext())
        {
            var e = it.next();
            System.out.println(e.toString());
        }
        System.out.println();
        System.out.println(m.toArray()[2].toString());
    }
}
