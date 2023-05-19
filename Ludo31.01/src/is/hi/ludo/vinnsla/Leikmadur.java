
package is.hi.ludo.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Leikmaður hefur auðkenni (id), veit hve mörg peð eru í heimahöfn, hve mörg peð
 * eru í marki. Leikmaður veit hver teljari er fyrir eina peðið sem hann á. 
 * Leikmaður veit hver upphafsreitur er á lúdóborði og lokareitur.
 * @author Ebba Þóra Hvannberg ebba@hi.is 

 * Háskóli Íslands
 */
public interface Leikmadur {

    /**
     * Færir eina peð leikmanns áfram um fjReitaAfram
     * @param reitur
     * @param fjReitaAfram
     */
    void afram(int reitur,int fjReitaAfram);
    
    /**
     * Leikmadur leikmaður er settur á heimareit
     */
    public void aHeimareit();
    //setter
    void setFjoldiIHeimreid(int fjoldiIHeimreid);
    /**
     * athugar hvort leikmaður var fyrir á borðinu ef svo er er honum skilar
     * @param nrReits
     * @return leikmanni eða null
     */
    PedImp iArekstri(int nrReits);
    /**
     * Finnur peð
     * @param reitur
     * @return peðið 
     */
    PedImp finnaPed(int reitur);

    /**
     * Fjöldi peða á borði
     * @return
     */
    int getABordi();

      // Getters og setters
    PedImp iArekstriHeimreid(int nrReits);
    int getFjoldiIHeimahofn();

    int getFjoldiIMarki();

  
    int getId();

    int getUpphafsReitur();
    
    void setFjoldiIHeimahofn(int fjoldiIHeimahofn);

    void setFjoldiIMarki(int fjoldiIMarki);

    /**
     * Hækkar fjölda peða í heimahöfn um einn
     * @param nrReits
     */
    void iHeimahofn(int nrReits);
    /**
     * skilar afanga 
     * @param reitur
     * @param fjReitaAfram
     * @param afangi 
     */
    void ovissa(int reitur,int fjReitaAfram,int afangi);
    /**
     * Sendir leikmenn afram á borði
     * @param reitur
     * @param fjReitaAfram 
     */
    void aframABordHeimreid(int reitur, int fjReitaAfram);
    /** 
     * boolean fall hvort peð sé komið i heimreið
     * @param reitur
     * @return true eða false 
     */
     boolean kominnIHeimreid(int reitur);
     /**
      * 
      * @param reitur
      * @return true eða false
      */
     boolean kominnIMarkHeimreid(int reitur);
     /**
      * Hækkar fjölda peða í heimreið um einn
      * @param nrReits 
      */
     void iHeimahofnHeimreid(int nrReits);

    /**
     * Hækkar fjölda peða í marki um einn
     * @param reitur
     * @return skilar fjölda peða í marki
     */
    int iMark(int reitur);
    
    void aframHeimreid(int reitur, int fjReitaAfram);
    int getABordiHeimreid();
    void hreinsa(int nrReits);
    PedImp finnaPedHeimreid(int reitur);
    public void aframABord(int reitur, int fjReitaAfram);
    public int iMarkHeimreid(int reitur);

    /**
     * Segir til um hvort eina peð leikmanns er komið í mark
     * @return true ef eina peð leikmanns er komið í mark annars false
     */
    boolean kominnIMark(int reitur);

    

    /**
     * Setur peð úr heimahöfn og á reit 0 ef eitthvert peð er eftir
     * Núllstillir núverandi reit peðs
     * @return -1 ef ekkert peð er í heimahöfn annars fjölda í heimahöfn
     * eftir að peð hefur verið fært úr heimahöfn. Núverandi reitur eina peðs
     * leikmanns er upphafsreitur.
     */
    int urHeimahofn();
    
}
