///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package implementation;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import shippingorder.IExporter;
//import shippingorder.IShippingOrder;
//
///**
// * Nome: Diogo Sá Tinoco de Magalhães Número: 8120336 Turma: turma1
// */
//public class Exporter implements IExporter {
//
//    @Override
//    public void export(IShippingOrder iso) throws IOException {
//
//        ShippingOrder so = (ShippingOrder) iso;
//
//        JSONObject[] container = new JSONObject[so.getContainers().length];
//        JSONArray containers = new JSONArray();
//        JSONObject shipOrder = new JSONObject();
//        JSONObject customer = new JSONObject();
//        JSONObject customerAddress = new JSONObject();
//        JSONObject destination = new JSONObject();
//        JSONObject destinationAddress = new JSONObject();
//        JSONObject billingAddress = new JSONObject();
//
//        customerAddress.put("country", so.getCustomer().getAddress().getCountry());
//        customerAddress.put("number", so.getCustomer().getAddress().getNumber());
//        customerAddress.put("street", so.getCustomer().getAddress().getStreet());
//        customerAddress.put("city", so.getCustomer().getAddress().getCity());
//        customerAddress.put("state", so.getCustomer().getAddress().getState());
//
//        destinationAddress.put("country", so.getDestination().getAddress().getCountry());
//        destinationAddress.put("number", so.getDestination().getAddress().getNumber());
//        destinationAddress.put("street", so.getDestination().getAddress().getStreet());
//        destinationAddress.put("city", so.getDestination().getAddress().getCity());
//        destinationAddress.put("state", so.getDestination().getAddress().getState());
//
//        destination.put("name", so.getDestination().getName());
//        destination.put("address", destinationAddress);
//
//        billingAddress.put("country", so.getCustomer().getBillingAddress().getCountry());
//        billingAddress.put("number", so.getCustomer().getBillingAddress().getNumber());
//        billingAddress.put("stress", so.getCustomer().getBillingAddress().getStreet());
//        billingAddress.put("city", so.getCustomer().getBillingAddress().getCity());
//        billingAddress.put("state", so.getCustomer().getBillingAddress().getState());
//
//        customer.put("id", so.getCustomer().getCustomerId());
//        customer.put("name", so.getCustomer().getName());
//        customer.put("address", customerAddress);
//        customer.put("billingAddress", billingAddress);
//
//        for (int i = 0; i < container.length; i++) {
//            container[i] = new JSONObject();
//            container[i].put("reference", so.getContainers()[i].getReference());
//            container[i].put("volume", so.getContainers()[i].getVolume());
//            container[i].put("occupiedVolume", so.getContainers()[i].getOccupiedVolume());
//            container[i].put("depth", so.getContainers()[i].getDepth());
//            container[i].put("length", so.getContainers()[i].getLenght());
//            container[i].put("height", so.getContainers()[i].getHeight());
//            container[i].put("color", ((Container) so.getContainers()[i]).getColor().toString());
//            container[i].put("colorEdge", ((Container) so.getContainers()[i]).getColorEdge().toString());
//            container[i].put("closed", so.getContainers()[i].isClosed());
//
//            JSONObject[] item = new JSONObject[so.getContainers()[i].getPackedItems().length];
//            JSONArray items = new JSONArray();
//
//            for (int j = 0; j < item.length; j++) {
//                item[j] = new JSONObject();
//                item[j].put("reference", so.getContainers()[i].getPackedItems()[j].getItem().getReference());
//                item[j].put("description", so.getContainers()[i].getPackedItems()[j].getItem().getDescription());
//                item[j].put("depth", so.getContainers()[i].getPackedItems()[j].getItem().getDepth());
//                item[j].put("length", so.getContainers()[i].getPackedItems()[j].getItem().getLenght());
//                item[j].put("height", so.getContainers()[i].getPackedItems()[j].getItem().getHeight());
//                item[j].put("color", so.getContainers()[i].getPackedItems()[j].getColor().toString());
//                item[j].put("colorEdge", so.getContainers()[i].getPackedItems()[j].getColor().toString());
//                item[j].put("x", so.getContainers()[i].getPackedItems()[j].getPosition().getX());
//                item[j].put("y", so.getContainers()[i].getPackedItems()[j].getPosition().getY());
//                item[j].put("z", so.getContainers()[i].getPackedItems()[j].getPosition().getZ());
//                items.add(item[j]);
//            }
//            container[i].put("items", items);
//        }
//        for (int i = 0; i < iso.getContainers().length; i++) {
//            containers.add(container[i]);
//        }
//
//        shipOrder.put("orderId", so.getId());
//        shipOrder.put("status", so.getStatus().toString());
//        shipOrder.put("customer", customer);
//        shipOrder.put("destination", destination);
//        shipOrder.put("containers", containers);
//
//        try ( FileWriter file = new FileWriter("files/file.json")) {
//            file.write(shipOrder.toJSONString());
//
//        }
//    }
//
//        
//        
//    
//
//}
