package com.example.demo;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

import static com.example.demo.WordLadderApplication.*;

/**
 * Unit test for simple App.
 */
public class WordLadderTest 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordLadderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordLadderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testIsAdjacent() {
        assertTrue( IsAdjacent("bag","bug"));
        assertTrue( IsAdjacent("cat", "cab"));
        assertTrue( IsAdjacent( "bag", "bags"));
        assertTrue( IsAdjacent( "bag", "bang"));
        assertFalse( IsAdjacent("money", "elephant"));
        assertFalse( IsAdjacent("money", ""));
        assertFalse( IsAdjacent("zoo", "zoo"));
    }

    public void testIsExist(){
        Set<String> test = new HashSet<String>();
        test.add("monkey");
        test.add("tiger");

        assertTrue( IsExist(test,"monkey"));
        assertFalse( IsExist(test,"dog"));
    }

    public void testIsValid(){
        assertTrue( IsValid("faggawe"));
        assertFalse( IsValid("fasdf1"));
        assertFalse( IsValid("awgee;"));
        assertFalse( IsValid("awgee`0;"));
        assertFalse( IsValid("awgee"+'\t'));
        assertFalse( IsValid(""));
    }

    /*
    The correctness of LadderGenerate() cannot be tested.
    Without running the programme, I cannot get the ladder.
    */
}
