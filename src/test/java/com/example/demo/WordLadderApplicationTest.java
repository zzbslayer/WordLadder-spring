package com.example.demo;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

import com.example.demo.WordLadderApplication.*;

/**
 * Unit test for simple App.
 */
public class WordLadderApplicationTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordLadderApplicationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordLadderApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testIsAdjacent() {
        WordLadderApplication wl = new WordLadderApplication();
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
        WordLadderApplication wl = new WordLadderApplication();
        test.add("monkey");
        test.add("tiger");

        assertTrue( wl.IsExist(test,"monkey"));
        assertFalse( wl.IsExist(test,"dog"));
    }

    public void testIsValid(){
        WordLadderApplication wl = new WordLadderApplication();
        assertTrue( wl.IsValid("faggawe"));
        assertFalse( wl.IsValid("fasdf1"));
        assertFalse( wl.IsValid("awgee;"));
        assertFalse( wl.IsValid("awgee`0;"));
        assertFalse( wl.IsValid("awgee"+'\t'));
        assertFalse( wl.IsValid(""));
    }

    /*
    The correctness of LadderGenerate() cannot be tested.
    Without running the programme, I cannot get the ladder.
    */
}
