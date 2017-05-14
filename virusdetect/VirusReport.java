
package virusdetect;

/**
 *
 * @author Isura Manchanayake
 */
public class VirusReport {

    private boolean isVirus = false;
    private String md5Hash = null;
    private String detectedFileName;
    private int detectedFileNumber;

    public VirusReport(boolean isVirus, String md5Hash, String detectedFileName, int detectedFileNumber) {
		this.isVirus = isVirus;
		this.md5Hash = md5Hash;
		this.detectedFileName = detectedFileName;
		this.detectedFileNumber = detectedFileNumber;
    }

    @Override
    public String toString() {
    	String str = "";
    	if(this.isVirus) {
    		str += "Virus found!\n";
    	} else {
    		str += "Unable to detect a virus\n";
    	}
		str += "md5 hash: " + this.md5Hash + "\n";
		str += "database file name: " + this.detectedFileName + "\n";
		if(this.isVirus) {
			str += "database file line number: " + this.detectedFileNumber + "\n";
    	} 
		return str;
    }

    public void report() {
    	System.out.println(this);
    }

    public boolean isVirus() {
    	return this.isVirus;
    }

}
