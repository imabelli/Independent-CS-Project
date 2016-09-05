package bstbasic;

/**
 * Created by Isabel on 7/23/2016.
 */
public class StudentRecordKey implements Comparable{
    String id;
    int year;
    String subject;

    @Override
    public int compareTo(Object o) {

        if (!( o instanceof  StudentRecordKey))
        {
            throw new RuntimeException("invalid argument- StudentRecordKey expected");
        }
        StudentRecordKey inputData = (StudentRecordKey) o;
        if(id.compareTo(inputData.id)!=0){
            return id.compareTo(inputData.id);
        }
        if(year!=inputData.year){
            return year-inputData.year;
        }
        return subject.compareTo(inputData.subject);
    }

    public StudentRecordKey() {
    }

    public StudentRecordKey(String id, String subject, int year) {
        this.id = id;
        this.subject = subject;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
