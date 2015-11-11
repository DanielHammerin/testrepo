package Programfolder;

/**
 * Created by Daniel on 2015-11-11.
 */
public class Member {
    private String firstName;
    private String lastName;
    private String memberID;

    /*
     * Constructor for the member object.
     */
    public Member(String n1, String n2, String memID) {
        this.firstName = n1;
        this.lastName = n2;
        this.memberID = memID;
    }
    public Member() {}

    /**
     * Getters and setters for the member object parameters.
     */
    public void setMemberFirstName(String n1) {
        this.firstName = n1;
    }
    public void setMemberLastName(String n2) {
        this.lastName = n2;
    }
    public void setMemberID(String memID) {
        this.memberID = memID;
    }

    public String getMemberFirstName() {
        return this.firstName;
    }
    public String getMemberLastName() {
        return this.lastName;
    }
    public String getMemberID() {
        return this.memberID;
    }

}
