package is.hi.ludo.utlit;

import is.hi.ludo.vinnsla.LeikmadurImp;
import is.hi.ludo.vinnsla.LudoBordImp;
import is.hi.ludo.vinnsla.PedImp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Aðalcontrollerinn fyrir lúdóborðið
 *
 * @author Bryndís Rósa Sigurpálsdóttir brs58@hi.is
 */
public class LudoBordController implements Initializable {

    @FXML
    TeningurController teningurController;  // tenging í teningscontroller
    LeikmadurImp leikmadur;  // tenging í klassan LeikmadurImp

    private Button hnapparBord[];          // lúdóborð fyrir reitina 
    private Button heimreid1[];           // heimreið1 fyrir reitina fyrir rauða
    private Button heimreid2[];           //heimreid2 fyrir reitina fyrir bláa
    private Button heimreid3[];          //heimreid3 fyrir reitina fyrir græna
    private Button heimreid4[];          //heimreid4 fyrir reitina fyrir gula
    private LudoBordImp ludoBord;           // vinnsluhlutur fyrir lúdóborð   
    private final String litur[] = {"red", "blue", "green", "yellow"}; // fylki með litunum á peðunum
    private Label[] mork;                   // mörkin fyrir leikmenn
    private Button[] heimaHafnir;           // heimahafnir fyrir leikmenn 
    int tvisarsexa = 0;                       //breyta sem telur hversu oft 6 kemur upp

    // hér koma hnapparnir fyrir borðið
    @FXML
    private Button b11;
    @FXML
    private Button b17;
    @FXML
    private Button b16;
    @FXML
    private Button b9;
    @FXML
    private Button b14;
    @FXML
    private Button b15;
    @FXML
    private Button b12;
    @FXML
    private Button b23;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b10;
    @FXML
    private Button b13;
    @FXML
    private Button b4;
    @FXML
    private Button b3;
    @FXML
    private Button b2;
    @FXML
    private Button b1;
    @FXML
    private Button b0;
    @FXML
    private Button b18;
    @FXML
    private Button b19;
    @FXML
    private Button b20;
    @FXML
    private Button b21;
    @FXML
    private Button b22;
    @FXML
    private Button b5;
    @FXML
    private Button b29;
    @FXML
    private Button b26;
    @FXML
    private Button b24;
    @FXML
    private Button b25;
    @FXML
    private Button b28;
    @FXML
    private Button b27;
    @FXML
    private Button b33;
    @FXML
    private Button b31;
    @FXML
    private Button b32;
    @FXML
    private Button b34;
    @FXML
    private Button b35;
    @FXML
    private Button b41;
    @FXML
    private Button b40;
    @FXML
    private Button b39;
    @FXML
    private Button b30;
    @FXML
    private Button b38;
    @FXML
    private Button b37;
    @FXML
    private Button b36;
    @FXML
    private Button b42;
    @FXML
    private Button b43;
    @FXML
    private Button b44;
    @FXML
    private Button b45;
    @FXML
    private Button b46;
    @FXML
    private Button b47;

    // hér koma mörkin
    @FXML
    private Label gMark;
    @FXML
    private Label rMark;
    @FXML
    private Label blarMark;
    @FXML
    private Label gulurMark;
    //hér koma heimreiðarnar
    @FXML
    private Button jRH;
    @FXML
    private Button jGH;
    @FXML
    private Button jblrrh;
    @FXML
    private Button jgulurh;

    //hnappar fyrir heimreiðirnar
    @FXML
    private Button g57;
    @FXML
    private Button g56;
    @FXML
    private Button g59;
    @FXML
    private Button g55;
    @FXML
    private Button g58;
    @FXML
    private Button g54;
    @FXML
    private Button b60;
    @FXML
    private Button b61;
    @FXML
    private Button b62;
    @FXML
    private Button b63;
    @FXML
    private Button b64;
    @FXML
    private Button b65;
    @FXML
    private Button g71;
    @FXML
    private Button g70;
    @FXML
    private Button g69;
    @FXML
    private Button g68;
    @FXML
    private Button g67;
    @FXML
    private Button g66;
    @FXML
    private Button r53;
    @FXML
    private Button r52;
    @FXML
    private Button r51;
    @FXML
    private Button r50;
    @FXML
    private Button r49;
    @FXML
    private Button r48;

    //labelinn sem voru notuð
    @FXML
    private Label hvadattuadgera;
    @FXML
    private Label hverGerir;

