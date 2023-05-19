/*
Ebba Þóra Hvannberg ebba@hi.is
 */

package is.hi.ludo.vinnsla;

import java.util.Random;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * Útfærir einn tening sem hefur hliðar 1-6. Hægt að kasta tening. 
 * 
 * @author Ebba Þóra Hvannberg ebba@hi.is 
 * Háskóli Íslands
 */
public class Teningur {
    private int teningur=6; // Teningur er 6 í byrjun
    private SimpleIntegerProperty propGildi = new SimpleIntegerProperty(6);

    
    private Random rand = new Random();
    static final int MAX = 6;
    static final int MIN = 1;
    //int fylki[]={6,6,6,1,6,6,5,5,6,4,6,5,6,6};
    int telja =0;

      
    /**
     * Býr til random tölu
     * @return random tölu 
     */
    private int naestaRandomTala() {
        int randomNUM = rand.nextInt((MAX - MIN) + 1) + MIN;
      //  int randomNUM=fylki[telja%14];
        telja ++;
        //randomNum = 6;
        return randomNUM;
    }

    /**
     * Kastar teningnum og skilar gildi hans
     */
    public int kasta () {
          teningur = naestaRandomTala();
          propGildi.set(teningur);
          return teningur;
    }
    
    public int getTeningur() {
        return teningur;
    }
    
    public void setPropGildi(int i) {
        propGildi.set(i);
    }
    
    public SimpleIntegerProperty getPropGildi() {
        return propGildi;
    }
}
