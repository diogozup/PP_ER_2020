/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class ItemPacked implements IItemPacked{

    private Color color;
    private Item item;
    private Position position;
    
    private Color colorEdge;

    /**
     *
     * @param color
     * @param item
     * @param position
     */
    public ItemPacked(Color color, Item item, Position position) {
        this.color = color;
        this.item = item;
        this.position = position;
    }
    
    /**
     * Getter for color
     * @return color
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter for item
     * @return item
     */
    @Override
    public IItem getItem() {
        return this.item;
    }

    /**
     * Getter for position
     * @return position
     */
    @Override
    public IPosition getPosition() {
        return this.position;
    }

    /**
     * Setter for color
     * @param color
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Setter for position
     * @param ip
     */
    @Override
    public void setPosition(IPosition ip) {
        this.position = (Position)ip;
    }

    @Override
    public Color getColorEdge() {
        return this.colorEdge;
    }

    @Override
    public void setColorEdge(Color color) {
        this.colorEdge = color;
    }

}
