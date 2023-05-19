/*
Ebba Þóra Hvannberg ebba@hi.is
 */
package is.hi.ludo.vinnsla;

import is.hi.ludo.utlit.LudoBordController;

/**
 * Vinnsluklasi fyrir lúdó borð. Inniheldur leikmenn, núverandi leikmann og lúdó
 * borð með 48 reitum. Lúdóborð veit hvaða peð eru á borðinu. Klasi sér um að
 * leika peði fram um fjölda reita og athuga hvort peð er komið í mark; athuga
 * hvort hefur orðið árekstur; setja peð á upphafsreit; ná í öll peð leikmanns.
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 * @author Bryndís Rósa Sigurpálsdóttir brs58@hi.is
 */
public class LudoBordImp implements LudoBord {

    private final LeikmadurImp[] leikmenn;         // fylki af leikmönnum
    private LeikmadurImp nuverandiLeikmadur;       // leikmaður sem á að gera
    private final LeikmadurImp bord[] = new LeikmadurImp[48]; // lúdó borðið af peðum
    private final LeikmadurImp bordH[] = new LeikmadurImp[6]; //lúdó borð fyrir heimreið

    /**
     * Smiður sem býr til fjLeikmanna og setur núverandi leikmann sem þann
     * leikmann sem er í fyrsta sætinu
     *
     * @param fjLeikmanna fjöldi leikmanna sem á að búa til
     * @param fjPeda
     */
    public LudoBordImp(int fjLeikmanna, int fjPeda) {
        leikmenn = new LeikmadurImp[fjLeikmanna];
        for (int i = 0; i < fjLeikmanna; i++) {
            leikmenn[i] = new LeikmadurImp(i, i * 12, 53, 4);
        }
        nuverandiLeikmadur = leikmenn[0];
    }

    /**
     * Nær í öll peð í heimreið
     *
     * @param leikmadur
     * @return ollPedHeim
     */

    public int[] getOllPedIHeimreid(LeikmadurImp leikmadur) {
        int[] ollPedHeim = new int[leikmadur.getABordiHeimreid()];
        int i = 0;
        for (int j = 0; j < bordH.length; j++) {
            if (bordH[j] == leikmadur) {
                ollPedHeim[i++] = j;
            }
        }
        return ollPedHeim;
    }

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
    @Override
    public int leika(LeikmadurImp leikmadur, int indexABordi, int fjReitaAfram) {
        leikmadur.afram(indexABordi, fjReitaAfram);
        if (leikmadur.kominnIMark(indexABordi)) {
            bord[indexABordi] = null;
            leikmadur.iMark(indexABordi);
            return fjoldiimarkiekkifjorir(leikmadur);
        } else if (leikmadur.kominnIHeimreid(indexABordi)) {
            int afangi = leikmadur.finnaPed(indexABordi).getNuverandiReitur() - 47;
            leikmadur.aframABord(indexABordi, fjReitaAfram);
            bord[indexABordi] = null;
            bordH[afangi] = leikmadur;
            return 1000 + afangi;

        } else {
            leikmadur.aframABord(indexABordi, fjReitaAfram);
            bord[indexABordi] = null;
            int afangi = afangi(indexABordi, fjReitaAfram);
            bord[afangi] = leikmadur;
            return afangi;
        }
    }
    /**
     * athugar hvor fjöldinn í marki er 4 ef svo er skilar fallið 100 annars -1
     * @param leikmadur
     * @return 100 eða -1
     */

    private int fjoldiimarkiekkifjorir(LeikmadurImp leikmadur) {
        if (leikmadur.getFjoldiIMarki() != 4) {
            return 100;
        } else {
            return -1;
        }
    }

    /**
     * Skilar áfangareit sem er fenginn er með því að leggja saman i og j og
     * taka módulus 24
     *
     * @param i
     * @param j
     * @return áfangareit
     */
    @Override
    public int afangi(int i, int j) {
        // System.out.println("prentum afanga"+((i+j)%48))
        return (i + j) % 48;
    }

