/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import order.packing.IItem;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class Item extends Box implements IItem{

    private String reference;
    private String description;

    /**
     *
     * @param reference
     * @param description
     * @param depth
     * @param height
     * @param length
     * @param volume
     */
    public Item(String reference, String description, int depth, int height, int length) {
        super(depth, height, length);
        this.reference = reference;
        this.description = description;
    }

    /**
     * Getter of reference
     * @return reference
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Getter of description
     * @return description
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for description
     * @param string
     */
    @Override
    public void setDescription(String string) {
        this.description = string;
    }

    @Override
    public int getDepth() {
        return super.getDepth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getLenght() {
        return super.getLenght();
    }

    @Override
    public int getVolume() {
        return super.getVolume();
    }

}