    @FXML
    private Label ovaenturReitur;
    @FXML
    private Label tenningur;

    private final SimpleIntegerProperty propFjoldiReitaAfram
            = new SimpleIntegerProperty(0); //hlutstari sem heldur utan um hversu margir reitir voru farnir áfram
    private final SimpleIntegerProperty[] propIHeimahofn
            = new SimpleIntegerProperty[4]; //hlutstari sem heldur utan um fjölfan í heimahofn
    private final SimpleIntegerProperty propIxLeikmadur //hlutsari sem veit hvað hann á að gera
            = new SimpleIntegerProperty(0);

    /**
     * Frumstillir controller, setur tengingar í teningscontroller, setur upp
     * vinnslu, setur upp properties fyrir heimahafnir og leikmann
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teningurController.setLudoController(this);
        tenningur.setText("smelltu á teninginn");
        ludoBord = new LudoBordImp(4, 4);
        propIHeimahofn[0] = ludoBord.getLeikmadur(0).getPropFjoldiIHeimahofn(); //hlustari um fjöldann í heimahofn
        propIHeimahofn[1] = ludoBord.getLeikmadur(1).getPropFjoldiIHeimahofn(); //hlutstari um fjöldann í heimahöfn
        propIHeimahofn[2] = ludoBord.getLeikmadur(2).getPropFjoldiIHeimahofn(); //hlutstari um fjöldann í heimahöfn
        propIHeimahofn[3] = ludoBord.getLeikmadur(3).getPropFjoldiIHeimahofn(); // hlustari um fjöldann í heimahöfn
        leikmadur = ludoBord.getNuverandiLeikmadur(); //nýr í frá ludoborði í núverandi leikmann
        propIxLeikmadur.set(leikmadur.getId());  //hlutsari
        // Viðmótshlutir settir í fylki til hægðarauka. Fylkið hér fyrir neðan er borðið sjálft
        hnapparBord = new Button[]{
            b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16,
            b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34,
            b35, b36, b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47
        };

        heimreid1 = new Button[]{r48, r49, r50, r51, r52, r53}; //heimreiðin hjá rauður
        heimreid2 = new Button[]{b60, b61, b62, b63, b64, b65}; //heimreiðin hjá bláum
        heimreid3 = new Button[]{g59, g58, g57, g56, g55, g54};  //heimreiðin hjá grænim
        heimreid4 = new Button[]{g66, g67, g68, g69, g70, g71}; // heimreiðin hjá gulum
        mork = new Label[]{rMark, blarMark, gMark, gulurMark}; // fylki með mörkunum
        heimaHafnir = new Button[]{jRH, jblrrh, jGH, jgulurh}; //fylkin með heimahöfnum

        //  Bind og properties - hér þarf að passa að breyturnar skipti ekki um hlut
        //  annars þarf að endur-binda
        //  Ekki má virkja eða afvirkja handvirkt, þ.e. fyrir utan bind setninguna
        //bætti við 4 í staðinn fyrir 1 þarf að laga þetta svo 
        //and(pro))).not());pIHeimahofn[1]>0.and(propIxLeikmadur.isEqualTo(1
        heimaHafnir[3].disableProperty().bind(propFjoldiReitaAfram.isEqualTo(6).
                and(propIHeimahofn[3].greaterThan(0).and(propIxLeikmadur.isEqualTo(3))).not());
        heimaHafnir[2].disableProperty().bind(propFjoldiReitaAfram.isEqualTo(6).
                and(propIHeimahofn[2].greaterThan(0).and(propIxLeikmadur.isEqualTo(2))).not());
        heimaHafnir[1].disableProperty().bind(propFjoldiReitaAfram.isEqualTo(6).
                and(propIHeimahofn[1].greaterThan(0).and(propIxLeikmadur.isEqualTo(1))).not());
        heimaHafnir[0].disableProperty().bind(propFjoldiReitaAfram.isEqualTo(6).
                and(propIHeimahofn[0].greaterThan(0).and(propIxLeikmadur.isEqualTo(0))).not());

    }

    /**
     * Handler fyrir það þegar leikmaður vill leika peði áfram um
     * propFjoldiReitaAfram. athugað hvort færsla veldur árekstri eða lendir á
     * óvæntum reit og unnið úr því. Annars er peðið fært áfram
     *
     * @param event
     */
    @FXML
    private void reiturHandler(ActionEvent event) {
        Button b = (Button) event.getSource();
        geraOllPedOvirk(); //óvirkjar öll peð 
        int i = Integer.valueOf(b.getId()); // tala á tenningi 
        PedImp ped = leikmadur.finnaPed(i); //finnur rétta peðið
        afReit(b); //færir peð á borði
        int afangi = ludoBord.afangi(i, propFjoldiReitaAfram.get());  //Skilar áfangareit sem er fenginn er með því að leggja saman i og jog taka módulus 48 
        int ovaenttala = ludoBord.ovaent(afangi);  //breytan ovaentala geymir í sér annaðhvort einhverja tölu eða -1 ef hún lenti ekki á óvæntum reit
        LeikmadurImp leikmadurIArekstri = ludoBord.iArekstri(leikmadur, afangi);
        areksturareit(i, ped, afangi, leikmadurIArekstri); //athugar hvort peð lendi í árekstri
        eflenteraovissureitedaekki(ovaenttala, i, ped, afangi); //sendir í fall sem athugar hvort lendir á óvæntum reit
        propFjoldiReitaAfram.set(0); //stillir í 0 svo heimahöfnin hjá næsta leikmanni virkjast ekki.                        
    }

