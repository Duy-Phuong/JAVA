package hibernate;
// Generated Mar 22, 2018 8:26:27 PM by Hibernate Tools 4.3.1



/**
 * Message generated by hbm2java
 */
public class Message  implements java.io.Serializable {


     private Short id;
     private String message;

    public Message() {
    }

    public Message(String message) {
       this.message = message;
    }
   
    public Short getId() {
        return this.id;
    }
    
    public void setId(Short id) {
        this.id = id;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }




}


