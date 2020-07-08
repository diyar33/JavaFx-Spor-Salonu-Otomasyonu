package Controllers;

import java.io.IOException;
import Controllers.DBConnection;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	
	
	@FXML
    private PasswordField sifretext;
	
	 @FXML
	    private AnchorPane Login;

    @FXML
    private TextField kullanicitext;
    
    @FXML
    private ImageView hareketlikol;


    @FXML
    void cikisbuton(ActionEvent event) {

    }

    @FXML
    void girisbuton(ActionEvent event) {

    }

    @FXML
    void hatirlabuton(ActionEvent event) {

    }

    @FXML
    void sifreunuttumbuton(ActionEvent event) {

    }
	
    private DBConnection handler;
	private Connection connection;
	private PreparedStatement pst;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		kullanicitext.setStyle("-fx-text-inner-color: #a0a2ab;");
		sifretext.setStyle("-fx-text-inner-color: #a0a2ab;");
		handler = new DBConnection();
	}
	
	@FXML
	public void girisbutonAction(ActionEvent e) throws IOException
	{ 
		
		
		
		
		
		connection = handler.getconnection();
		String q1 = "SELECT * from kullanici WHERE adi=? and sifre=?" ;
		
		
		
		
		try {
			pst=connection.prepareStatement(q1);
			pst.setString(1, kullanicitext.getText());
			pst.setString(2, sifretext.getText());
			ResultSet rs=pst.executeQuery();
		
				
			if(rs.next())
			{
				int a=rs.getInt("id");
				System.out.print("Giriþ Baþarýlý.");
				Login.getScene().getWindow().hide();
				 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/uyelerSayfasi.fxml"));
				 Parent root=null;
				 uyelerController main=null;
					 root=loader.load();
					 main=loader.getController();
			main.id(a);
					Stage stage=new Stage();
					stage.setScene(new Scene(root));
					stage.show();
			
				
			}
			else
			{
				System.out.print("Yanlýþ Bilgi Girildi.");
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		finally
		{
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
    @FXML
    void cikisbuton1(ActionEvent event) {
    	Platform.exit();

    }
	
	
	
	

}
