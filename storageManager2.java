/*import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class storageManager2 {
	public static final int SYSCAT_RECORD  = 148;
    public static final int DATA_RECORD = 100;
    public static final int SYSCAT_MAX_RECORD  = 13;
    public static final int DATA_MAX_RECORD = 40;
    
    public static  void main (String [] args) {
    	
    	/*
    		String i_file = "/Users/alcanunsal/workspace/2016400105/src/inputFile";
    		String o_file = "/Users/alcanunsal/workspace/2016400105/src/outputFile";
    		String syscat_file = "/Users/alcanunsal/workspace/2016400105/src/systemcat";
    		Scanner readinput;
        try{
        		readinput = new Scanner (new File(i_file));
        		List<String> commands = new ArrayList<>();
                while(readinput.hasNextLine()) {
                		commands.add(readinput.nextLine());
                }
                for(String s : commands) {
                		String[] command = s.split("\\s+");
                		String str_command = command[0] + " " + command[1];
                		if (str_command.equals("create type")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			String type_name = command [2];
                			int num_fields = Integer.parseInt(command[3]);
                			ArrayList<String> fields = new ArrayList<String> ();
                			for(int i=0; i<num_fields; i++) {
                				String field = fillEmptyParts(command[i+4], 12);
                				fields.add(field);
                			}
                			fillEmptyFields(fields,num_fields);
                			createType(type_name,num_fields, fields, out, syscat);
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("delete type")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("2");
                			String type_name = command [2];
                			deleteType(type_name, syscat, out);	
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("list type")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("3");
                			ArrayList<String> types = listAllTypes(syscat, out);
                			for (String type:types) {
                    			byte[] line = (type+"\n").getBytes();
                    			out.write(line);
                    		}
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("create record")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("4");
                			String type_name = command [2];
                			int num_fields = command.length-3;
                			ArrayList<String> fields = new ArrayList<String>();
                			for (int i=0; i<num_fields; i++) {
                				fields.add(command[i+3]);
                			}
                			createRecord(type_name, fields, syscat, out); 
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("delete record")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("5");
                			String type_name = command [2];
                			String primarykey = command[3];
                			deleteRecord3(type_name, primarykey, syscat, out);	
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("update record")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("6");
                			String type_name = command [2];
                			int num_fields = command.length-3;
                			ArrayList<String> fields = new ArrayList<String>();
                			String primarykey = command[3];
                			for (int i=0; i<num_fields; i++) {
                				fields.add(command[i+3]);
                			}
                			updateRecord(type_name,primarykey,fields, syscat, out);
                			syscat.close();
                			out.close();
                		} else if (str_command.equals("search record")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("7");
                			String type_name = command [2];
                			String primary_key = command[3];
                			searchRecord2(type_name,primary_key, syscat, out);
                			out.close();
                		} else if (str_command.equals("list record")) {
                			RandomAccessFile syscat = new RandomAccessFile (new File(syscat_file), "rw");
                			FileOutputStream out = new FileOutputStream (o_file, true);
                			System.out.println("8");
                			String type_name = command [2];
                			ArrayList<String> records = listAllRecords(type_name, syscat, out);
                			for (String record:records) {
                    			byte[] line = (record+'\n').getBytes();
                    			out.write(line);
                    		}
                			syscat.close();
                			out.close();
                		} else {
                			System.out.println("unable to process command: " + str_command);
                		}
                }
        }catch(IOException e) {
            e.getStackTrace();
        } */
/*
    }
    //done
    private static void createType(String type_name, int num_fields, ArrayList<String> fields, FileOutputStream out, RandomAccessFile syscat) throws IOException {
		//check if type_name length is appropriate
		if (type_name.length() >= 15) {
		System.out.println("Couldn't create type: type name "+type_name+ " too long...");
		return;
		}
		//check if field names length is appropriate
		for (String s:fields) {
			if (s.length() > 12) {
				System.out.println("Couldn't create type: field name "+s+ " too long...");
				return;
			}
		}*/
		/*
		 * search the system catalogue, find if type name is added before
		 * find first empty place and add the type name 
		 * search page by page
		*/
