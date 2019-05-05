package andreiei.anagram;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.junit.Test;

public class MainTest {

	@Test
	public void testReadFile() {
		String directory = System.getProperty("user.dir") + "/src/test/resources/txt/";
		Path path = FileSystems.getDefault().getPath(directory, "testFile.txt");

		List<String> readStrings = Main.readFile(path);

		assertEquals("ierdna", readStrings.get(0));
		assertEquals("dada", readStrings.get(1));
		assertEquals("wo2941", readStrings.get(2));
		assertEquals("Andrei", readStrings.get(3));
		assertEquals("dmz", readStrings.get(4));
		assertEquals("dnaier", readStrings.get(5));
		assertEquals("hello", readStrings.get(6));
		assertEquals("olleh", readStrings.get(7));
	}

	@Test
	public void testgetPathFile() {
		Path path = Main.getFilePath("eventyr.txt");
		String directory = System.getProperty("user.dir") + "/src/main/resources/txt/eventyr.txt";
		String finalPath = path.toAbsolutePath().toString();

		assertEquals(finalPath, directory);
	}
}
