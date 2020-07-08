package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controllers.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class uyeEkleController implements Initializable {
    @FXML
    private AnchorPane uye_eklee;

	    @FXML
	    private TextField uye_adi;

	    @FXML
	    private TextField uye_soyad;

	    @FXML
	    private TextField uye_tel;

	    @FXML
	    private TextField yas;

	    @FXML
	    private TextField boy;

	    @FXML
	    private TextField kilo;

	    @FXML
	    private TextField yag_oran;
	    public void alert(String message) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Bilgi Mesajý");
	    	alert.setContentText(message);

	    	alert.showAndWait();
	    }
	    @FXML
	    void kayit_ekle(ActionEvent event) {
	    	String amac="";
	    	int a= Integer.parseInt(yag_oran.getText());
	    	
	    	String sorgu="insert into uye (uye_ad,uye_soyad,uye_tel,kullanici_id,boy,kilo,amac,yas)"
	    			+ "Values(?,?,?,?,?,?,?,?)";
			connect=dbveri.getconnection();
		
				try {
					pst=connect.prepareStatement(sorgu);
					pst.setString(1, uye_adi.getText());
					pst.setString(2, uye_soyad.getText());
					pst.setString(3, uye_tel.getText());
					pst.setInt(4, id);
					pst.setString(5, boy.getText());
					pst.setString(6, kilo.getText());
					if(a<=15) 
						amac="1";
					else if(a<20)
						amac="2";
					else if(a>20)
						amac="3";
					pst.setString(7, amac);
					pst.setString(8, yas.getText());
					int rs=pst.executeUpdate();
					if(rs==1) {
						alert("Kayýt Baþarýlý");
						uye_eklee.getScene().getWindow().hide();
						 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/uyelerSayfasi.fxml"));
						 Parent root=null;
						 uyelerController main=null;
						 try {
							 root=loader.load();
							 main=loader.getController();
					main.id(id);
							Stage stage=new Stage();
							stage.setScene(new Scene(root));
							stage.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

	    }
	    
	    
	    
	
	
	private Connection connect;
	private DBConnection dbveri=new DBConnection();
	private PreparedStatement pst;
	int id=0;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	
	
	
	public void id(int a) {
		id=a;
		
	}
	
}
