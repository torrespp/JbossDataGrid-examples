import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.csvreader.CsvWriter;


public class CsvWriterFile {

	public static void main(String[] args) throws IOException
	{
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
	String dirName = "/Users/torrespp/borra";  
	// File file = new File("c:\\newfile.txt");
    //File file = new File(dirName + "\\"+ df.format(new Date()) +"_Statistics.csv");
	File file = new File(dirName + "/"+ df.format(new Date()) +"_Statistics.csv");
    if ( !file.exists() )
        file.createNewFile();

    // Use FileWriter constructor that specifies open for appending
    CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');

    //Create Header for CSV
    csvOutput.write("Message Source");
    csvOutput.write("Message Name");
    csvOutput.write("Component");
    csvOutput.write("Occurance");
    csvOutput.write("Message Payload");
    csvOutput.write("Bandwidth (Payload)");
    csvOutput.write("Message Payload with Header");
    csvOutput.write("Bandwidth (Payload with Header)");
    csvOutput.endRecord();
    for (int x=0; x<4 ;x++) {
        csvOutput.write("a");
        csvOutput.write("b");
        csvOutput.write("c");
        csvOutput.write(Integer.toString(1));
        csvOutput.write(Integer.toString(2));
        csvOutput.write(Float.toString(3));
        csvOutput.write(Integer.toString(4));
        csvOutput.write("x");
        csvOutput.endRecord();
    }
    csvOutput.flush();
    csvOutput.close();
	
}
}