/*
		int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
		byte[] pages = new byte[bytes_per_page];
		long catalogue_length = syscat.length();
	 	int cursor_position= 0;
		while(cursor_position<catalogue_length) {
			syscat.seek(cursor_position);
			syscat.read(pages);
			String s = new String(pages, StandardCharsets.UTF_8);
			//System.out.println(s);
			String[]lines = s.split("\n");
			for (String line : lines) {
				String[] row = line.split("\\s+");
				//değişiklik1
				if (row[0].equals("")) {
					continue;
				}
				// end of değişiklik1
				if (type_name.equals(row[0])) {
					System.out.println("Couldn't enter type: Type "+type_name+" is already in the database.");
					return;
				}
			}
			cursor_position+=bytes_per_page;
		}
		syscat.seek(catalogue_length);
		String entry = fillEmptyParts(type_name, 15)+" "+num_fields;
		for (String f:fields) {
			entry += " "+f;
		}
		entry+='\n';
		byte[] entry_byte = entry.getBytes();
		syscat.write(entry_byte);
}
    //done
    private static void deleteType (String type_name, RandomAccessFile syscat, FileOutputStream out) throws IOException {
    	// check if there is any record of that type
    	// find the position of the record you want to delete
    	int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
    	byte[] pages = new byte[bytes_per_page];
    	long catalogue_length = syscat.length();
    	int cursor_position= 0;
    	int record_position = 0;
    	boolean found = false;
    	while(cursor_position<catalogue_length) {
    		syscat.seek(cursor_position);
    		syscat.read(pages);
    		String s = new String(pages, StandardCharsets.UTF_8);
    		String[]lines = s.split("\n");
    		for (int a=0; a<lines.length; a++) {
    			String[] row = lines[a].split("\\s+");
    			if (row[0].equals("")) {
    				continue;
    			}
    			if (type_name.equals(row[0])) {
    				record_position = cursor_position+a*SYSCAT_RECORD;
    				found = true;
    				break;
    			}
    		}
    		if (found) {
    		 	byte[] lastline_byte = null;
    		 	if (record_position==syscat.length()-SYSCAT_RECORD) {
    		 		syscat.setLength(syscat.length()-SYSCAT_RECORD);
    		 		break;
    		 	} else {
    		 		int lastline_start = (int) (syscat.length() - SYSCAT_RECORD);
    		 		lastline_byte = new byte[SYSCAT_RECORD];
    		 		syscat.seek(lastline_start);
    		 		syscat.read(lastline_byte);
    		 		syscat.setLength(syscat.length()-SYSCAT_RECORD);
    		 		syscat.seek(record_position);
    		 		syscat.write(lastline_byte);
    		 		break;
    		 	}
    		}
    		cursor_position+=bytes_per_page;
    		}
    		RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
		int i=1;
		while (typefile_test.length() > 0) {
			File f = new File (type_name+i);
			f.delete();
			typefile_test.close();
			i = i+1;
			typefile_test = new RandomAccessFile (type_name+i, "rw");
		}
		File f = new File (type_name+i);
		f.delete();
		i=i-1;
		typefile_test.close();
    }
    //in progress
    private static ArrayList<String> listAllTypes(RandomAccessFile syscat, FileOutputStream out) throws IOException {
		ArrayList<String> types = new ArrayList<String>();
		int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
		byte[] pages = new byte[bytes_per_page];
		long catalogue_length = syscat.length();
	 	int cursor_position= 0;
	 	Scanner scanLine = null;
		while(cursor_position<catalogue_length) {
			syscat.seek(cursor_position);
			syscat.read(pages);
			String s = new String(pages, StandardCharsets.UTF_8);
			scanLine = new Scanner(s);
			while(scanLine.hasNextLine()){
				String line = scanLine.nextLine();
				types.add(line.substring(0, 15));
			}
			cursor_position+=bytes_per_page;
		}
		Collections.sort(types);
		types.remove(0);
		scanLine.close();
		return types;
}
    //done
    private static ArrayList<String> fillEmptyFields(ArrayList<String> fields, int num_fields) {
		for (int i=num_fields; i<10; i++) {
			fields.add("############");
		}
		return fields;
    }
    //done
    private static String fillEmptyParts(String str, int length) {
    		for (int i=str.length(); i<length; i++) {
    			str = str+" ";
    		}
    		return str;
    }
}
*/

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class storageManager2 {
    public static final int SYSCAT_RECORD  = 148;
    public static final int DATA_RECORD = 50;
    public static final int SYSCAT_MAX_RECORD  = 13;
    public static final int DATA_MAX_RECORD = 40;
    
    public static  void main (String [] args) throws IOException {
    	
    		String i_file = "src/inputFile.txt";
    		String o_file = "outputFile.txt";
    		String syscat_file = "systemcat.txt";
    		Scanner readinput;
    		FileOutputStream out=null;
    		try {
				out = new FileOutputStream (o_file, true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
    		RandomAccessFile syscat;
        //try{
        		readinput = new Scanner (new File(i_file));
        		syscat = new RandomAccessFile (new File(syscat_file), "rw");
        		List<String> commands = new ArrayList<>();
                while(readinput.hasNextLine()) {
                		commands.add(readinput.nextLine());
                }
                for(String s : commands) {
                		String[] command = s.split("\\s+");
                		String str_command = command[0] + " " + command[1];
                		if (str_command.equals("create type")) {
                			System.out.println("1");
                			String type_name = command [2];
                			int num_fields = Integer.parseInt(command[3]);
                			String[] fields = new String [10];
                			for(int i=0; i<num_fields; i++) {
                				String field = fillEmptyParts(command[i+4], 12);
                				fields[i] = field;
                			}
                			fillEmptyFields(fields,num_fields);
                			createType(type_name,num_fields, fields, out, syscat);
                		} else if (str_command.equals("delete type")) {
                			System.out.println("2");
                			String type_name = command [2];
                			deleteType(type_name, syscat, out);	
                		} else if (str_command.equals("list type")) {
                			System.out.println("3");
                			ArrayList<String> types = listAllTypes(syscat, out);
                			for (String type:types) {
                    			byte[] line = (type+"\n").getBytes();
                    			out.write(line);
                    		}
                		} else if (str_command.equals("create record")) {
                			System.out.println("4");
                			String type_name = command [2];
                			int num_fields = command.length-3;
                			ArrayList<String> fields = new ArrayList<String>();
                			for (int i=0; i<num_fields; i++) {
                				fields.add(command[i+3]);
                			}
                			createRecord(type_name, fields, syscat, out); 
                		} else if (str_command.equals("delete record")) {
                			System.out.println("5");
                			String type_name = command [2];
                			String primarykey = command[3];
                			deleteRecord3(type_name, primarykey, syscat, out);		
                		} else if (str_command.equals("update record")) {
                			System.out.println("6");
                			String type_name = command [2];
                			int num_fields = command.length-3;
                			ArrayList<String> fields = new ArrayList<String>();
                			String primarykey = command[3];
                			for (int i=0; i<num_fields; i++) {
                				fields.add(command[i+3]);
                			}
                			updateRecord(type_name,primarykey,fields, syscat, out);
                		} else if (str_command.equals("search record")) {
                			System.out.println("7");
                			String type_name = command [2];
                			String primary_key = command[3];
                			String result = searchRecord2(type_name,primary_key, syscat, out);
                			if(result!=null) {
                				out.write((result+'\n').getBytes());
                			}
                			
                		} else if (str_command.equals("list record")) {
                			System.out.println("8");
                			String type_name = command [2];
                			ArrayList<String> records = listAllRecords(type_name, syscat, out);
                			for (String record:records) {
                    			byte[] line = (record+'\n').getBytes();
                    			out.write(line);
                    		}
                		} else {
                			System.out.println("unable to process command: " + str_command);
                		}
                }
                readinput.close();
     //  }catch(IOException e) {
       //     e.getStackTrace();
      // System.out.println("of");
       // } 
    }
    
    
    private static void createType(String type_name, int num_fields, String[] fields, FileOutputStream out, RandomAccessFile syscat) throws IOException {
    		//check if type_name length is appropriate
    		if (type_name.length() >= 15) {
			System.out.println("Couldn't create type: type name "+type_name+ " too long...");
			return;
    		}
    		//check if field names length is appropriate
    		for (String s:fields) {
    			if (s.length() > 12) {
    				System.out.println("Couldn't create type: field name "+s+ " too long...");
    				return;
    			}
    		}
    		/*
    		 * search the system catalogue, find if type name is added before
    		 * find first empty place and add the type name 
    		 * search page by page
    		*/
    		int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
    		byte[] pages = new byte[bytes_per_page];
    		long catalogue_length = syscat.length();
    	 	int cursor_position= 0;
    		while(cursor_position<catalogue_length) {
    			syscat.seek(cursor_position);
    			syscat.read(pages);
    			String s = new String(pages, StandardCharsets.UTF_8);
    			//System.out.println(s);
    			String[]lines = s.split("\n");
    			for (String line : lines) {
    				String[] row = line.split("\\s+");
    				if (type_name.equals(row[0])) {
    					System.out.println("Couldn't enter type: Type "+type_name+" is already in the database.");
    					return;
    				}
    			}
    			cursor_position+=bytes_per_page;
    		}
    		syscat.seek(catalogue_length);
    		String text = "creating type: "+type_name+" "+num_fields+" ";
    		for (String f:fields) {
    			text += f+" ";
    		}
    		text+= " "+"... DONE";
    		System.out.println(text);
    		String entry = fillEmptyParts(type_name, 15)+" "+num_fields;
    		for (String f:fields) {
    			entry += " "+f;
    		}
    		entry+='\n';
    		byte[] entry_byte = entry.getBytes();
    		syscat.write(entry_byte);
    }
    
    
    private static void deleteType (String type_name, RandomAccessFile syscat, FileOutputStream out) throws IOException {
    	// find the position of the record you want to delete
    	int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
    	byte[] pages = new byte[bytes_per_page];
    	long catalogue_length = syscat.length();
    	int cursor_position= 0;
    	int record_position = 0;
    	while(cursor_position<catalogue_length) {
    		syscat.seek(cursor_position);
    		syscat.read(pages);
    		String s = new String(pages, StandardCharsets.UTF_8);
    		//System.out.println(s);
    		String[]lines = s.split("\n");
    		for (int a=0; a<lines.length; a++) {
    			String[] row = lines[a].split("\\s+");
    			if (type_name.equals(row[0])) {
    				record_position = cursor_position+a*SYSCAT_RECORD;
    				break;
    			}
    		}
    		cursor_position+=bytes_per_page;
    	}
    	//delete record
    	byte[] lastline_byte = null;
    	if (record_position==syscat.length()-SYSCAT_RECORD) {
    		syscat.setLength(syscat.length()-SYSCAT_RECORD);
    	} else {
    		int lastline_start = (int) (syscat.length() - SYSCAT_RECORD);
    		lastline_byte = new byte[SYSCAT_RECORD];
    		syscat.seek(lastline_start);
    		syscat.read(lastline_byte);
    		syscat.setLength(syscat.length()-SYSCAT_RECORD);
    		syscat.seek(record_position);
    		syscat.write(lastline_byte);
    	}
    	RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
    	int i=1;
    	while (typefile_test.length() > 0) {
    		File f = new File (type_name+i);
    		f.delete();
    		typefile_test.close();
    		i = i+1;
    		typefile_test = new RandomAccessFile (type_name+i, "rw");
    	}
    	File f = new File (type_name+i);
    	f.delete();
    	typefile_test.close();
    }

    
    private static ArrayList<String> listAllTypes(RandomAccessFile syscat, FileOutputStream out) throws IOException {
    		ArrayList<String> types = new ArrayList<String>();
    		int bytes_per_page = SYSCAT_RECORD*SYSCAT_MAX_RECORD;
    		byte[] pages = new byte[bytes_per_page];
    		long catalogue_length = syscat.length();
    	 	int cursor_position= 0;
    	 	Scanner scanLine = null;
    		while(cursor_position<catalogue_length) {
    			syscat.seek(cursor_position);
    			syscat.read(pages);
    			String s = new String(pages, StandardCharsets.UTF_8);
    			scanLine = new Scanner(s);
    			while(scanLine.hasNextLine()){
    				String line = scanLine.nextLine();
    				types.add(line.substring(0, 15));
    			}
    			cursor_position+=bytes_per_page;
    		}
    		Collections.sort(types);
    		if (types.size()>= 1) {
        		types.remove(0);  			
    		}
    		if (scanLine != null) {
        		scanLine.close();
    		}
    		return types;
    }
    
 
    private static void createRecord(String type_name,ArrayList<String> fields, RandomAccessFile syscat, FileOutputStream out) throws IOException {
    		// check if the type exists
    		ArrayList<String> allTypes = listAllTypes(syscat, out);
    		if (!allTypes.contains(fillEmptyParts(type_name,15))) {
    			System.out.println("Couldn't create record: Type name "+ type_name + " does not exist in the system.");
    		}
    		// find the file to add
    		File typefile_test = new File (type_name+"1", "rw");
    		int i=1;
    		while (typefile_test.exists()) {
    			i++;
    			typefile_test = new File (type_name+i);
    		}
    		String primarykey=fields.get(0);
    		RandomAccessFile typefile=null;
    		Scanner scanLine = null;
    		// check if there is a record with the same primary key
    		for (int j=1; j<=i; j++) {
    			typefile = new RandomAccessFile (type_name+j, "rw");
    			int bytes_per_page = DATA_MAX_RECORD*DATA_RECORD;
        		byte[] pages = new byte[bytes_per_page];
        		long typefile_length = typefile.length();
        	 	int cursor_position= 0;
        		while(cursor_position<typefile_length) {
        			typefile.seek(cursor_position);
        			typefile.read(pages);
        			String s = new String(pages, StandardCharsets.UTF_8);
        			scanLine = new Scanner(s);
        			while(scanLine.hasNextLine()){
        				String line = scanLine.nextLine();
        				String[] row = line.split("\\s+");
        				if (row.length >0 && row[0].equals(primarykey)) {
        					System.out.println("Couldn't enter record: A record with record id "+primarykey+" is already in the database.");
        					typefile.close();
        					scanLine.close();
        					return;
        				}
        			}
        			cursor_position+=bytes_per_page;
        		}
    		}
    		// add the record
    		typefile = new RandomAccessFile (type_name+i, "rw");
    		if (typefile.length()>=40*12*DATA_RECORD) {
    			typefile.close();
    			typefile = new RandomAccessFile (type_name+(i+1), "rw");
    		}
    		long typefile_length=typefile.length();
    		typefile.seek(typefile_length);
    		String text = "creating record for "+type_name+": ";
    		for (String field:fields) {
    			text += field+" ";
    		}
    		text+= " "+"... DONE";
    		System.out.println(text);
    		String record = fields.get(0);
    		for (int t=1; t<fields.size(); t++) {
    			record += " "+fields.get(t);
    		}
    		record = fillEmptyParts(record,49);
    		record+='\n';
    		byte[] record_byte = record.getBytes();
    		typefile.write(record_byte);
    		typefile.close();
    }
    
    
    
    private static void deleteRecord3 (String type_name, String primarykey, RandomAccessFile syscat, FileOutputStream out) throws IOException {
		if (searchRecord2(type_name, primarykey, syscat, out)==null) {
		System.out.println("Couldn't delete record: Record "+ type_name+ " " + primarykey+ " not in database.");
		return;
	}
		// find the file number
		RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
		int i=1;
		while (typefile_test.length() > 0) {
			i = i+1;
			typefile_test = new RandomAccessFile (type_name+i, "rw");
		}
		File f = new File (type_name+i);
		f.delete();
		i=i-1;
		typefile_test.close();
		// find the position of the record to be changed   		
		boolean found = false;
		//RandomAccessFile typefile = null;
		int filenum = 0;
		for (int j=1; j<=i; j++) {
			filenum++;
			RandomAccessFile typefile = new RandomAccessFile (type_name+j, "rw");
			int bytes_per_page = DATA_MAX_RECORD*DATA_RECORD;
			byte[] pages = new byte[bytes_per_page];
			long typefile_length = typefile.length();
			int cursor_position= 0;
			int record_position = 0;
			while(cursor_position<typefile_length) {
			typefile.seek(cursor_position);
			typefile.read(pages);
			String s = new String(pages, StandardCharsets.UTF_8);
			String[]lines = s.split("\n");
			for (int a=0; a<lines.length; a++) {
				String[] row = lines[a].split("\\s+"); 
				if (primarykey.equals(row[0])) {
					record_position = cursor_position+a*DATA_RECORD;
					found = true;
					break;
				}
			}
			if (found) {
				RandomAccessFile lastfile = null;
				if (record_position == typefile.length()-DATA_RECORD && filenum == i) {
					typefile.setLength(typefile.length()-DATA_RECORD);
					if (typefile.length() == 0) {
						typefile.close();
						File typefile_to_delete = new File (type_name+filenum);
						System.out.println(typefile_to_delete.getName());
						typefile_to_delete.delete();
						break;
					} 
				} else if (record_position == typefile.length()-DATA_RECORD) {
					byte[] lastline = new byte[DATA_RECORD];
					lastfile = new RandomAccessFile (type_name+(i), "rw");
					lastfile.seek(lastfile.length()-DATA_RECORD);
					lastfile.read(lastline);
					lastfile.setLength(lastfile.length()-DATA_RECORD);
					typefile.seek(record_position);
					typefile.write(lastline);
					typefile.close();
					lastfile.close();
					if (typefile.length() == 0) {
						File typefile_to_delete = new File (type_name+filenum);
						System.out.println(typefile_to_delete.getName());
						typefile_to_delete.delete();
						break;
					} else if (lastfile.length() == 0) {
						File typefile_to_delete = new File (type_name+i);
						System.out.println(typefile_to_delete.getName());
						typefile_to_delete.delete();
						break;
					} else {
						break;
					}
				} else {
					byte[] lastline = new byte[DATA_RECORD];
					typefile.seek(typefile.length()-DATA_RECORD);
					typefile.read(lastline);
					typefile.seek(record_position);
					typefile.write(lastline);
					typefile.setLength(typefile.length()-DATA_RECORD);
					int length = (int) typefile.length();
					typefile.close();
					if (length == 0) {
						File typefile_to_delete = new File (type_name+filenum, "rw");
						System.out.println(typefile_to_delete.getName());
						typefile_to_delete.delete();
						break;
					} else {
						break;
					}
				}
			}
			cursor_position += DATA_RECORD*DATA_MAX_RECORD;
		}
		
	}
}
    
   
    
    private static void updateRecord (String type_name, String primarykey, ArrayList<String> fields, RandomAccessFile syscat, FileOutputStream out) throws IOException {
		if (searchRecord2(type_name, primarykey, syscat, out)==null) {
			System.out.println("Couldn't find record: Record "+ type_name+ " " + primarykey+ " not in database.");
			return;
		}	
		// find the file number
		RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
		int i=1;
		while (typefile_test.length() > 0) {
			i = i+1;
			typefile_test = new RandomAccessFile (type_name+i, "rw");
		}
		File f = new File (type_name+i);
		f.delete();
		i=i-1;
		typefile_test.close();
		/*File typefile_test = new File (type_name+"1", "rw");
		int i=1;
		while (typefile_test.length() > 0) {
			i++;
			typefile_test = new File (type_name+i, "rw");
		}*/
		// find the position of the record to be changed
		boolean found = false;
		RandomAccessFile typefile=null;
		for (int j=1; j<=i; j++) {
			typefile = new RandomAccessFile (type_name+j, "rw");
			int bytes_per_page = DATA_MAX_RECORD*DATA_RECORD;
				byte[] pages = new byte[bytes_per_page];
				long typefile_length = typefile.length();
				int cursor_position= 0;
				int record_position = 0;
				while(cursor_position<typefile_length) {
					typefile.seek(cursor_position);
					typefile.read(pages);
					String s = new String(pages, StandardCharsets.UTF_8);
					String[]lines = s.split("\n");
					for (int a=0; a<lines.length; a++) {
						String[] row = lines[a].split("\\s+");
						if (primarykey.equals(row[0])) {
							record_position = cursor_position+a*DATA_RECORD;
							found = true;
							break;
						}
					}
					cursor_position += DATA_RECORD*DATA_MAX_RECORD;
				}
				if (found) {
    				String newrecord = fields.get(0);
    				for (int p=1; p<fields.size(); p++) {
    					newrecord += " "+fields.get(p);
    				}
    				newrecord = fillEmptyParts(newrecord, 49);
    				newrecord+='\n';
					typefile.seek(record_position);
    				typefile.write(newrecord.getBytes());
    				break;
				}			
		}
		typefile.close();
    }

    
  
    private static String searchRecord2 (String type_name, String primarykey, RandomAccessFile syscat, FileOutputStream out) throws IOException {
		// check if type exists in the database
		ArrayList<String> allTypes = listAllTypes(syscat, out);
		if (!allTypes.contains(fillEmptyParts(type_name,15))) {
			System.out.println("Couldn't search for record: Type name "+ type_name + " does not exist in the system catalogue.");
		}
		// find the file to add
		RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
		int i=1;
		while (typefile_test.length()>0) {
			typefile_test.close();
			i=i+1;
			typefile_test = new RandomAccessFile (type_name+i, "rw");
		}
		File f = new File (type_name+i);
		f.delete();
		i=i-1;
		typefile_test.close();
		RandomAccessFile typefile=null;
		Scanner scanLine = null;
		
		// check if there is a record with the same primary key
		for (int j=1; j<=i; j++) {
			typefile = new RandomAccessFile (type_name+j, "rw");
			int bytes_per_page = DATA_MAX_RECORD*DATA_RECORD;
			byte[] pages = new byte[bytes_per_page];
			long typefile_length = typefile.length();
			int cursor_position= 0;
			while(cursor_position<typefile_length) {
				typefile.seek(cursor_position);
				typefile.read(pages);
				String s = new String(pages, StandardCharsets.UTF_8);
				scanLine = new Scanner(s);
				while(scanLine.hasNextLine()){
					String line = scanLine.nextLine();
					String[] row = line.split("\\s+");
					if (row.length >0 && row[0].equals(primarykey)) {
						scanLine.close();
						typefile.close();
						return line;	
					}
				}
				cursor_position+=bytes_per_page;
			}
		}
	return null;
    }
    		
    
    private static ArrayList<String> listAllRecords(String type_name, RandomAccessFile syscat, FileOutputStream out) throws IOException {
    		// check if type exists in the database
    		ArrayList<String> allTypes = listAllTypes(syscat, out);
    		if (!allTypes.contains(fillEmptyParts(type_name,15))) {
    			System.out.println("Couldn't search for record: Type name "+ type_name + " does not exist in the system catalogue.");
    		}
    		// find the file to add
    		RandomAccessFile typefile_test = new RandomAccessFile (type_name+"1", "rw");
    		int i=1;
    		while (typefile_test.length() > 0) {
    			System.out.println("a");
    			i = i+1;
    			typefile_test = new RandomAccessFile (type_name+i, "rw");
    		}
    		System.out.println("b");
    		File f = new File (type_name+i);
    		f.delete();
        	if (i != 1) {
        		System.out.println("c");
        		i=i-1;
        	}
    		typefile_test.close();
    		typefile_test = new RandomAccessFile (type_name+i, "rw");
    		if (i==1 && typefile_test.length()==0) {
    			System.out.println("Couldn't list records: There are no records for type " + type_name);
    			ArrayList<String> emptylist = new ArrayList<String>();
    			typefile_test.close();
    			System.out.println("d");
    			return emptylist;
    		}
    		typefile_test.close();
    		// check if there is a record with the same primary key
    		RandomAccessFile typefile = null;
    		ArrayList<String> records = new ArrayList<String>();
    		Scanner scanLine = null;
    		System.out.println("e");
    		for (int j=1; j<=i; j++) {
    			System.out.println("f");
    			typefile = new RandomAccessFile (type_name+j, "rw");
    			int bytes_per_page = DATA_MAX_RECORD*DATA_RECORD;
    			byte[] pages = new byte[bytes_per_page];
    			long typefile_length = typefile.length();
    			int cursor_position= 0;
    			while(cursor_position<typefile_length) {
    				System.out.println("g");
    				typefile.seek(cursor_position);
    				typefile.read(pages);
    				String s = new String(pages, StandardCharsets.UTF_8);
    				scanLine = new Scanner(s);
    				while(scanLine.hasNextLine()){
    					System.out.println("h");
    					String line = scanLine.nextLine();
    					records.add(line);
    				}
    				cursor_position+=bytes_per_page;
    			}
    			System.out.println("i");
    			typefile.close();
    			scanLine.close();
    		}
    		System.out.println("j");
    		Collections.sort(records);
    		if (records.size()>=1) {
    			System.out.println("k");
        		records.remove(0);
    		}
    		System.out.println("l");
    		return records;
    }
    
    
    private static String[] fillEmptyFields(String[] fields, int num_fields) {
		for (int i=num_fields; i<10; i++) {
			fields[i]="############";
		}
		return fields;
    }
 
    private static String fillEmptyParts(String str, int length) {
    		for (int i=str.length(); i<length; i++) {
    			str = str+" ";
    		}
    		return str;
    }
}

