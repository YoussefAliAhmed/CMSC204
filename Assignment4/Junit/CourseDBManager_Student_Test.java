package Assignments.Assignment4.Junit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Assignments.Assignment4.*;
import Assignments.Assignment4.Interfaces.*;

public class CourseDBManager_Student_Test {
    private CourseDBManagerInterface manager = new CourseDBManager();

    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void testAddToDB() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            manager.add("CMSC203", 30504, 4, "SC450", "Joey Bag-O-Donuts");
            manager.add("CMSC204", 33204, 4, "EA121", "Moboloaji Ogunbiyi");
            manager.add("ENGL101", 32304, 3, "SC200", "John Doe");
            list = manager.showAll();
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
        assertEquals(list.get(0).toString(), "Course:CMSC204 CRN:33204 Credits:4 Instructor:Moboloaji Ogunbiyi Room:EA121");
        assertEquals(list.get(1).toString(), "Course:CMSC203 CRN:30504 Credits:4 Instructor:Joey Bag-O-Donuts Room:SC450");
        assertEquals(list.get(2).toString(), "Course:ENGL101 CRN:32304 Credits:3 Instructor:John Doe Room:SC200");

    }

}
