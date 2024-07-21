package Assignments.Assignment4;

import java.io.*;
import java.util.*;

import Assignments.Assignment4.CourseDBElement;
import Assignments.Assignment4.Interfaces.CourseDBStructureInterface;

/**
 * Class for CourseDBStructure objects that stores CourseDBElement objects in a hash table
 * 
 * @author Youssef Ali Ahmed
 */
public class CourseDBStructure implements CourseDBStructureInterface {
    private int hashSize, counter = 0;
    private static final double LOADING_FACTOR = 1.5;
    private LinkedList<CourseDBElement>[] hash;

    /**
     * Constructor for CourseDBStructure objects that initializes the hash table with a size of the next prime number after
     * 
     * @param size of the CourseDBStructure
     */
    public CourseDBStructure(int size) {
        double downSize = size / LOADING_FACTOR;
        hashSize = next4k3Prime((int)Math.floor(downSize));

        hash = new LinkedList[hashSize];
    }

    /**
     * Test Constructor
     * 
     * @param Test
     * @param size
     */
    public CourseDBStructure(String Test, int size) {
        this(size);
    }

    /**
     * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of the CourseDatabaseElemen object's crn
     * value. If the CourseDatabaseElement already exists, it exits.
     * 
     * @param element the CourseDBElement to be added to CourseDBStructure
     */
    public void add(CourseDBElement element) {
        int index = getHashIndex(element);
        if (hash[index] == null) {
            hash[index] = new LinkedList<CourseDBElement>();
        }
        LinkedList<CourseDBElement> listPointer = hash[index];
        // Checks if there's a LinkedList at the Hash index
        if (listPointer.isEmpty()) {
            listPointer.add(element);
            counter++;
        } else {
            // Checks if the element already exists
            boolean flag = false;
            for (CourseDBElement ele : listPointer) {
                if (element.compareTo(ele) == 0) {
                    flag = true;
                }
            }
            if (!flag) {
                listPointer.add(element);
            } else {
                listPointer.remove();
                listPointer.add(element);
            }

        }
    }

    /**
     * Find a courseDatabaseElement based on the key (crn) of the courseDatabaseElement If the CourseDatabaseElement is
     * found return it If not, throw an IOException
     * 
     * @param crn crn (key) whose associated courseDatabaseElement is to be returned
     * @return a CourseDBElement whose crn is mapped to the key
     * @throws IOException if key is not found
     */

    public CourseDBElement get(int crn) throws IOException {
        int index = Integer.toString(crn).hashCode() % hashSize;

        if (hash[index] == null) {
            throw new IOException("Key is not found");
        } else {
            LinkedList<CourseDBElement> listPointer = hash[index];
            ListIterator<CourseDBElement> listIter = listPointer.listIterator();
            while (listIter.hasNext()) {
                CourseDBElement indexedEle = listIter.next();
                if (indexedEle.getCRN() == crn) {
                    return indexedEle;
                }
            }
            throw new IOException("Key is not found");
        }

    }

    /**
     * @return an array list of string representation of each course in the data structure separated by a new line. Refer to
     *         the following example: Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
     *         Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
     */

    public ArrayList<String> showAll() {
        ArrayList<String> stringList = new ArrayList<>();
        for (LinkedList<CourseDBElement> list : hash) {
            if (list == null) {
                continue;
            } else {
                ListIterator<CourseDBElement> iter = list.listIterator();
                while (iter.hasNext()) {
                    stringList.add(iter.next().toString());
                }
            }
        }

        return stringList;
    }

    /**
     * @return the size of the ConcordanceDataStructure (number of indexes in the array)
     */
    public int getTableSize() {
        return hash.length;
    }

    /**
     * @param ele the CourseDBElement to get the hash index of
     * @return the hash index of the CourseDBElement
     */
    public int getHashIndex(CourseDBElement ele) {
        return ele.hashCode() % getTableSize();
    }

    /**
     * @param num
     * @return true if the number is prime, false if not.
     */
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i < num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the next prime number that is 4k+3
     * 
     * @param minNum
     * @return the next prime number that is 4k+3
     */
    public int next4k3Prime(int minNum) {
        int num = minNum;
        while (true) {
            if (isPrime(num) && num % 4 == 3) {
                return num;
            }
            num++;
        }
    }
}
