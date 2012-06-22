import java.io.File;

/**
 * User: Ty
 * Date: 6/14/12
 * Time: 10:18 PM
 */
public class CoffeeFile {
    public final boolean isClass;
    public final File path;
    public final String name;
    public final String ext;
    
    public CoffeeFile(boolean isClass, File path, String name, String ext){
        this.isClass = isClass;
        this.path = path;
        this.name = name;
        this.ext  = ext;
    }
    
    public String toString(){
        String toReturn = path.getName();
            toReturn += "\n\tn: " + name;
            toReturn += "\n\te: " + ext;
        return toReturn;
    }
}
