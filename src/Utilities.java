import java.io.*;

/**
 * User: Ty
 * Date: 6/14/12
 * Time: 10:19 PM
 */
public class Utilities {
    public static String fileToString(File file) throws IOException {
        FileInputStream fstream = new FileInputStream(file);

        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        String strLine;
        while ((strLine = br.readLine()) != null)   {
            sb.append(strLine+"\n");
        }
        in.close();
        return sb.toString();
    }

    public static void stringToFile(String input, File file) throws IOException {
        FileWriter fileStream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fileStream);
        out.write(input);
        out.close();
    }
}
