
package is.hi.ludo.vinnsla;

import is.hi.ludo.utlit.TeningurController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;

/**
 * Leikmaður hefur auðkenni (id), veit hve mörg peð eru í heimahöfn, hve mörg
 * peð eru í marki. Leikmaður veit hver teljari er fyrir eina peðið sem hann á.
 * Leikmaður veit hver upphafsreitur er á lúdóborði og lokareitur.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is  
 * @author Bryndís Rósa Sigurpálsdóttir brs58@hi.is
 * Háskóli Íslands
 */
public class LeikmadurImp implements Leikmadur {
    private final int FJOLDIPEDA = 4;    // fjöldi peða 
    private final int id;                // auðkenni leikmanns

    private int fjoldiIMarki;           // fjöldi peða sem eru komin í mark
    private int nuverandiReitur;        // afstæður reitur á borði 

    private final PedImp[] minPed;
    private PedImp nuverandiPed;
    private final PedImp bord[] = new PedImp[48]; //fyrir borðið sjálft
    private final PedImp bordH[] = new PedImp[6]; //fyrir heimahöfnina

    private final int upphafsReitur;    // uppphafsreitur á lúdóborði 
    private final int lokaReitur;       // lokareitur (leikmanna)

    // Properties
    private final SimpleIntegerProperty propId;
    private final SimpleIntegerProperty propFjoldiIHeimreid
            = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty propFjoldiIHeimahofn
            = new SimpleIntegerProperty(FJOLDIPEDA);

