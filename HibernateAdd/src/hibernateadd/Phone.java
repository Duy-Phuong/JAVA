package hibernateadd;
// Generated Mar 22, 2018 10:50:52 PM by Hibernate Tools 4.3.1



/**
 * Phone generated by hbm2java
 */
public class Phone  implements java.io.Serializable {


     private Integer id;
     private Employee employee;
     private String phoneNumber;

    public Phone() {
    }
 
   
        public Phone(String PhoneNumber) {
            this.phoneNumber = PhoneNumber;
        }

 
    public Phone(Employee employee, String phoneNumber) {
       this.employee = employee;
       this.phoneNumber = phoneNumber;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

      Phone obj2 = (Phone)obj;
      if((this.id == obj2.getId()) && (this.phoneNumber.equals(obj2.getPhoneNumber())))
      {
         return true;
      }
      return false;
   }
   
public int hashCode() {
      int tmp = 0;
      tmp = ( id + phoneNumber ).hashCode();
      return tmp;
   }
   





}


