package virusdetect;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isura Manchanayake
 */
public class VirusDetect {

    public static void detectVirus(File file) throws NoSuchAlgorithmException {
        MessageDigest algorithm = MessageDigest.getInstance("md5");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DigestInputStream dis = new DigestInputStream(bis, algorithm);

            while (dis.read() != -1) {
            }

            // md5 digestion
            byte[] hash = algorithm.digest();

            // to hex convert 
            final StringBuilder builder = new StringBuilder();
            for (byte b : hash) {
                builder.append(String.format("%02x", b));
            }
            String md5Hash = builder.toString();

            LookUp lookUp = new LookUp(md5Hash);
            VirusReport virusReport = lookUp.seek();
            virusReport.report();

        } catch (IOException ex) {
            System.out.println("Error while reading ");
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String folderPath = (args.length > 0) ? args[0] : "virus_folder";

        File[] files = new File(folderPath).listFiles();
        
        if(files == null || files.length == 0) {
            System.out.println(args[0] + " does not contain any file");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath() + ": checking for viruses...");
                detectVirus(file);
            }
        }

    }
}
