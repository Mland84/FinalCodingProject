package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.net.aso.a;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {
	
	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML TextField txtIncome;
	@FXML TextField txtHouseCost;
	@FXML TextField txtExpenses;
	@FXML Label lblMortgagePayment;
	@FXML ComboBox cbx;
	@FXML Label lblCreditScore;
	@FXML Label lblMortgageAmt;
	@FXML Label lblIncome;
	@FXML Label lblHouseCost;
	@FXML Label lblExpenses;
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
	cbx.getItems().add("15");
	cbx.getItems().add("30");
	
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		LoanRequest lq = new LoanRequest();
	
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setdRate(Double.parseDouble(txtHouseCost.getText()));
		lq.setdRate(Double.parseDouble(txtHouseCost.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiTerm(Integer.parseInt(cbx.getPromptText()));
		
		
				
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lrequest)
	{
	
		
		Action a = new Action(eAction.CalculatePayment);
	
		double PITI = lrequest.getIncome()*.28;
		
		if (PITI==lrequest.getIncome()*.36-lrequest.getExpenses()){
			txtMortgageAmt.setText(Double.toString(lrequest.getdPayment()));
		}
		else{
			txtMortgageAmt.setText("House Cost Too High!");
		}
	
		
		
		
		
		
	}
}