    /**
     * SiAkilar leikmanni ef peð lendir í árekstri við peð af öðrum lit
     *
     * @param leikmadur
     * @param nrReits
     * @return leikmaðurinn sem á peðið sem er rekist á annars null
     */
    @Override
    public LeikmadurImp iArekstri(LeikmadurImp leikmadur, int nrReits) {
        return bord[nrReits];
    }

    /**
     * Skilar leikmanni sem á að gera næst. Notaður er index frá 0-1 sem vísar á
     * fylki sem inniheldur alla leikmenn. Byrjað er á rauðum og svo koll af
     * kolli
     *
     * @return leikmaður sem á að gera næst
     */
    @Override
    public LeikmadurImp naesti() {
        int i = nuverandiLeikmadur.getId();
        i = (i + 1) % 4;
        nuverandiLeikmadur = leikmenn[i];
        return nuverandiLeikmadur;
    }

    /**
     * Leikmaður leikmadur er settur á heimareit
     *
     * @param leikmadur
     * @return skilar upphafsreit leikmanns
     */
    @Override
    public int aHeimareit(LeikmadurImp leikmadur) {
        bord[leikmadur.getUpphafsReitur()] = leikmadur;
        leikmadur.aHeimareit();
        return leikmadur.getUpphafsReitur();
    }

    /**
     * Nær í indexa á öll peð leikmanns
     *
     * @param leikmadur
     * @return fylki með indexum á öll peð leikmanns
     */
    @Override
    public int[] getOllPed(LeikmadurImp leikmadur) {
        int[] ollPed = new int[leikmadur.getABordi()];
        int i = 0;
        for (int j = 0; j < bord.length; j++) {
            if (bord[j] == leikmadur) {
                ollPed[i++] = j;
            }
        }
        return ollPed;
    }

    /**
     * Nær í indexa á öll peð leikmanns
     *
     * @param leikmadur
     * @return ollPedHofn
     */
    @Override
    public int[] getOllPedIHeimahofn(LeikmadurImp leikmadur) {
        int[] ollPedHofn = new int[leikmadur.getABordi()];
        int i = 0;
        for (int j = 0; j < bordH.length; j++) {
            if (bordH[j] == leikmadur) {
                ollPedHofn[i++] = j;
            }
        }
        return ollPedHofn;
    }

    /**
     * nær í upphafsreit hjá leikmanni
     *
     * @param leikmadur
     * @return upphafsreiti leikmanns
     */
    @Override
    public int getUpphafsReitur(LeikmadurImp leikmadur) {
        return leikmadur.getUpphafsReitur();
    }

    /**
     * Forritsbútur þessi tekur  inn áfanga og gáir að því hvort hann passar við tölurnar
     * sem passa við reitina á óvæntu reitunum ef það á við er returnar tölunni sem þau verða sent á
     * annars er returnar -1
     *
     * @param afangi
     * @return 27,10,5,3,19 eða -1
     */
    @Override
    public int ovaent(int afangi) {
        switch (afangi) {
            case 13:
                return 27;
            case 8:
                return 10;
            case 20:
                return 5;
            case 32:
                return 3;
            case 45:
                return 19;
            default:
                return -1;
        }
    }

    /**
     * Leikur peði áfram í heimreið, athugar hvort peð sé komið í mark og hvort
     * það séu komin 4 peð í mark
     *
     * @param leikmadur
     * @param indexABordi
     * @param fjReitaAfram
     * @return leikmaduraframabordiiheimreid(leikmadur, indexABordi,
     * fjReitaAfram)
     */
    @Override
    public int leikaHeimreid(LeikmadurImp leikmadur, int indexABordi, int fjReitaAfram) {
        leikmadur.aframHeimreid(indexABordi, fjReitaAfram);
        if (leikmadur.kominnIMarkHeimreid(indexABordi)) {
            bordH[indexABordi] = null;
            leikmadur.iMarkHeimreid(indexABordi);
            return fjoldiimarkiekkifjorir(leikmadur);
        } else {
            return leikmaduraframabordiiheimreid(leikmadur, indexABordi, fjReitaAfram);
        }
    }

