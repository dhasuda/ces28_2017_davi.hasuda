package Infraestrutura;
import java.util.HashMap;
import java.lang.String;

public enum FakeNameService
{
    INSTANCE;

    // instance vars, constructor
    private final HashMap<String, Object> names = new HashMap<String, Object>();

    FakeNameService(){ }

    // Static getter
    public static FakeNameService getInstance()
    { return INSTANCE; }

    public Object get(String name)
    { return names.get(name); }

    public Object set(String name, Object o)
    { return names.put(name,o); }
    
    public void printNames() {
    	System.out.println("Stored names are: ");
    	for ( String key : names.keySet() ) { 
    		 System.out.println( key );
    		}
    }
}// FakeNameService