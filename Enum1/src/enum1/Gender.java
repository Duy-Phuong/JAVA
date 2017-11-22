/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enum1;

/**
 *
 * @author admin1
 */
public enum Gender {
     // Khởi tạo các phần tử từ cấu tử.
   // Các phần tử này luôn là final, static
   MALE("M", "Male"), FEMALE("F", "Female");
 
   private String code;
   private String text;
 
   // Cấu tử này chỉ dùng trong nội bộ Enum
   // Modifier của cấu tử luôn là private
   // Nếu bạn không khai báo private, java cũng sẽ hiểu là private.
   private Gender(String code, String text) {
       this.code = code;
       this.text = text;
   }
 
   // Có thể viết một static method lấy ra Gender theo code.
   public static Gender getGenderByCode(String code) {
       for (Gender gender : Gender.values()) {
           if (gender.code.equals(code)) {
               return gender;
           }
       }
       return null;
   }
 
   public String getCode() {
       return code;
   }
 
   public void setCode(String code) {
       this.code = code;
   }
 
   public String getText() {
       return text;
   }
 
   public void setText(String text) {
       this.text = text;
   }
}
