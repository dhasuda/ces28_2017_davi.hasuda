package lab1;

public class Currency {
    private String _name;
    public Currency(String name){
        setName(name);
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Currency) {
            return this._name.equals(((Currency)obj).getName());
        }
        return false;
    }
    
    @Override
    public String toString() {
    		return this._name;
    }
}