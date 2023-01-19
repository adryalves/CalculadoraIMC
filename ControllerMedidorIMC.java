import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class ControllerMedidorIMC implements Initializable {

    @FXML
    private Button botao;

    @FXML
    private TextField txtaltura;

    @FXML
    private Label txtimc;

    @FXML
    private Label txtimc1;

    @FXML
    private TextField txtpeso;

    @FXML
    private AnchorPane anchor;

    public void Calcular(ActionEvent event) {

        if (txtaltura.getText().isEmpty() || txtpeso.getText().isEmpty()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Informações incompletas");
            errorAlert.setContentText("É preciso preencher a altura e o peso para saber seu IMC ");
            errorAlert.showAndWait();
        } else {
            float altura = Float.parseFloat(txtaltura.getText());
            float peso = Float.parseFloat(txtpeso.getText());

            if (altura <= 0 || peso <= 0) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Informações inválidas");
                errorAlert.setContentText("Suas informações não estão válidas, confira-as e envie novamente ");
                errorAlert.showAndWait();
            }

            else {
                if (altura >= 100) {
                    altura = altura / 100; // Caso a pessoa digite, por ex: 175 cm, ao invés de 1,75 metros, o programa
                                           // converte essa altura para metros e realiza o cálculo
                }

                float imc = peso / (altura * altura);
                float resimc = (float) Math.round(imc * 100) / 100;
                txtimc1.setText("Seu IMC é: ");
                txtimc.setStyle(" -fx-border-color: #EB455F;");
                txtimc.setText(resimc + " ");

            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

}