    /**
     * Býr til leikmann með auðkenni id, upphafsriet upphaf og fjölda reita loka
     *
     * @param id
     * @param upphaf
     * @param loka
     * @param fjoldiPeda
     */
    public LeikmadurImp(int id, int upphaf, int loka, int fjoldiPeda) {
        this.id = id;
        propId = new SimpleIntegerProperty(id);
        upphafsReitur = upphaf;
        lokaReitur = loka;
        minPed = new PedImp[fjoldiPeda];

        for (int i = 0; i < fjoldiPeda; i++) {
            minPed[i] = new PedImp(i, upphaf, loka);
        }
        nuverandiPed = minPed[0];
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
    public int getFjoldiIHeimahofn() {
        return propFjoldiIHeimahofn.get();
    }

    @Override
    public void setFjoldiIHeimahofn(int fjoldiIHeimahofn) {
        this.propFjoldiIHeimahofn.set(fjoldiIHeimahofn);
    }

    public SimpleIntegerProperty getPropFjoldiIHeimahofn() {
        return propFjoldiIHeimahofn;
    }
     @Override
    public void setFjoldiIHeimreid(int fjoldiIHeimreid) {
        this.propFjoldiIHeimreid.set(fjoldiIHeimreid);
    }
    public SimpleIntegerProperty getPropFjoldiIHeimreid() {
        return propFjoldiIHeimreid;
    }
    
    @Override
    public int getFjoldiIMarki() {
        return fjoldiIMarki;
    }
    /**
     * Sendir leikmann áfram á borði. en athugar hvort leikmaður sé komin í heimreið
     * @param reitur
     * @param fjReitaAfram 
     */
    @Override
    public void aframABord(int reitur, int fjReitaAfram) {
        PedImp ped = finnaPed(reitur);
        bord[reitur] = null;
        if (ped.kominnIHeimreid()) {
            int afangi = ped.getNuverandiReitur() - 47;
            bordH[afangi] = ped;
        } else {
            bord[(reitur + fjReitaAfram) % 48] = ped;
        }
    }
    /**
     * boolean breyta sem skilar true ef peðið er komið í mark í heimreið
     * @param reitur
     * @return skilar true eða false
     */
    @Override
    public boolean kominnIMarkHeimreid(int reitur) {
        PedImp ped = finnaPedHeimreid(reitur);
        return ped.kominnIMark();
    }
    /**
     * Boolean breyta sem skilar true ef komið er í heimreið
     * @param reitur
     * @return skilar true eða false
     */
    
    @Override
    public boolean kominnIHeimreid(int reitur) {
        PedImp ped = finnaPed(reitur);
        return ped.kominnIHeimreid();
    }
    /**
     * Sendir leikmann afram í heimreið
     * @param reitur
     * @param fjReitaAfram 
     */
    @Override
    public void aframABordHeimreid(int reitur, int fjReitaAfram) {
        PedImp ped = finnaPedHeimreid(reitur);
        bordH[reitur] = null;
        int afangi = ped.getNuverandiReitur()-47;
        bordH[afangi] = ped;
    }
    /**
     * setter fyrir fjölda í marki
     * @param fjoldiIMarki 
     */
    @Override
    public void setFjoldiIMarki(int fjoldiIMarki) {
        this.fjoldiIMarki = fjoldiIMarki;
    }
    /**
     * Nær í upphafsreit
     * @return upphafsReitur 
     */
    @Override
    public int getUpphafsReitur() {
        return upphafsReitur;
    }
    /**
     * Leikmadur leikmaður er settur á heimareit
     */
    
     @Override
    public void aHeimareit() {
        PedImp ped;
        if(minPed[0].iHeimahofn())
            ped=minPed[0];
        else if(minPed[1].iHeimahofn())
            ped=minPed[1];
        else if(minPed[2].iHeimahofn())
            ped=minPed[2];
        else
            ped = minPed[3];
        
        ped.setIHeimahofn(0);
        bord[upphafsReitur] = ped;
    }

    /**
     * Fjöldi peða á borði
     *
     * @return fjölda á borði
     */
    @Override
    public int getABordi() {
        return FJOLDIPEDA - fjoldiIMarki - propFjoldiIHeimahofn.get()- propFjoldiIHeimreid.get();
    }
    /**
     * Nær í fjöldann  í heimreið
     * @return fjöldiíheimreið
     */
     @Override
    public int getABordiHeimreid() {
        return propFjoldiIHeimreid.get();
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
         if (propFjoldiIHeimahofn.get() > 0) {
            propFjoldiIHeimahofn.set(propFjoldiIHeimahofn.get() - 1);
            if (minPed[0].iHeimahofn()==true && bord[upphafsReitur] == minPed[0])
                minPed[0].setNuverandiReitur(0);
            else if (minPed[1].iHeimahofn()==true && bord[upphafsReitur] == minPed[1])
                minPed[1].setNuverandiReitur(0);
            else if (minPed[2].iHeimahofn()==true && bord[upphafsReitur] == minPed[2])
                minPed[2].setNuverandiReitur(0);
            else
                minPed[3].setNuverandiReitur(0);
            return propFjoldiIHeimahofn.get();
         } else {
             return -1;
         }
}
    
    /**
     *aðferð til að leita af peði
     * @param reitur
     * @return minped[0], minPed[1], minPed[2] eða minPed[3] eftir því sem við á
     */
    @Override
      public PedImp finnaPed(int reitur){
        if (bord[reitur] == minPed[0])
            return minPed[0];
        else if (bord[reitur] == minPed[1])
            return minPed[1];    
        else if (bord[reitur] == minPed[2])
            return minPed[2];    
        else
            return minPed[3];  
    }
    /**
     * Hækkar fjölda peða í marki um einn
     *
     * @return fjoldaIMarki
     */
    @Override
    public int iMark(int reitur) {
        PedImp ped = finnaPed(reitur);
        ped.iMark();
        bord[reitur]= null;
        fjoldiIMarki = fjoldiIMarki + 1;
        return fjoldiIMarki;
    }
    /**
     * Athugar hversu margir eru í marki í heimreið
     * @param reitur
     * @return fjoldiIMarki 
     */
     @Override
    public int iMarkHeimreid(int reitur) {
        PedImp ped = finnaPedHeimreid(reitur);
        ped.iMark();
        bordH[reitur]= null;
        fjoldiIMarki = fjoldiIMarki + 1;
         propFjoldiIHeimreid.set(propFjoldiIHeimreid.get() - 1);
        return fjoldiIMarki;
    }
    
    /**
     *leitar af peðum i heimreiðum 
     * @param reitur
     * @return skilar peði
     */
    @Override
    public PedImp finnaPedHeimreid(int reitur){
        if (bordH[reitur] == minPed[0])
            return minPed[0];
        else if (bordH[reitur] == minPed[1])
            return minPed[1];    
        else if (bordH[reitur] == minPed[2])
            return minPed[2];    
        else
            return minPed[3];  
    }
    /**
     * Fallið núlstillir gamla, millireitinn þegar það lendir á óvissureit
     * @param var
     * @param verdur
     * @param milliReitur 
     */
    @Override
    public void ovissa(int var,int verdur,int milliReitur){
        PedImp ped=finnaPed(var);
        ped.ovissa(verdur);
        bord[var]=null;
        bord[milliReitur]=null;
        bord[verdur] = ped;
        
    }
    /**
     * Færir peðið um fjölda reita áfram í heimreið
     * @param reitur
     * @param fjReitaAfram 
     */
    
    @Override
    public void aframHeimreid(int reitur, int fjReitaAfram) {
        PedImp ped = finnaPedHeimreid(reitur);
        ped.afram(fjReitaAfram);
    }

    /**
     * Færir eina peð leikmanns áfram um fjReitaAfram
     *
     * @param reitur
     * @param fjReitaAfram
     */
    @Override
    public void afram(int reitur, int fjReitaAfram) {
        PedImp ped = finnaPed(reitur);
        ped.afram(fjReitaAfram);
    }
    /**
     * Sækir peð sem var á reit áður ef svo er. 
     * @param nrReits
     * @return null eða peðo 
     */
    @Override
    public PedImp iArekstri(int nrReits) {
        return bord[nrReits];
    }
    /**
     * skilar peði sem lendir í árekstri við peðið eða núll ef engin árekstur hefur orðið
     * @param nrReits
     * @return null eða peði
     */
     @Override
    public PedImp iArekstriHeimreid(int nrReits) {
        return bordH[nrReits];
    }
    /**
     * Segir til um hvort eina peð leikmanns er komið í mark
     * @param reitur
     * @return true ef eina peð leikmanns er komið í mark annars false 
     */
    @Override
    public boolean kominnIMark(int reitur) {
        PedImp ped = finnaPed(reitur);
        return ped.kominnIMark();
    }
    /**
     * núllstillir reit
     * @param nrReits 
     */
    @Override
    public void hreinsa(int nrReits){
        bord[nrReits]=null;
    }
    /**
     * Hækkar fjölda peða í heimahöfn um einn
     * @param nrReits
     */
    @Override
    public void iHeimahofn(int nrReits) {
          bord[nrReits]=null;
        propFjoldiIHeimahofn.set(propFjoldiIHeimahofn.get() + 1);
     
    }
    /**
     * Hækkar fjölda peða í heimreið um einn
     * @param nrReits 
     */
      @Override
    public void iHeimahofnHeimreid(int nrReits) {
        bordH[nrReits] = null;
        propFjoldiIHeimahofn.set(propFjoldiIHeimahofn.get() + 1);
    }
    
}
