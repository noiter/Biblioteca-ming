package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/18/12
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO - remove template comments
// TODO - introduce ISBN and use it to reserve book
// TODO - introduce author name field and display it
public class Books {
    private String name;
    private boolean isAvailable;

    public boolean isAvailable() {
        // TODO - remove commented code
//        if(name != null) {
//            isAvailable = true;
//        } else {
//            isAvailable = false;
//        }
        return isAvailable;
    }

    public Books(String name) {
        this.name = name;
        isAvailable = false;
    }
}
