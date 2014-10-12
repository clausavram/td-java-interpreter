package structure.type;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Claudiu on 10/11/2014
 */
public class Type {

    protected Type() { }

    public String getName() {
        throw new NotImplementedException();
    }

    public boolean isPrimitive() {
        return false;
    }

    public Type fromName(String typeName) {
        throw new NotImplementedException();
    }
}
