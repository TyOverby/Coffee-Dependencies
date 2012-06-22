import java.util.List;

/**
 * User: Ty
 * Date: 6/14/12
 * Time: 2:42 AM
 */
public class Sorter {

    // This is the most fucking retarted sort I've ever written, but it was
    // early in the morning, and I can't be assed to make a better one
    public static List<CoffeeFile> sort(List<CoffeeFile> files){
        while(!isSorted(files)){
            for(int i = 0; i < files.size(); i++){
                for(int k = i+1; k < files.size(); k++){
                    CoffeeFile f1 = files.get(i);
                    CoffeeFile f2 = files.get(k);
                    if(!f2.isClass){
                        swap(files,i,k);
                    }else{
                        if(f1.ext!=null){
                            if(f1.ext.equals(f2.name)){
                                swap(files,i,k);
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<files.size();i++){
            if(files.get(i).path.getName().contains("main")){
                files.add(files.remove(i));
            }
        }

        return files;
    }
    
    private static boolean isSorted(List<CoffeeFile> files){
        for(int i=0;i<files.size();i++){
            if(i<getClassPos(files,files.get(i).ext)){
                return false;
            }
        }
        
        return true;
    }
    
    private static int getClassPos(List<CoffeeFile> files, String classname){
        int count=0;
        for(CoffeeFile file:files){
            if(file.isClass){
                if(file.name.equals(classname)){
                    return count;
                }
            }
            count++;
        }
        return -1;
    }
    
    private static void swap(List list, int pos1, int pos2){
        Object one = list.get(pos1);
        list.set(pos1,list.get(pos2));
        list.set(pos2,one);
    }
}
