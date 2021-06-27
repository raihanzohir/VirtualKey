package simplilearn.fsjd.virtualkey.files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import simplilearn.fsjd.virtualkey.menu.MenuContoller;
import simplilearn.fsjd.virtualkey.menu.MenuControllerImpl;

/**
 * @author Md. Zohir Raihan
 *
 */
public class FileOperationsImpl implements FileOperations {

	public static final String FILES_DIR = "files-directory";
		
	@Override
	public void showAllFiles() throws IOException {
		MenuContoller menController = new MenuControllerImpl();
		System.out.println(":: Show Files ::");		
		String[] files;
		File file = new File(FILES_DIR);
		if(file.exists()) {
			files = file.list();
			if(files.length == 0) {
				System.out.println("No File available to show\n");
				menController.mainMenuList();
			} else {
				Arrays.sort(files);
				System.out.println("Available Files:");
				for (String fileName : files) {
					System.out.println(fileName);				
				}
				System.out.println("");
				menController.mainMenuList();
			}			
		} else {
			System.out.println("No Directory Found for Files\n");
			menController.mainMenuList();
		}
	}
	
	@Override
	public void addFile() throws IOException {
		MenuContoller menController = new MenuControllerImpl();
		System.out.println(":: Add File ::");
		System.out.println("Enter file name:\n");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			String fileName = sc.nextLine();
			File filesDirectory = new File(FILES_DIR);
			if(!filesDirectory.exists()) {
				filesDirectory.mkdir();
			}
			File file = new File(filesDirectory, fileName);
			
			if (file.createNewFile()) {
				System.out.println("File added\n");
				menController.subMenuList();
			} else {
				System.out.println("File not added\n");
				menController.subMenuList();
			}
		} catch (IOException ioe) {
			System.out.println("Exception occured: "+ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	@Override
	public void searchFile() throws IOException {
		MenuContoller menController = new MenuControllerImpl();
		System.out.println(":: Search File ::");
		System.out.println("Enter file name:\n");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			String fileName = sc.nextLine();
			File file = new File(FILES_DIR, fileName);

			if (file.exists()) {
				System.out.println("File found\n");
				menController.subMenuList();
			} else {
				System.out.println("File not found\n");
				menController.subMenuList();
			}
		} catch(IOException ioe) {
			System.out.println("Exception occured: "+ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
	
	@Override
	public void deleteFile() throws IOException {
		MenuContoller menController = new MenuControllerImpl();
		System.out.println(":: Delete File ::");
		System.out.println("Enter file name:\n");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			String fileName = sc.nextLine();
			File file = new File(FILES_DIR, fileName);
	
			if (file.delete()) {
				System.out.println("File deleted\n");
				menController.subMenuList();
			} else {
				System.out.println("File not found for delete\n");
				menController.subMenuList();
			}
		} catch(IOException ioe) {
			System.out.println("Exception occured: "+ioe.getMessage());
			ioe.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
