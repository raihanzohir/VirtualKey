package simplilearn.fsjd.virtualkey.main;

import java.io.IOException;

import simplilearn.fsjd.virtualkey.menu.MenuContoller;
import simplilearn.fsjd.virtualkey.menu.MenuControllerImpl;

/**
 * @author Md. Zohir Raihan
 *
 */
public class VirtualKeyMain {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Virtual Key (A command-line Java program)");
		System.out.println("========================================================\n");
				
		MenuContoller menController = new MenuControllerImpl();
		menController.mainMenuList();
	}

}
