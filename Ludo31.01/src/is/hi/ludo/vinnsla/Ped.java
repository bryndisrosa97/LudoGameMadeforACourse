/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.ludo.vinnsla;


/**
 *
 * @author Bryndís Rósa Sigurpálsdóttir, Háskóli Íslands, brs58@hi.is
 */
interface Ped {
    //nær í id á peði
    int getId();
    //*nær í peð í heimahöfn
    int getIHeimahofn();
    //setter fyrir heimahöfn
    void setIHeimahofn(int fjoldiIHeimahofn);
    //nær í fjölda í marki
    int getIMarki();
   //settar fyrir fjölda í marki
    void setIMarki(int iIMarki);
 // nær í upphafsreit
    public int getUpphafsReitur(); 
    
    /**
     * Setur peð úr heimahöfn og á reit 0 ef eitthvert peð er eftir
     * Núllstillir núverandi reit peðs
     * @return -1 ef ekkert peð er í heimahöfn annars fjölda í heimahöfn
     * eftir að peð hefur verið fært úr heimahöfn. Núverandi reitur eina peðs
     * leikmanns er upphafsreitur.
     */
    int urHeimahofn();
    
     /**
     * Hækkar fjölda peða í marki um einn
     * @return skilar fjölda peða í marki
     */
    int iMark();
    
    /**
     * Færir eina peð leikmanns áfram um fjReitaAfram
     * @param fjReitaAfram
     */
    void afram(int fjReitaAfram);
    /**
     * Fallið skoðar hvort fjReita er stærra en  upphafsreiturinn
     * til að geta núllstillað til að fara upp í heimahöfn.
     * @param fjReitaAfram 
     */
    void ovissa(int fjReitaAfram);
    boolean kominnIHeimreid();
    /**
     * nær í nuverandi reit
     * @return nuverandi reitur
     */
    int getNuverandiReitur();
    //setter
    void setNuverandiReitur(int reitur);
    
    /**
     * Segir til um hvort eina peð leikmanns er komið í mark
     * @return true ef eina peð leikmanns er komið í mark annars false
     */
    boolean kominnIMark();
    /**
     * sendir peð í heimahöfn
     */
    void sendaIHeimahofn();
    
    /**
     * Hækkar fjölda peða í heimahöfn um einn
     */
    boolean iHeimahofn();
}
