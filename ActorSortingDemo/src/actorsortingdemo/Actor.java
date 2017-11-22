/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actorsortingdemo;

/**
 *
 * @author admin1
 */
// Để so sánh được với nhau, lớp Actor cần thi hành interface Comparable.
public class Actor implements Comparable<Actor> {
 
    private String firstName;
    private String lastName;
 
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    // So sánh với một đối tượng Actor khác
    // Theo nguyên tắc so sánh lastName trước,
    // sau đó so sánh firstName.
    @Override
    public int compareTo(Actor other) {
 
        // So sánh 2 String.
        int value = this.lastName.compareTo(other.lastName);
 
        // Nếu lastName của 2 đối tượng là không bằng nhau.
        if (value != 0) {
            return value;
        }
        // Nếu lastName của 2 đối tượng là giống nhau.
        // Thì so sánh fistName.
        value = this.firstName.compareTo(other.firstName);
        return value;
    }
 
}
