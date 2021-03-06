package andreiei.anagram;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.FileSystems;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import andreiei.anagram.AnagramFinder;

public class AnagramTest {
	private AnagramFinder anagramFinder;

	@Before
	public void setup() {
		anagramFinder = new AnagramFinder();
	}

	@Test
	public void testSortString() {
		String stringAfterSorting = anagramFinder.sortString("edcba");
		assertEquals("abcde", stringAfterSorting);
	}

	@Test
	public void testAnagram() {
		Map<String, List<String>> testmap = new HashMap<String, List<String>>();

		testmap.put("ehllo", new ArrayList<String>());
		testmap.get("ehllo").add("hello");
		testmap.get("ehllo").add("olleh");

		testmap.put("adeinr", new ArrayList<String>());
		testmap.get("adeinr").add("ierdna");
		testmap.get("adeinr").add("andrei");
		testmap.get("adeinr").add("dnaier");

		String directory = System.getProperty("user.dir") + "/src/test/resources/txt/";
		Path path = FileSystems.getDefault().getPath(directory, "testFile.txt");
		List<String> listOfWords = Main.readFile(path);
		anagramFinder.createAnagram(listOfWords);

		Map<String, List<String>> anagramMap = anagramFinder.getAnagramMap();

		assertEquals(testmap.size(), anagramMap.size());
		assertThat(anagramMap, is(testmap));
	}
}