    /**
     * Athugar hvor peð lendir í árekstri bæði ef peð er í heimareið á bordi
     * Ef það lendir í áreksti er undið úr því að viðeigandi peð sent aftur 
     * í heimahöfn
     *
     * @param i
     * @param ped
     * @param afangi
     * @param leikmadurIArekstri
     */
    private void areksturareit(int i, PedImp ped, int afangi, LeikmadurImp leikmadurIArekstri) {
        if ((leikmadur.finnaPed(i).getNuverandiReitur() + propFjoldiReitaAfram.get()) < 47) {
            boolean iArekstri = ludoBord.athugaArekstur(leikmadur, ped, afangi);
            efareksturvinnaur(iArekstri, leikmadurIArekstri);

        } else if ((leikmadur.finnaPed(i).getNuverandiReitur() + propFjoldiReitaAfram.get()) < 53){
            int afangiHeimreid = (leikmadur.finnaPed(i).getNuverandiReitur() + propFjoldiReitaAfram.get()) % 47;
            LeikmadurImp leikmadurIArekstriH = ludoBord.iArekstriHeimreid(leikmadur, afangiHeimreid);
            boolean iArekstri = ludoBord.athugaAreksturHeimreid(leikmadur, ped, afangiHeimreid);
            efareksturvinnaur(iArekstri, leikmadurIArekstriH);
        }
    }

    /**
     * Fallið skoðar hvort peð lendir á óvissureit ef svo er sendir hann peðið á
     * viðeigandi reit og athugar hvort sú færsla býður upp á árekstur ef svo er er 
     * peðið á þeim reit sent í heimahöfn
     * 
     *
     * @param ovaenttala
     * @param i
     * @param ped
     * @param afangi
     */
    private void eflenteraovissureitedaekki(int ovaenttala, int i, PedImp ped, int afangi) {
        if (ovaenttala != -1) {
            LeikmadurImp leikmadurIArekstri = ludoBord.iArekstri(leikmadur, ovaenttala);
            if ((leikmadur.finnaPed(i).getNuverandiReitur() + propFjoldiReitaAfram.get()) < 48) {
                boolean iArekstriOvaent = ludoBord.athugaArekstur(leikmadur, ped, ovaenttala);
                efareksturvinnaur(iArekstriOvaent, leikmadurIArekstri);
            }
            int j = ludoBord.leikaovissu(leikmadur, i, afangi, ovaenttala, propFjoldiReitaAfram.get());
            afangaReitur(j);
            if (j != -1 && j != 100) {
                ovaenturReitur.setText("Þú lendir á óvæntum reit og ferð á óvæntan reit");
            }
        } else {
            int j = ludoBord.leika(leikmadur, i, propFjoldiReitaAfram.get());
            afangaReitur(j);
        }
    }

