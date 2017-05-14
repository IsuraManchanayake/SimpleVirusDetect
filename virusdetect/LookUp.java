
package virusdetect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isura Manchanayake
 */
public class LookUp {

    private String toLook = null;

    public LookUp(String toLook) {
        this.toLook = toLook;
    }
    
    public VirusReport seek() {
        for(int i = 0; i < 10; i++) {
            String lookIn = "database/VirusShare_" + String.format("%1$05d", i) + ".md5";
            try (BufferedReader br = new BufferedReader(new FileReader(lookIn))) {
                String line;
                int lineNumber = 0;
                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if(line == null ? this.toLook == null : line.equals(this.toLook)) {
                        return new VirusReport(true, toLook, lookIn, lineNumber);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(LookUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return new VirusReport(false, toLook, "database/*.md5" , 0);
    }
}