    /**
     * Leikur peði áfram í heimreið
     *
     * @param leikmadur
     * @param indexABordi
     * @param fjReitaAfram
     * @return afangi+1000
     */
    private int leikmaduraframabordiiheimreid(LeikmadurImp leikmadur, int indexABordi, int fjReitaAfram) {
        leikmadur.aframABordHeimreid(indexABordi, fjReitaAfram);
        bordH[indexABordi] = null;
        int afangi = afangiIHeimreid(indexABordi, fjReitaAfram);
        bordH[afangi] = leikmadur;
        return afangi + 1000;
    }

    /**
     * Skilarleikmanni sem lendir í árekstri við peðið
     *
     * @param leikmadur
     * @param nrReits
     * @return borhH[nrReits]
     */
    @Override
    public LeikmadurImp iArekstriHeimreid(LeikmadurImp leikmadur, int nrReits) {
        return bordH[nrReits];
    }

    /**
     * Skilar áfangareit sem er fenginn er með því að leggja saman i og j og
     * taka módulus 6
     * @param i
     * @param j
     * @return áfanga
     */
    @Override
    public int afangiIHeimreid(int i, int j) {
        return (i + j) % 6;
    }
    /**
     * Fallið athugar hvort leikmaður sé kominn í mark
     * annars ferð það áfram um reiti.
     * @param leikmadur
     * @param var
     * @param milliReitur
     * @param verdur
     * @param fjReitaAfram
     * @return afanga
     */

    @Override
    public int leikaovissu(LeikmadurImp leikmadur, int var, int milliReitur, int verdur, int fjReitaAfram) {
        leikmadur.afram(var, fjReitaAfram);
        if (leikmadur.kominnIMark(var)) {
            return leikmadurkominimark(var, leikmadur);
        } else {
            leikmadur.ovissa(var, verdur, milliReitur);
            bord[var] = null;
            bord[milliReitur] = null;
            int afanginn = verdur;
            bord[afanginn] = leikmadur;
            return afanginn;
        }
    }
/**
 * Leikmaður kominn í mark og er því hækkaður fjöldi í markinu
 * @param var
 * @param leikmadur
 * @return 
 */
    private int leikmadurkominimark(int var, LeikmadurImp leikmadur) {
        bord[var] = null;
        leikmadur.iMark(var);
        return fjoldiimarkiekkifjorir(leikmadur);
    }
/**
 * Athugar hvort árekstur hefur orðið ef svo er þá skilar hann true annars false
 * @param leikmadur
 * @param leikmadurped
 * @param nrReits
 * @return true eða false 
 */
    @Override
    public boolean athugaArekstur(LeikmadurImp leikmadur, PedImp leikmadurped, int nrReits) {
        LeikmadurImp leikari = bord[nrReits];
        if (leikari != null) {
            PedImp ped = bord[nrReits].iArekstri(nrReits);
            if (ped != null && ped != leikmadurped) {
                ped.sendaIHeimahofn();
                leikari.iHeimahofn(nrReits);
                bord[nrReits] = null;
                return true;
            }
        }
        return false;
    }

    /**
     *Boolean fallið hér fyrir neðan athugar árekstur í heimreið
     * @param leikmadur
     * @param leikmadurped
     * @param nrReits
     * @return true eða false
     */
    @Override
    public boolean athugaAreksturHeimreid(LeikmadurImp leikmadur, PedImp leikmadurped, int nrReits) {
        LeikmadurImp leikmadurinn = bordH[nrReits];
        if (leikmadurinn != null) {
            PedImp ped = bordH[nrReits].iArekstriHeimreid(nrReits);
            if (ped != null && ped != leikmadurped) {
                ped.sendaIHeimahofn();
                leikmadurinn.iHeimahofnHeimreid(nrReits);
                bordH[nrReits] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Nær í leikmann l
     *
     *@param l
     *
     * @return leikmaður l
     */
    @Override
    public LeikmadurImp getLeikmadur(int l) {
        return leikmenn[l];
    }

    @Override
    public LeikmadurImp getNuverandiLeikmadur() {
        return nuverandiLeikmadur;
    }

}
