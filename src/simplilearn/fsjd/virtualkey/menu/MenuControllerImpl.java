package simplilearn.fsjd.virtualkey.menu;

import java.io.IOException;
import java.util.Scanner;

import simplilearn.fsjd.virtualkey.files.FileOperations;
import simplilearn.fsjd.virtualkey.files.FileOperationsImpl;

/**
 * @author Md. Zohir Raihan
 *
 */
public class MenuControllerImpl implements MenuContoller {
	
	FileOperations fileOperations = new FileOperationsImpl();

	@Override
	public void mainMenuList() throws IOException {
				
		System.out.println("1. List of Files");
		System.out.println("2. File Operations");
		System.out.println("3. Exit\n");
		
		System.out.println("Choose an option from above to proceed (e.g.: 1, 2, 3):");

		Scanner sc = null;		
		try {
			sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) {
			case 1:
				fileOperations.showAllFiles();
				break;
			case 2:
				subMenuList();
				break;
			case 3:
				System.out.println("");
				System.out.print("Exiting.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".\n");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Exited from Program\n");
				System.exit(0);			
				break;
			default:
				System.out.println("Enter a valid option\n");
				mainMenuList();
				break;
			}
		} catch(IOException ioe) {
			System.out.println("Exception occured: "+ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			sc.close();
		}
		
		
	}

	@Override
	public void subMenuList() throws IOException {
		System.out.println("1. Add file");
		System.out.println("2. Search file");
		System.out.println("3. Delete file");
		System.out.println("4. Back to Main Menu\n");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) {
			case 1:
				fileOperations.addFile();
				subMenuList();
				break;
			case 2:
				fileOperations.searchFile();
				subMenuList();
				break;
			case 3:
				fileOperations.deleteFile();				
				subMenuList();
				break;
			case 4:
				mainMenuList();
				break;
			default:
				System.out.println("Enter a valid option\n");
				subMenuList();
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
