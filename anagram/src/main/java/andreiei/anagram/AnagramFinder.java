/**
 * This Anagram class takes in a list of words and finds
 * all anagrams.
 * 
 * @author Andrei Eismont
 * @version 1.0
 * @since 2019-05-05
 */

package andreiei.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramFinder {
	Map<String, List<String>> anagramMap;

	public AnagramFinder() {
		anagramMap = null;
	}

	/**
	 * This method creates an anagram map and inserts the anagrams into a HashMap.
	 * 
	 * @param lines A list of words
	 */
	public void createAnagram(List<String> lines) {
		anagramMap = new HashMap<String, List<String>>();

		for (String word : lines) {
			String sortedWord = sortString(word.toLowerCase().trim());

			if (!anagramMap.containsKey(sortedWord)) {
				anagramMap.put(sortedWord, new ArrayList<String>());
			}

			anagramMap.get(sortedWord).add(word.toLowerCase());
		}

		removeNonAnagramWords(anagramMap);
	}

	/**
	 * This method removes all entries whose lists are shorted in length than 1,
	 * i.e. non anagram values.
	 * 
	 * @param anagramMap A map containing anagrams and non-anagrams.
	 */
	public void removeNonAnagramWords(Map<String, List<String>> anagramMap) {
		anagramMap.values().removeIf(value -> value.size() == 1);
	}

	/**
	 * This method sorts the characters of a string alphabetically
	 * 
	 * @param wordToSort String to sort
	 * @return String Returns the sorted string
	 */
	public String sortString(String wordToSort) {
		char[] sortedWordByChars = wordToSort.toCharArray();
		Arrays.sort(sortedWordByChars);
		return new String(sortedWordByChars);

	}

	/**
	 * This method prints all anagrams
	 * 
	 * @param anagramMap HashMap consisting of the char-sorted word (key), and a
	 *                   list of anagrams
	 */
	public void printAnagrams() {
		System.out.println("==============================");
		System.out.printf("%20s", "Anagrams\n");
		System.out.println("==============================");

		for (List<String> anagram : anagramMap.values()) {
			printArrayList(anagram);
		}
	}

	/**
	 * This method prints lines from an list
	 * 
	 * @param anagram String list
	 */
	private void printArrayList(List<String> anagrams) {
		for (String s : anagrams) {
			System.out.print(s + " ");
		}

		System.out.println();
	}

	/**
	 * This method returns a HashMap anagram.
	 * 
	 * @return Returns the anagram
	 */
	public Map<String, List<String>> getAnagramMap() {
		return anagramMap;
	}
}