    /**
     * Færir áfram á borði. Athugar hversu oft 6 hefur komið upp uppá það hvort
     * leikmaður megi gera aftur eða hvort skipta eigi eftir á næsta leikmann
     *
     * @param j
     */
    private void afangaReitur(int j) {
        if (j != -1 && j != 100 && j < 1000) {
            aReit(hnapparBord[j]); //færir hnapp á reit
            erkominnartvaersexur();
            teningurController.afVirkja(false); //hér virkjum við tenning
            tenningur.setText("smelltu á teninginn");
        } else if (j == -1) {
            iMark(); //uppfærir fjölda peða í marki
            hverGerir.setText("Þú vinnur - Leik er lokið");
        } else if (j >= 1000) {
            switch (leikmadur.getId()) {
                case 0:
                    aReit(heimreid1[j - 1000]);
                    break;
                case 1:
                    aReit(heimreid2[j - 1000]);
                    break;
                case 2:
                    aReit(heimreid3[j - 1000]);
                    break;
                default:
                    aReit(heimreid4[j - 1000]);
                    break;
            }

            if (propFjoldiReitaAfram.get() == 6 && tvisarsexa != 2) {
                tvisarsexa = 2;
                teningurController.afVirkja(false);
                hvadattuadgera.setText("þú fékkst 6 og getur gert aftur");
            } else {
                naestiGerir();
                synaHverGerir();
                hvadattuadgera.setText("þú er búin að fá 6 tvisar því fær næsti að gera");
            }
            teningurController.afVirkja(false);
        } else {
            iMark();
            naestiGerir();
            synaHverGerir();
            teningurController.afVirkja(false);
            tenningur.setText("smelltu á tenninginn");

        }
    }

    /**
     * Athugar hvaða tala kemur upp á tenninginn ef hún er 6 og leikmaður í
     * þetta skipti er bara búin að fá 6 einu sinni getur hann kastað aftur
     */
    private void erkominnartvaersexur() {
        if ((propFjoldiReitaAfram.get() == 6) && (tvisarsexa != 2)) {
            tvisarsexa += 2;
            teningurController.afVirkja(false);    
            hvadattuadgera.setText("Þú fékkst sexu og mátt gera aftur");
            tenningur.setText("smelltu á teninginn");  
        } else {
            hvadattuadgera.setText("þú er búin að fá tvisar sexu á því að gera");
            naestiGerir(); //skippar yfir á næsta
            synaHverGerir();
            
        }
    }

    /**
     * Ef leikmaður lendir í árekstri við leikmadurIArekstri þá er sá sendur í
     * heimahöfn
     *
     * @param leikmadurIArekstri
     */
    private void vinnaUrArekstri(LeikmadurImp leikmadurIArekstri) {
        if (leikmadurIArekstri != null) {
            setHeimahofn(leikmadurIArekstri);
        }
    }

    /**
     * Næsti leikmaður á leik. Uppfærum property fyrir id leikmanns og getum öll
     * peð óvirk ásamt því núllstillum við breytuna okkar tvisarsexa
     */
    protected void naestiGerir() {
        geraOllPedOvirk();
        leikmadur = ludoBord.naesti();
        propIxLeikmadur.set(leikmadur.getId());
        tvisarsexa = 0;
    }

    /**
     * Sýnir í notendaviðmóti hvaða leikmaður gerir
     */
    private void synaHverGerir() {
        System.out.println("er í synaHverGerir");
        hverGerir.setStyle("-fx-background-color:"
                + litur[leikmadur.getId()]);
    }

    /**
     * Gerir öll peð leikmanns virk. Hér virkjast allt
     */
    private void geraOllPedVirk() {
        int[] oll = ludoBord.getOllPed(leikmadur);
        for (int i : oll) {
            hnapparBord[i].setDisable(false);
            hvadattuadgera.setText("Smelltu á peð eða heimahöfn ef hún er virk");
        }
        int[] heimreid = ludoBord.getOllPedIHeimreid(leikmadur);
        switch (leikmadur.getId()) {
            case 0:
                for (int j : heimreid) {
                    heimreid1[j].setDisable(false);
                }
                break;
            case 1:
                for (int j : heimreid) {
                    heimreid2[j].setDisable(false);
                }
                break;
            case 2:
                for (int j : heimreid) {
                    heimreid3[j].setDisable(false);
                }
                break;
            default:
                for (int j : heimreid) {
                    heimreid4[j].setDisable(false);
                }
                break;
        }
    }

