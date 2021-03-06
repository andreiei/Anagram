/**
 * This Main program starts the Anagram finder by reading in a given file
 * and then sending a list of words.
 * 
 * @author Andrei Eismont
 * @version 1.0
 * @since 2019-05-05
 */

package andreiei.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Path pathToFile = getFilePath("eventyr.txt");
		List<String> listOfWords = readFile(pathToFile);

		AnagramFinder anagramFinder = new AnagramFinder();
		anagramFinder.createAnagram(listOfWords);
		anagramFinder.printAnagrams();
	}

	/**
	 * This method finds an absolute path to a given filename.
	 * 
	 * @param filename The filename to find the path to.
	 * @return The Path file for where the file resides.
	 */
	public static Path getFilePath(String filename) {
		String directory = System.getProperty("user.dir") + "/src/main/resources/txt/";
		Path path = FileSystems.getDefault().getPath(directory, filename);

		return path;
	}

	/**
	 * This method looks through a file and puts all words into an arrayList.
	 * 
	 * @param pathToFile The absolute Path where the file resides
	 * @return An arrayList of read words.
	 */
	public static ArrayList<String> readFile(Path pathToFile) {
		Charset charset = Charset.forName("UTF-8");

		ArrayList<String> textList = new ArrayList<String>();
		try (BufferedReader reader = Files.newBufferedReader(pathToFile, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				textList.add(line.trim());
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			System.exit(0);
		}

		return textList;
	}
}
