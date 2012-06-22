import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Ty
 * Date: 6/14/12
 * Time: 10:24 PM
 */
public class FileRecorder {
    private static final Pattern pattern = Pattern.compile("class +(\\w+)( +extends +(\\w+))?");
    
    private static List<CoffeeFile> fileList = new ArrayList<CoffeeFile>();

    public static List<CoffeeFile> findFiles(File path){
       for(File f: path.listFiles()){
           if(f.isDirectory()){
               findFiles(f);
           }
           else if(f.isFile()){
               if(f.getName().contains(".coffee") && !f.getName().startsWith(".")){
                parseFile(f);
               }
           }
       }
       return fileList;
    }

    public static void parseFile(File f){
        try{
            String file = Utilities.fileToString(f);

            Matcher matcher = pattern.matcher(file);
            matcher.find();

            String cName;
            String eName;
            try{
                cName = matcher.group(1).trim();  // The class Name
                eName = matcher.group(3);         // What it extends
                if(eName != null){
                    eName = eName.trim();
                }
                fileList.add(new CoffeeFile(true,f,cName,eName));
                return;
            }
            catch(Exception e){
                fileList.add(new CoffeeFile(false,f,null,null));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