    /**
     * Gerir öll peð leikmanns virk óvirk. Hér virkjast allt
     */
    private void geraOllPedOvirk() {
        int[] oll = ludoBord.getOllPed(leikmadur);
        for (int i : oll) {
            hnapparBord[i].setDisable(true);
            hvadattuadgera.setText(" ");
        }
        int[] heimreid = ludoBord.getOllPedIHeimreid(leikmadur);
        switch (leikmadur.getId()) {
            case 0:
                for (int j : heimreid) {
                    heimreid1[j].setDisable(true);
                }
                break;
            case 1:
                for (int j : heimreid) {
                    heimreid2[j].setDisable(true);
                }
                break;
            case 2:
                for (int j : heimreid) {
                    heimreid3[j].setDisable(true);
                    System.out.println(j);
                }
                break;
            default:
                for (int j : heimreid) {
                    heimreid4[j].setDisable(true);
                }
                break;
        }
    }

    /**
     * Færir peð á reit b
     *
     * @param b reitur sem færa á peð á
     */
    private void aReit(Button b) {
        System.out.println("er í aReit");
        b.setStyle("-fx-background-color: " + litur[leikmadur.getId()]);
    }

    /**
     * Færir peð b af reit og gerir þann reit óvirkan
     *
     * @param b reitur sem færa á peð af
     */
    private void afReit(Button b) {
        System.out.println("Er í afReit");
        switch (Integer.valueOf(b.getId())) {
            case 0:
                b.setStyle("-fx-background-color: " + "red");
                break;
            case 12:
                b.setStyle("-fx-background-color: " + "blue");
                break;
            case 24:
                b.setStyle("-fx-background-color: " + "green");
                break;
            case 36:
                b.setStyle("-fx-background-color: " + "yellow");
                break;
            default:
                b.setStyle("-fx-background-color: " + "#D3D3D3");
                break;
        }
        b.setDisable(true);

    }

    /**
     * Færir peð á heimreið og gerir það hnappinn óvirkan sem þetta fór af
     */
    private void afReitHeimreid(Button b) {
        System.out.println("Er í afReit");
        int i = Integer.valueOf(b.getId());
        switch (leikmadur.getId()) {
            case 0:
                b.setStyle("-fx-background-color: " + "yellow");
                break;
            case 1:
                b.setStyle("-fx-background-color: " + "blue");
                break;
            case 2:
                b.setStyle("-fx-background-color: " + "green");
                break;
            default:
                b.setStyle("-fx-background-color: " + "red");
                break;
        }
        b.setDisable(true);
    }

    /**
     * Uppfærir fjölda peða í marki í viðmóti
     */
    protected void iMark() {
        int m = leikmadur.getFjoldiIMarki();
        mork[leikmadur.getId()].setText("" + m);
    }

    /**
     * Handler fyrir heimahöfn. Notandi ýtir á hnapp til að setja peð úr
     * heimahöfn og á heimareit. Heimahöfn er gerð óvirk. Næsti á að gera
     *
     * @param event atburður frá annarri hvorri heimahöfninni
     */
    @FXML
    private void heimaHofnHandler(ActionEvent event) {
        geraOllPedOvirk();
        Button b = (Button) event.getSource();
        int l = Integer.valueOf(b.getId());
        LeikmadurImp leik = ludoBord.getLeikmadur(l);
        int upphafsreitur = ludoBord.getUpphafsReitur(leik);
        boolean IArekstriOvaent = ludoBord.athugaArekstur(leikmadur, null, upphafsreitur);
        LeikmadurImp leikmadurIArekstriheima = ludoBord.iArekstri(leikmadur, upphafsreitur);
        efareksturiheimahofn(IArekstriOvaent, leikmadurIArekstriheima);
        int a = ludoBord.aHeimareit(leik);
        leik.urHeimahofn();
        teningurController.afVirkja(true);
        tenningur.setText(" ");
        propIHeimahofn[leik.getId()].set(leik.getFjoldiIHeimahofn());
        aReit(hnapparBord[a]);
        setHeimahofn(leik);
        propFjoldiReitaAfram.set(0); // setja fjöldi reita áfram í 0 til að heimahöfn næsta leikmanns virkist ekki
        teningurController.afVirkja(false);
        tenningur.setText("smelltu á tenninginn");
        tvisarsexa += 2;
        tvisarsexaiheimahofn();
    }

    /**
     * telur hversu of sexa hefur komið. Ef hún hefur komið áður gerir næsti
     * aftur
     */
    private void tvisarsexaiheimahofn() {
        if (tvisarsexa == 2) {
            teningurController.afVirkja(false);
            tenningur.setText("smelltu á tenninginn");
        } else {
            naestiGerir();
            synaHverGerir();
            teningurController.afVirkja(false);
            tenningur.setText("smelltu á tenninginn");
        }
    }

