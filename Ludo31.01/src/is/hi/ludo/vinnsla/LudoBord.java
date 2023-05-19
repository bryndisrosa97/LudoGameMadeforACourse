/*
Ebba Þóra Hvannberg ebba@hi.is
 */
package is.hi.ludo.vinnsla;

/**
 * Vinnsluklasi fyrir lúdó borð. Inniheldur leikmenn, núverandi leikmann
 * og lúdó borð með 24 reitum. Lúdóborð veit hvaða peð eru á borðinu. Klasi sér um að 
 * leika peði fram um fjölda reita og athuga hvort peð er komið í mark; 
 * athuga hvort hefur orðið árekstur; setja peð á upphafsreit; ná í öll peð
 * leikmanns. 
 * 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public interface LudoBord {

    /**
     * Leikmaður leikmadur er settur á heimareit
     *
     * @param leikmadur
     * @return skilar upphafsreit leikmanns
     */
    int aHeimareit(LeikmadurImp leikmadur);

    /**
     * Skilar áfangareit sem er fenginn er með því að leggja saman i og j
     * og taka módulus 24
     * @param i
     * @param j
     * @return áfangareit
     */
    int afangi(int i, int j);
    /**
     * nær í upphafsreit
     * @param leikmadur
     * @return upphafsreitur 
     */
    int getUpphafsReitur(LeikmadurImp leikmadur);
    /**
     * boolean fall sem athugar hvort árekstur hefur orðið
     * @param leikmadur
     * @param leikmadurped
     * @param nrReits
     * @return 
     */
     boolean athugaArekstur(LeikmadurImp leikmadur,PedImp leikmadurped, int nrReits);
     
      //PedImp iArekstrifyrirped(LeikmadurImp leikmadur, int nrReits);
    /**
     * Nær í leikmann l
     *
     * @param l
     * @return leikmaður l
     */
    LeikmadurImp getLeikmadur(int l);
    /**
     * nær í núverandi leikamann
     * @return 
     */

    LeikmadurImp getNuverandiLeikmadur();

    /**
     * Nær í indexa á öll peð leikmanns
     *
     * @param leikmadur
     * @return fylki með indexum á öll peð leikmanns
     */
    int[] getOllPed(LeikmadurImp leikmadur);
    /**
     * athugar árekstur í heimreið
     * @param leikmadur
     * @param leikmadurped
     * @param nrReits
     * @return skilar true eða false
     */
    
    boolean athugaAreksturHeimreid(LeikmadurImp leikmadur, PedImp leikmadurped, int nrReits);
    /**
     * nær í öll peð í heimahöfn
     * @param leikmadur
     * @return öll peð í heimahöfn
     */
    int[] getOllPedIHeimahofn(LeikmadurImp leikmadur);
    /**
     * sendir peð áfram í heimreið
     * @param leikmadur
     * @param indexABordi
     * @param fjReitaAfram
     * @return reitir afram
     */
    int leikaHeimreid(LeikmadurImp leikmadur, int indexABordi, int fjReitaAfram);
    /**
     * tekur módul af i og j
     * @param i
     * @param j
     * @return 
     */
    int afangiIHeimreid(int i, int j);
    /**
     * athugar hvort einhver var fyrr á reitinum
     * @param leikmadur
     * @param nrReits
     * @return leikmanni eða null
     */
    
    LeikmadurImp iArekstriHeimreid(LeikmadurImp leikmadur, int nrReits);
    /**
     * Skilar leikmanni ef peð lendir í árekstri við  peð af öðrum lit
     *
     * @param leikmadur
     * @param nrReits
     * @return leikmaðurinn sem á peðið sem er rekist á annars null
     */
    LeikmadurImp iArekstri(LeikmadurImp leikmadur, int nrReits);
    
   

    /**
     * Leikur peði leikmanns leikmadur frá indexABordi fjReitaAfram og skilar
     * áfangareit á borði. Skilar -1 ef leikmaður er kominn í mark. Forskilyrði
     * er að það sé ekki leikmaður fyrir á borði
     *
     * @param leikmadur leikmaður sem er að gera
     * @param indexABordi núverandi index á borði
     * @param fjReitaAfram fjölda reita áfram sem á að fara
     * @return -1 ef leikmaður er kominn í mark en annars áfangareit á borði
     */
    int leika(LeikmadurImp leikmadur, int indexABordi, int fjReitaAfram);
    /**
     * leikur peði leikmanns leikmadur frá indexABordi fjReitaAfram og skilar
     * áfangareit á borði. Forskilyrði
     * er að það sé ekki leikmaður fyrir á borði
     * 
     * @param leikmadur
     * @param var
     * @param milliReitur
     * @param verdur
     * @param fjReitaAfram
     * @return áfangareit
     */

    int leikaovissu(LeikmadurImp leikmadur, int var, int milliReitur,int verdur,int fjReitaAfram);
    
  //  int frategarkastarerut(LeikmadurImp leikmadur, int indexABordi, int reitur);
            
    /**
     * Skilar leikmanni sem á að gera næst. Notaður er index frá 0-1 sem vísar á
     * fylki sem inniheldur báða leikmenn. Byrjað er á rauðum og svo koll af
     * kolli
     *
     * @return leikmaður sem á að gera næst
     */
    LeikmadurImp naesti();
    
      int ovaent(int afangi);
    
}
