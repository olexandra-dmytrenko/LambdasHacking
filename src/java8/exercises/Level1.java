import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Hint: Use forEach, filter, map,
 * */

public class Level1 {

// Exercise 1: Print out all the words in wordList, which is
// a static List<String> defined at the bottom of this file.

    @Test @Ignore
    public void printAllWords() {
        /* TODO */

        // no assertions
    }
    
// Exercise 2: Convert all words in wordList to upper case,
// and gather the result into an output list.
    
    @Test @Ignore
    public void upperCaseWords() {
        List<String> output = null; /* TODO */
        
        assertEquals(
            Arrays.asList(
                "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                "LEVEL", "OF", "INDIRECTION"),
            output);
    }

// Exercise 3: Find all the words in wordList that have even length
// and put them into an output list.
    
    @Test @Ignore
    public void findEvenLengthWords() {
        List<String> output = null; /* TODO */
        
        assertEquals(
            Arrays.asList(
                "in", "computer", "be", "solved", "by", "adding", "of"),
                output);
    }
    
// Exercise 4: Count the number of lines in a file. The field *reader*
// is a BufferedReader which will be opened for you on the text file.
// See the JUnit @Before and @After methods at the bottom of this file.
// The text file is "SonnetI.txt" (Shakespeare's first sonnet) which is
// located at the root of this NetBeans project.

    @Test @Ignore
    public void countLinesInFile() throws IOException {
        long count = 0L; /* TODO */
        
        assertEquals(14, count);
    }
    
// Exercise 5: Join lines 3-4 from the text file into a single string.
    
    @Test @Ignore
    public void joinLineRange() throws IOException {
        String output = null; /* TODO */
        
        assertEquals(
            "But as the riper should by time decease," +
            "His tender heir might bear his memory:",
            output);
    }

// Exercise 6: Find the length of the longest line in the file.
    
    @Test @Ignore
    public void lengthOfLongestLine() throws IOException {
        int longest = 0; /* TODO */
        
        assertEquals(longest, 53);
    }

// ===== TEST INFRASTRUCTURE ==================================================

    static List<String> wordList = Arrays.asList(
        "every", "problem", "in", "computer", "science",
        "can", "be", "solved", "by", "adding", "another",
        "level", "of", "indirection");
            // Butler Lampson

    static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @Before
    public void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8);
    }

    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }
}