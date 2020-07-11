/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.io.IOException;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.IOrder;
import order.management.IOrderImporter;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rubenmiguelcunhasimoes
 */
public class OrderImporter implements IOrderImporter{

    @Override
    public void importData(IOrder iorder, String string) throws IOException, ParseException, ContainerException, OrderException, PositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
}
