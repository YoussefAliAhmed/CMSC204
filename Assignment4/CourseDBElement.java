package Assignments.Assignment4;

/**
 * Class for CourseDBElement objects that's stored in the CourseDBStructure
 * 
 * @Author Youssef Ali Ahmed
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

    private String id, room_number, instructor;
    private int crn, credits;

    /**
     * Default constructor for CourseDBElement
     */
    public CourseDBElement() {
        id = room_number = instructor = null;
        crn = 00000;
        credits = 0;
    }

    /**
     * Constructor for CourseDBElement parameters
     * 
     * @param id
     * @param crn
     * @param credits
     * @param room
     * @param teacher
     */
    public CourseDBElement(String id, int crn, int credits, String room, String teacher) {
        this.id = id;
        room_number = room;
        instructor = teacher;
        this.crn = crn;
        this.credits = credits;
    }

    /**
     * Sets the ID of the CourseDBElement
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the room number of the CourseDBElement
     * 
     * @param room_number
     */
    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    /**
     * Sets the instructor of the CourseDBElement
     * 
     * @param instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * Sets the CRN of the CourseDBElement
     * 
     * @param crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }

    /**
     * Sets the credits of the CourseDBElement
     * 
     * @param credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Gets the ID of the CourseDBElement
     * 
     * @return ID
     */
    public String getID() {
        return id;
    }

    /**
     * Gets the room number of the CourseDBElement
     * 
     * @return room number
     */
    public String getRoomNum() {
        return room_number;
    }

    /**
     * Gets the instructor of the CourseDBElement
     * 
     * @return Instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Gets the CRN of the CourseDBElement
     * 
     * @return
     */

    public int getCRN() {
        return crn;
    }

    /**
     * Gets the credits of the CourseDBElement
     * 
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Compares two CourseDBElements based on their CRN
     * 
     * @param CourseDBElement element to compare to
     * @return 0 if equal, any other number if else
     */
    public int compareTo(CourseDBElement ele) {
        return this.crn - ele.getCRN();
    }

    /**
     * Creates a hashcode for the CRN based on the CRN string hashcode
     * 
     * @return hashcode of CRN
     */
    public int hashCode() {
        return Integer.toString(crn).hashCode();
    }

    /**
     * @return a string representation of the CourseDBElement
     */
    public String toString() {
        return "Course:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + room_number;
    }

}
