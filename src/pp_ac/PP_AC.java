/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_ac;

import exceptions.ContainerException;
import exceptions.PositionException;
import implementation.Address;
import implementation.Container;
import implementation.Customer;
//import implementation.Exporter;
import implementation.Item;
import implementation.Person;
import implementation.Position;
//import implementation.ShippingOrder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import order.base.OrderStatus;
import order.exceptions.OrderException;
import order.packing.Color;
import org.json.simple.parser.ParseException;
import packing_gui.PackingGUI;

/**
 *
 * @author zzup
 */
public class PP_AC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Item item1 = new Item("ref001", "descrption", 1, 1, 1);
        Item item2 = new Item("ref002", "descrption", 3, 3, 3);
        Item item3 = null;

        Container container1 = new Container("refCont001", Color.red, Color.red, 9, 9, 9);
        Position position1 = new Position(1, 1, 1);
        Position position2 = new Position(3, 3, 3);

        Address address1 = new Address("Gmr", "PT", 101, "Braga", "Rua das flores");
        Person person1 = new Person("Diogo", address1);

        Customer customer1 = new Customer("name1", address1);
//
//        Exporter exporter1 = new Exporter();
//        
//        
//        
//
//        //------------------------------------------------------------------------------------------------------usei  o stactment trycatch
//        try {
//            container1.addItem(item1, position1, Color.silver);
//            container1.addItem(item2, position2, Color.silver);
////            container1.addItem(item3, position1, Color.silver);
//            container1.removeItem(item2);
//            container1.addItem(item2, position2, Color.red);
//
//        } catch (ContainerException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            container1.close();
//        } catch (ContainerException ex) {
//            System.out.println(ex);
//        } catch (PositionException ex) {
//            System.out.println(ex);
//        }
//
//        //------------------------------------------------------------------------------------------------------usei  o stactment trycatch
//        //----------------------------------------------------------------------------------------------------- tirar os loggers e meter as exptions
//        ShippingOrder shippingOrder1 = new ShippingOrder(person1, customer1);
//        try {
//            shippingOrder1.setStatus(OrderStatus.IN_TREATMENT);
//        } catch (exceptions.OrderException ex) {
//            System.out.println(ex);
//        } catch (ContainerException ex) {
//            System.out.println(ex);
//        } catch (PositionException ex) {
//            System.out.println(ex);
//        }
//
//        try {
//            shippingOrder1.addContainer(container1);
//        } catch (OrderException ex) {
//            System.out.println(ex);
//        } catch (order.exceptions.ContainerException ex) {
//            System.out.println(ex);
//        }
//
//        //------------------------------------------------------------------------------------------------------
//        try {
//
//            exporter1.export(shippingOrder1);
//
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//
//        if (PackingGUI.validate("files/file.json")) {
//            try {
//                PackingGUI.render("files/file.json");
//            } catch (IOException ex) {
//                System.out.println(ex);
//            } catch (ParseException ex) {
//                System.out.println(ex);
//            }
//        }
//
//        System.out.println(shippingOrder1.summary());
//        
//    //1------------------------------------------------------------------------------------
//    Container[] container_def1 = new Container[shippingOrder1.getNumOfContainers()];
//    container_def1 = shippingOrder1.containersWichAreColorRed();
//   
//    //1.1 imprimir para tods as referencia 
//    for(int i = 0 ; i < shippingOrder1.getNumOfContainers(); i++){
//        //container_def1[i].getReference();
//        if(container_def1[i] != null){
//        System.out.println(container_def1[i].getReference());
//            
//        }
//    }
//    
//    //2------------------------------------------------------------------------------------
//    
//    //shippingOrder1.findPositionOfItemInShippingOrder(item2);
//    //System.out.println(shippingOrder1.findPositionOfItemInShippingOrder);
//    
//    
//    Item item5 = shippingOrder1.findPositionOfItemInShippingOrder();
//    
//    System.out.println(item5.toString());
//    
//    //**** Perguntas possiveis
//    //1- Diferena entre var de instancia VS var de classe <- Explicacao esta no "Costumer.java"
// 

        
    
    }

    
    
    
    
    



}
