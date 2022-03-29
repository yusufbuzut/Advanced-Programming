package prelab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.Line;

public class Data_Preprocess {
	static ArrayList<Image> arrlist;
	private static Formatter output;
	
	public static void main(String[] args) {
		//prelab();
		inlab();
	}
	public static void inlab() {
		File directory = new File("src/"+ "processed_directory");
		directory.mkdir();
		String[] pathNames = getFilenames();
		
		
		for (String pathName : pathNames) {
			if (checkRegex(pathName)) {
				
				System.out.printf("Processing file: %s\n", pathName );
				ArrayList<Image> arrList = inlabHelper("src/label_directory/" + pathName);
				processFile( arrList ,  pathName , directory.getName());
				int labelCount = lineNumberCalculator("src/label_directory/" +pathName);
				outputFormat( arrList, labelCount,  pathName);
			}
			else {
				continue;
			}
		}
	}
	public static void outputFormat(ArrayList<Image> arrList, int labelCount, String pathName) {
		int validLabelCount = 0;
		for (Image image : arrList) {
			validLabelCount += (image.getNum_objects()+1);
		}
		System.out.printf("Total Labels count: %d\n", labelCount);
		System.out.printf("Valid Labels count: %d\n", validLabelCount);
		System.out.printf("Invalid Labels count: %d\n ", labelCount-validLabelCount);
		System.out.printf("Successfully created: %s\n", "processed_"+pathName);
	}
	public static void processFile(ArrayList<Image> arrList , String pathName , String dirName) {
		try{
            output = new Formatter("src/" + dirName +"/processed_"+pathName);
                }
        catch(Exception e){
            System.out.println(e);
        }
        StringBuilder str = new StringBuilder();
        for (Image i : arrList) {
            str.append(i);
        }
        
        output.format("%s",str);
        output.close();
	}
	public static int lineNumberCalculator(String fileName)  {
		BufferedReader reader;
		int lines = 0;
		try {
			reader = new BufferedReader(new FileReader(fileName));
		
			
			try {
				while (reader.readLine() != null) 
				lines++;
				reader.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return lines;
		
	}
	public static boolean checkRegex(String filename) {
		
		Pattern exp = Pattern.compile(".*(\\D[1-9]|[12][0-9]|3[01])-(4|5)-[12][0-9]{3}");
		Matcher matcher = exp.matcher(filename);
		if(matcher.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static String[] getFilenames() {
		System.out.println("Enter file or directory name:");
		Scanner userinput = new Scanner(System.in);
		String dirname = userinput.nextLine();
		File dir = new File("src/"+ dirname);
		
		String[] pathnames = dir.list();
		return pathnames;
	}
	public static ArrayList<Image> inlabHelper(String pathname) {
		Path path = Paths.get(pathname);
		File we = path.toFile();
		ArrayList<Image> arrlist = new ArrayList<>();
		try(Scanner input = new Scanner(we)){
			while(input.hasNext()) {
				
				String w = input.nextLine();
				
				if (processLabel(w)) {
									
					
					String y = w.replaceAll("\\s+"," ");
					String[] list = y.split(" ");
					int[] listMade = listMaker(list);
					if (arrlist == null) {
						arrlist.add(new Image(listMade[0],listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]));
					}
					else {
						int size = arrlist.size();
						int sizechecker = 0;
						for(Image i : arrlist ) {		
							
							if( i.getImg_id() == listMade[0]) {
								Image.addObject(i, listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]);
							}
							else {
								sizechecker +=1;
								continue;
							}
						}
						if (sizechecker == size) {
							arrlist.add(new Image(listMade[0],listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]));
						}
					}
					
					
				}
				else {
					continue;
				}
			}
			
		  
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arrlist;
	}
	
	 static boolean processLabel(String line) {
		
		 Pattern exp = Pattern.compile("[iI]mg_[iI][dD]:\\s+\\d{1,4}\\b");
		 Pattern exp2 = Pattern.compile("[iI]mage_[iI][dD]:\\s+\\d{1,4}\\b");				
		 Pattern exp3 = Pattern.compile("[lL]abel:\\s+\\d{1,3}\\b");

	     Pattern exp5 = Pattern.compile("[xX]1:\\s+\\d{1,4}\\b");
		 Pattern exp6 = Pattern.compile("[xX][mM]in:\\s+\\d{1,4}\\b");
		 Pattern exp7 = Pattern.compile("[xX][Mm]ax:\\s+\\d{1,4}\\b");
		 Pattern exp8 = Pattern.compile("[xX]2:\\s+\\d{1,4}\\b");
		 Pattern exp9 = Pattern.compile("[yY]1:\\s+\\d{1,4}\\b");
		 Pattern exp10 = Pattern.compile("[yY][mM]in:\\s+\\d{1,4}\\b");
		 Pattern exp11 = Pattern.compile("[yY]2:\\s+\\d{1,4}\\b");
		 Pattern exp12 = Pattern.compile("[yY][mM]ax:\\s+\\d{1,4}\\b");
		 
		 Matcher matcher = exp.matcher(line);
		 Matcher matcher2 = exp2.matcher(line);
		 Matcher matcher3 = exp3.matcher(line);
		 Matcher matcher5 = exp5.matcher(line);
		 Matcher matcher6 = exp6.matcher(line);
		 Matcher matcher7 = exp7.matcher(line);
		 Matcher matcher8 = exp8.matcher(line);
		 Matcher matcher9 = exp9.matcher(line);
		 Matcher matcher10 = exp10.matcher(line);
		 Matcher matcher11 = exp11.matcher(line);
		 Matcher matcher12 = exp12.matcher(line);
		 if ((matcher.find() || matcher2.find()) 
				 && matcher3.find()
				 && (matcher5.find() || matcher6.find())
				 && (matcher7.find() || matcher8.find())
				 && (matcher9.find() || matcher10.find())
				 && (matcher11.find() || matcher12.find())){
			 return true;
		 }
			 
		 else {
			 return false;
		 }
		
		 
	 }
	 static int[] listMaker(String[] s) {
		 int[] made = new int[s.length/2];
		 for (int i =0 ; i < s.length ; i +=2) {
			 if( s[i].matches("[iI]mg_[iI][dD]:||[iI]mage_[iI][dD]:")) {
				 made[0] = Integer.parseInt(s[i+1]);
			 }
			 else if( s[i].matches("[lL]abel:")) {
				 made[1] = Integer.parseInt(s[i+1]);
			 }
			else if( s[i].matches("[xX]1:||[xX][mM]in:")) {
				made[2] = Integer.parseInt(s[i+1]);		 
			}
			else if( s[i].matches("[xX]2:||[xX][mM]ax:")) {
				made[3] = Integer.parseInt(s[i+1]);
			}
			else if( s[i].matches("[yY]1:||[yY][mM]in:")) {
				made[4] = Integer.parseInt(s[i+1]);
			}
			else if( s[i].matches("[yY]2:||[yY][mM]ax:")) {
				made[5] = Integer.parseInt(s[i+1]);
			}
		 }
		 
		
		 return made;
	 }
	 
	 public static void prelab() {
		 	Path path = Paths.get("src/labels.txt");
			File we = path.toFile();
			ArrayList<Image> arrlist = new ArrayList<>();
			try(Scanner input = new Scanner(we)){
				while(input.hasNext()) {
					
					String w = input.nextLine();
					
					if (processLabel(w)) {
										
						
						String y = w.replaceAll("\\s+"," ");
						String[] list = y.split(" ");
						int[] listMade = listMaker(list);
						if (arrlist == null) {
							arrlist.add(new Image(listMade[0],listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]));
						}
						else {
							int size = arrlist.size();
							int sizechecker = 0;
							for(Image i : arrlist ) {		
								
								if( i.getImg_id() == listMade[0]) {
									Image.addObject(i, listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]);
								}
								else {
									sizechecker +=1;
									continue;
								}
							}
							if (sizechecker == size) {
								arrlist.add(new Image(listMade[0],listMade[1],listMade[2],listMade[3],listMade[4],listMade[5]));
							}
						}
						
						
					}
					else {
						continue;
					}
				}
				
			  
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try{
	            output = new Formatter("labels_processed.txt");
	                }
	        catch(Exception e){
	            System.out.println(e);
	        }
	        StringBuilder str = new StringBuilder();
	        for (Image i : arrlist) {
	            str.append(i);
	        }
	        
	        output.format("%s",str);
	        output.close();
	 }
	
}

	

