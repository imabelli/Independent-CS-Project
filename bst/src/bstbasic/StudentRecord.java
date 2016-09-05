package bstbasic;

/**
 * Created by Isabel on 7/23/2016.
 */
public class StudentRecord {
    String id;
    String name;
    int year;
    String subject;
    String grade;
    int absence;

    public StudentRecord(String id, String name, int year, String subject, String grade, int absence) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.subject = subject;
        this.grade = grade;
        this.absence = absence;
    }

    public String getId() {

        return id;
    }
    public StudentRecordKey getKey(){
        return new StudentRecordKey(id, subject, year);
    }

    @Override
    public String toString() {
        return "StudentRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                ", absence=" + absence +
                '}';
    }

    public StudentRecord() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public String getName() {

        return name;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public int getAbsence() {
        return absence;
    }
}
