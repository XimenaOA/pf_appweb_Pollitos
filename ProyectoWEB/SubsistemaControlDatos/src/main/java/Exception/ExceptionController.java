/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author haloa
 */
public class ExceptionController extends Exception {

    public ExceptionController() {
    }

    public ExceptionController(String message) {
        super(message);
    }

    public ExceptionController(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionController(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
