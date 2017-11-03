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

    public Object get(String name)    {
    	Object retrievedObj = names.get(name);
    	// usually, every remotely available object will have a automatically generated Proxy and Stub
    	// but here in the fake system only BancoDados has a proxy and Stub
    	if (retrievedObj instanceof StubIBancoDados) 
    		retrievedObj = new ProxyIBancoDados((StubIBancoDados)retrievedObj);
    	return retrievedObj; 
    	}

    public Object set(String name, Object o)
    { return names.put(name,o); }
    
    public void printNames() {
    	System.out.println("Stored names are: ");
    	for ( String key : names.keySet() ) { 
    		 System.out.println( key );
    		}
    }
}// FakeNameService