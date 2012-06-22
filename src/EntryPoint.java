import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * User: Ty
 * Date: 6/14/12
 * Time: 10:17 PM
 */
public class EntryPoint {
    
    public static void main(String... args) throws IOException{
        String path;
        if(args.length>0){
            path = args[0];
        }
        else{
            path = "./";
        }
        
        List<CoffeeFile> files = FileRecorder.findFiles(new File(path+"/src/"));
        Sorter.sort(files);

        String start = Utilities.fileToString(new File(path+"html/temp_start.html"));
        String end   = Utilities.fileToString(new File(path+"html/temp_end.html"));

        StringBuilder sb = new StringBuilder();
        for(CoffeeFile f: files){
            String sc_start = "\t\t<script src=\"file:///";
            String sc_end   = "\"></script>";
            sb.append(sc_start+f.path.getAbsolutePath().replace("src","bin").replace(".coffee",".js")+sc_end+"\n\n");
        }
        
        String total = start+sb.toString()+end;
        System.out.print(total);
    }
}
