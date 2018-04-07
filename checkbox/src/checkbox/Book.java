/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;

import java.io.Serializable;

public class Book implements Serializable {

    private int no;
    private String bookCode;
    private String bookTitle;
    private int price;
    private boolean avaliable;

    public Book(int no,String bookCode, String bookTitle, int price, boolean avaliable) {
        this.no = no;
        this.bookCode = bookCode;
        this.bookTitle = bookTitle;
        this.price = price;
        this.avaliable = avaliable;
    }

    /**
     * @return the bookCode
     */
    public String getBookCode() {
        return bookCode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @param bookCode the bookCode to set
     */
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the avaliable
     */
    public boolean isAvaliable() {
        return avaliable;
    }

    /**
     * @param avaliable the avaliable to set
     */
    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
}

