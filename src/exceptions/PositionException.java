/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author zzup
 */
public class PositionException extends order.exceptions.PositionException {

    /**
     * Creates a new instance of <code>PositionException</code> without detail
     * message.
     */
    public PositionException() {
    }

    /**
     * Constructs an instance of <code>PositionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PositionException(String msg) {
        super(msg);
    }
}
