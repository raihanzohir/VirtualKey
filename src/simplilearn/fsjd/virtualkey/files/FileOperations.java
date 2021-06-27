package simplilearn.fsjd.virtualkey.files;

import java.io.IOException;

/**
 * @author Md. Zohir Raihan
 *
 */
public interface FileOperations {

	void showAllFiles() throws IOException;
	
	void addFile() throws IOException;
	
	void searchFile() throws IOException;
	
	void deleteFile() throws IOException;
}
