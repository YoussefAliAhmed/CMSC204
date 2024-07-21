package Assignments.Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Assignments.Assignment4.Interfaces.CourseDBManagerInterface;

/**
 * Class for CourseDBManager objects that manages the CourseDBStructure
 * 
 * @author Youssef Ali Ahmed
 */
public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure data = new CourseDBStructure(10);

    /**
     * Adds a course CourseDBElement with the given information
     */
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        data.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }

    /**
     * finds CourseDBElement based on the crn key
     * 
     * @return a CourseDBElement object
     * @param crn course crn - key.
     */
    public CourseDBElement get(int crn) {
        try {
            return data.get(crn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads the information of courses from a text file and adds them to the CourseDBStructure data structure
     * 
     * @param input input file
     * @throws FileNotFoundException if file does not exist
     */
    public void readFile(File input) throws FileNotFoundException {
        Scanner read = new Scanner(input);
        while (read.hasNextLine()) {
            String courseObject = read.nextLine();
            String[] courseList = courseObject.split(" ");
            String teacherName = "";
            for (int i = 4; i < courseList.length; i++) {
                teacherName += courseList[i] + " ";
            }
            data.add(new CourseDBElement(courseList[0], Integer.parseInt(courseList[1]), Integer.parseInt(courseList[2]),
                    courseList[3], teacherName));
        }
        read.close();
    }

    /**
     * @return an array list of string representation of each course in the data structure separated by a new line.
     */
    public ArrayList<String> showAll() {
        return data.showAll();
    }

}
