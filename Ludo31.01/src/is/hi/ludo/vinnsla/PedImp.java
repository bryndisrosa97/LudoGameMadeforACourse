/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.ludo.vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Bryndís Rósa Sigurpálsdóttir, Háskóli Íslands, brs58@hi.is
 */
public class PedImp implements Ped{
    private final int id;                // auðkenni peðs
    
    private int iMarki;           // fjöldi peða sem eru komin í mark
    private int nuverandiReitur;        // afstæður reitur á borði 0-23

    private final int upphafsReitur;    // uppphafsreitur á lúdóborði 
    private final int lokaReitur;       // lokareitur (23 fyrir 2 leikmenn)

    // Properties
    private final SimpleIntegerProperty propId;
    private final SimpleIntegerProperty propIHeimahofn = new SimpleIntegerProperty(1);

    /**
     * Býr til leikmann með auðkenni id, upphafsreit upphaf og fjölda reita loka
     *
     * @param id
     * @param upphaf
     * @param loka
     */
    public PedImp(int id, int upphaf, int loka) {
        this.id = id;
        propId = new SimpleIntegerProperty(id);
        upphafsReitur = upphaf;
        lokaReitur = loka;
    }

    // Getters og setters 
    @Override
    public int getId() {
        return id;
    }

    public SimpleIntegerProperty getPropId() {
        return propId;
    }

    @Override
    public int getIHeimahofn() {
        return propIHeimahofn.get();
    }
    
    @Override
    public void setIHeimahofn(int IHeimahofn) {
        this.propIHeimahofn.set(IHeimahofn);
    }
    
    public SimpleIntegerProperty getPropIHeimahofn() {
        return propIHeimahofn;
    }
    
    @Override
    public int getIMarki() {
        return iMarki;
    }
    
    @Override
    public void setIMarki(int iMarki) {
        this.iMarki = iMarki;
    }
    
    @Override
    public int getUpphafsReitur() {
        return upphafsReitur;
    }
    
    /**
     * Setur peð úr heimahöfn og á reit 0 ef eitthvert peð er eftir Núllstillir
     * núverandi reit peðs
     *
     * @return -1 ef ekkert peð er í heimahöfn annars fjölda í heimahöfn eftir
     * að peð hefur verið fært úr heimahöfn. Núverandi reitur eina peðs
     * leikmanns er upphafsreitur.
     */
    @Override
    public int urHeimahofn() {
        if (propIHeimahofn.get() > 0) {
            propIHeimahofn.set(propIHeimahofn.get() - 1);
            nuverandiReitur = 0;
            return propIHeimahofn.get();
        } else {
            return -1;
        }
    }
    
    /**
     * Hækkar fjölda peða í marki um einn
     *
     * @return
     */
    @Override
    public int iMark() {
        iMarki = iMarki + 1;
        return iMarki;
    }
    
    /**
     * Færir eina peð leikmanns áfram um fjReitaAfram
     *
     * @param fjReitaAfram
     */
    @Override
    public void afram(int fjReitaAfram) {
        nuverandiReitur = nuverandiReitur + fjReitaAfram;
    }
    /**
     *Fallið skoðar hvort fjReita er stærra en  upphafsreiturinn
     * til að geta núllstillað til að fara upp í heimahöfn.
     * @param fjReitaAfram 
     */
    @Override
    public void ovissa(int fjReitaAfram) {
        if (fjReitaAfram > upphafsReitur) {
            nuverandiReitur = fjReitaAfram - upphafsReitur;
        } else {
            nuverandiReitur = lokaReitur - 5 - upphafsReitur + fjReitaAfram + 1;
        }

        if (nuverandiReitur == 48)
            nuverandiReitur = 0;
    }
    //getters and setters
    
    @Override
    public int getNuverandiReitur() {
        return nuverandiReitur;
    }
    
    @Override
    public void setNuverandiReitur(int reitur){
        nuverandiReitur = 0;
    }
    
    /**
     * Segir til um hvort  peð leikmanns er komið í mark
     *
     * @return true ef eina peð leikmanns er komið í mark annars false
     */
    @Override
    public boolean kominnIMark() {
        return nuverandiReitur > lokaReitur;
    }
    /**
     * Segir til um hvort peð leikmanns er komið í heimreið
     * @return true ef eina peð leikmanns er komið í mark annars false
     */
    @Override
    public boolean kominnIHeimreid() {
        return nuverandiReitur > (lokaReitur-5);
    }
    /**
     * sendir í heimahöfn
     */
    @Override
    public void sendaIHeimahofn() {
        propIHeimahofn.set(propIHeimahofn.get() + 1);
        nuverandiReitur = 0;
    }
    
    /**
     * Hækkar fjölda peða í heimahöfn um einn
     * @return true eða false
     */
    @Override
    public boolean iHeimahofn() {

        return propIHeimahofn.get() != 0;

    }

}



