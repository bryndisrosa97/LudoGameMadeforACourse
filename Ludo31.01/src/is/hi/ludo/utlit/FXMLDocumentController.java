
package is.hi.ludo.utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


/**
 * Aðal Controller forritsins. Sér um valmyndir 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class FXMLDocumentController implements Initializable {
    @FXML
   public LudoBordController adalController;
    //@FXML
    //public DialogPaneController dialogController;
    @FXML
    private MenuItem leidbeiningar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }
   
/**
 * Hægt að loka forriti
 * @param event 
 */

    @FXML
    private void haettaHandler(ActionEvent event) {
        
        Platform.exit();
        System.exit(0);
    }
}
    

