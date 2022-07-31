package lockedme.com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe{
    static String DIRECTORY;
    static File folder;

    public LockedMe() {
        DIRECTORY = System.getProperty("D:\\javafsd\\Phase-1-Projects\\Phase-1 project\\LockedMe");
        folder = new File("Harsha");
        if (!folder.exists())
            folder.mkdirs();
        System.out.println("DIRECTORY : "+ folder.getAbsolutePath());
    }

	public static final void WelcomeScreen() {
		String CompanyDetails="\t*$*$*$*$*$*$*$*$*$*$LockedMe.com*$*$*$*$*$*$*$*$*$*$\n"+"\t*$*$*$*$*$*$*$*$*$*$Rama Rao*$*$*$*$*$*$*$*$*$*$\n";
		String AppFunction = "****You can use this application for**** \n"
							+"1)retrieving the Current file names in ascending order\n"
							+"2)Add a file/Delete a file from the existing directory list\n"
							+"3)Can search a user specified file from the main directory\n";
		System.out.println(CompanyDetails);
		System.out.println(AppFunction);
		
	}
	public static void DisplayMenu() {
		String[] mainmenu={"\n**Select the options from below**\n",
					"1)Retrieve the file inside the desired folder\n",
					"2)Business level operations\n",
					"3)Close the Application\n"};
		System.out.println(mainmenu);
		try {
		 int[] menu1 = {1,2,3,4};
	     int  slen = menu1.length;
	     for(int i=0; i<slen;i++){
			System.out.println(mainmenu[i]);
	     }
	     System.out.println("\nEnter your choice:\t");
	     Scanner sc = new Scanner(System.in);
	     int  options =  sc.nextInt();
	     for(int j=1;j<=slen;j++){
	         if(options==j){
	             switch (options){
	                 case 1:
	                     System.out.println("To retrieve the file in ascending order: \n");
	                     showFiles();
	                     DisplayMenu();
	                 case 2:System.out.println("To access Business Level Operations");
						DisplayBusinessLevelOperations();
	                 case 3:System.out.println("Thank you for using the LockedMe application");
	                 	System.exit(0);
	                 default:System.out.println("!!!you have entered invalid option... please choosen the below options only!!!");
	                	 DisplayMenu();
	         }
	         }
	     }
		} catch (Exception e) {
			System.out.println("Enter 1,2,3 options");
			e.printStackTrace();
		}

	}
	
	public static void DisplayBusinessLevelOperations() {
		String[] BusinessLevelOperations= { "\n**Select the options below**\n",
										"1)Add a file to the directory\n",
										"2)Delete a file from directory\n",
										"3)Search for a file from directory\n",
										"4)Show previous menu\n",
										"5)Exit the program\n"};
		System.out.println(BusinessLevelOperations);
		 int[] menu1 = {1,2,3,4,5,6};
	     int  slen = menu1.length;
	     for(int i=0; i<slen;i++){
			System.out.println(BusinessLevelOperations[i]);
	     }
	     System.out.println("\nEnter your choice:\t");
	     try {
	     Scanner sc = new Scanner(System.in);
	     int  options =  sc.nextInt();
	     for(int j=1;j<=slen;j++){
	         if(options==j){
	             switch (options){
	             case 1:System.out.println("Enter the file name to be added: ");
	                  String filename = sc.next().trim().toLowerCase();
	                  addFile(filename);
	                  DisplayBusinessLevelOperations();
	                 // break;
	             case 2:System.out.println("\nEnter the file name to be deleted: ");
	             	  String filename1 =sc.next().trim();
	             	  DeleteFile(filename1);
	             	 DisplayBusinessLevelOperations();
	             	//  break;
	             case 3:System.out.println("\nEnter the file name for searching: ");
	                  String filename2 = sc.next().trim();
	                  searchFile(filename2);
	                  DisplayBusinessLevelOperations();
	                 // break;
	             case 4:System.out.println("\nTo get back to main menu");
	                  DisplayMenu();
	                 // break;
	             case 5:System.out.println("The Application is stopped....login again...if needed");
	                  System.exit(0);
	                 // break;
	             default:System.out.println("!!!you have entered invalid option... please choosen the below options only!!!");
	            	 DisplayBusinessLevelOperations();
	}
	         }
	
}
	     } catch (IOException e) {
	    	 System.out.println("Enter 1,2,3,4,5 options");
				e.printStackTrace();
			}
	     
}
    static void showFiles() {
        if (folder.list().length==0)
            System.out.println("The folder is empty");
        else {
            String[] list = folder.list();
            System.out.println("The files in "+ folder +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

	static void addFile(String filename) throws IOException {
		File filepath= new File(folder+"/"+filename);
		String[]list =folder.list();
		for (String file : list) {
			if(filename.equalsIgnoreCase(file)) {
				System.out.println("The file "+filename+" already exists in "+folder);
				return;
			}
		}
		filepath.createNewFile();
		System.out.println("The File "+filename+" added successfully to "+folder+" folder");
	}
	static void DeleteFile(String filename1){
		File filepath= new File(folder+"/"+filename1);
		String[]list =folder.list();
		for (String file : list) {
			if(filename1.equals(file) && filepath.delete()) {
				System.out.println("The file "+filename1+" deleted successfully from "+folder+" folder");
				return;
			}
			
			}
		System.out.println("The File "+filename1+" is not found in the "+folder+" folder");
		}
		
		static void searchFile(String filename2){
			String[]list =folder.list();
			for (String file : list) {
				if(filename2.equals(file)) {
					System.out.println("The file is found and ");
					System.out.println("the file "+filename2+" exists in "+folder+" folder");
					return;
				}
			}
			System.out.println("File Not Found-FNF");
	}



	public static void main(String[] args) {
		WelcomeScreen();
		LockedMe mainmenu = new LockedMe();
		mainmenu.DisplayMenu();
		
	}
}