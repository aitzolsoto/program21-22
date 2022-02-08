/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herentzia;

/**
 *
 * @author soto.aitzol
 */
public class FilthyWaterMonster extends WaterMonster{
    public FilthyWaterMonster(String name){
        super(name);
    }
    
    @Override
    public String attack(){
        return "Attack with filthy water";
    }
}
