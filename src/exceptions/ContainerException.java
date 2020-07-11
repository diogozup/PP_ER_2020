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
public class ContainerException extends order.exceptions.ContainerException {

    /**
     * Creates a new instance of <code>ContainerException</code> without detail
     * message.
     */
    public ContainerException() {
    }

    /**
     * Constructs an instance of <code>ContainerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ContainerException(String msg) {
        super(msg);
    }
}
