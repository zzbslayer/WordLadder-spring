package com.example.demo;


import com.example.demo.service.WordLadderService;
import com.example.demo.service.internal.WordLadderImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class WordLadderImplApplicationTest extends TestCase {

    private WordLadderImpl wl = new WordLadderImpl();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordLadderImplApplicationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordLadderImplApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testIsAdjacent() {

        assertTrue( wl.IsAdjacent("bag","bug"));
        assertTrue( wl.IsAdjacent("cat", "cab"));
        assertTrue( wl.IsAdjacent( "bag", "bags"));
        assertTrue( wl.IsAdjacent( "bag", "bang"));
        assertFalse( wl.IsAdjacent("money", "elephant"));
        assertFalse( wl.IsAdjacent("money", ""));
        assertFalse( wl.IsAdjacent("zoo", "zoo"));
    }

    public void testIsExist(){
        Set<String> test = new HashSet<String>();
        test.add("monkey");
        test.add("tiger");

        assertTrue( wl.IsExist(test,"monkey"));
        assertFalse( wl.IsExist(test,"dog"));
    }

    public void testIsValid(){
        assertTrue( wl.IsValid("faggawe"));
        assertFalse( wl.IsValid("fasdf1"));
        assertFalse( wl.IsValid("awgee;"));
        assertFalse( wl.IsValid("awgee`0;"));
        assertFalse( wl.IsValid("awgee"+'\t'));
        assertFalse( wl.IsValid(""));
    }

    public void testStringLadderGenerate() throws Exception{
        assertTrue( wl.StringLadderGenerate("apple","apple").equals("The words are the same."));
        assertTrue( wl.StringLadderGenerate("apple","fasd!@!#").equals("The word fasd!@!# is invalid."));

    }

    /*
    The correctness of LadderGenerate() cannot be tested.
    Without running the programme, I cannot get the ladder.
    */
}