    /**
     * Athugar hvort það sé árekstur í heimahöfn og sendir það
     *
     * @param IArekstriOvaent
     * @param leikmadurIArekstriheima
     */
    private void efareksturiheimahofn(boolean IArekstriOvaent, LeikmadurImp leikmadurIArekstriheima) {
        if (IArekstriOvaent) {
            hvadattuadgera.setText("her er árekstur í heimh0fn");
            vinnaUrArekstri(leikmadurIArekstriheima);
        }
    }

    /**
     * Teningi hefur verið kastað og fjöldi reita áfram er i. Ef hægt er að
     * virkja heimahöfn er það gert Annars ef ekkert peð er á borði fær næsti
     * leikmaður að gera. Annars eru öll peð leikmanns gerð virk
     *
     * @param i fjöldi reita
     */
    void setFjReitaAfram(int i) {
        ovaenturReitur.setText(" ");
        propFjoldiReitaAfram.set(i);
        if (!virkjaHeimaHofn(i) && leikmadur.getABordi() == 0 && leikmadur.getABordiHeimreid() == 0) {
            naestiGerir();
            synaHverGerir();
            teningurController.afVirkja(false);
            tenningur.setText("smelltu á tenninginn");
        } else {
            teningurController.afVirkja(true);
            tenningur.setText("");
            geraOllPedVirk();
        }
    }

    /**
     * Uppfærir fjolda í heimahöfn leikmanns leikmadur
     *
     * @param leikmadur
     */
    private void setHeimahofn(LeikmadurImp leikmadur) {
        heimaHafnir[leikmadur.getId()].setText(String.valueOf(leikmadur.getFjoldiIHeimahofn()));
    }

    /**
     * Athugað hvort hægt er að virkja heimahöfn miðað við teningakast i. Skilar
     * true ef teningakast er 6 og eitthvert peð er í heimahöfn.
     *
     * @param i gildi á teningi
     * @return true ef virkja á heimahöfn annars false
     */
    private boolean virkjaHeimaHofn(int i) {
        System.out.println("er í virkjaheimaHofn");
        if (i == 6 && leikmadur.getFjoldiIHeimahofn() > 0 && tvisarsexa != 4) {
            hvadattuadgera.setText("heimahöfn er orðin virk, þú getur smellt á hana");
            return true;
        }
        return false;
    }

    /**
     * Handler fyrir það þegar leikmaður vill leika peði áfram um
     * propFjoldiReitaAfram. athugað hvort færsla veldur árekstri  og unnið úr því.
     * Annars er peðið fært áfram
     *
     * @param event
     */
    @FXML
    private void heimreidhandler(ActionEvent event) {
        Button b = (Button) event.getSource();
        geraOllPedOvirk();
        int i = Integer.valueOf(b.getId()) - 1;
        PedImp ped = leikmadur.finnaPedHeimreid(i);
        afReitHeimreid(b);
        int afangi = ludoBord.afangiIHeimreid(i, propFjoldiReitaAfram.get());
        LeikmadurImp leikmadurIArekstri = ludoBord.iArekstriHeimreid(leikmadur, afangi);
        if ((leikmadur.finnaPedHeimreid(i).getNuverandiReitur() + propFjoldiReitaAfram.get()) < 54) {
            boolean iArekstri = ludoBord.athugaAreksturHeimreid(leikmadur, ped, afangi);
            efareksturvinnaur(iArekstri, leikmadurIArekstri);
        }
        int j = ludoBord.leikaHeimreid(leikmadur, i, propFjoldiReitaAfram.get());
        afangaReitur(j);
        // setja fjöldi reita áfram í 0 til að heimahöfn næsta leikmanns virkist ekki
        propFjoldiReitaAfram.set(0);

    }

    /**
     * Vinnur úr árekstri
     *
     * @param iArekstri
     * @param leikmadurIArekstri
     */
    private void efareksturvinnaur(boolean iArekstri, LeikmadurImp leikmadurIArekstri) {
        if (iArekstri) {
            vinnaUrArekstri(leikmadurIArekstri);
            hvadattuadgera.setText("hér varð árekstur því var hitt peðið sent í heimahöfn");
        }
    }

}
    

