package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class uyelerController implements Initializable {
int id;
private Connection connect;
private DBConnection dbveri=new DBConnection();
private PreparedStatement pst;
ObservableList<tableview> list=FXCollections.observableArrayList();
@FXML
private AnchorPane uyeSayfasi;

@FXML
private TableView<tableview> uye_table;

@FXML
private TableColumn<tableview, String> ad_sutun;

@FXML
private TableColumn<tableview,String> soyad_sutun;
@FXML
private TableColumn<tableview,Integer> id_kolon;

@FXML
private TableColumn<tableview,String> tel_sutun;

@FXML
private TableColumn<tableview,String> tarih_sutun;

@FXML
private TableColumn<tableview,String> amac_sutun;

    @FXML
    void uyeEkle(ActionEvent event) {
    	uyeSayfasi.getScene().getWindow().hide();
		 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/uyeEkleSayfasi.fxml"));
		 Parent root=null;
		 uyeEkleController main=null;
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
public void id(int a) {
	id=a;
	
		
	}

public void alert(String message) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Bilgi Mesajý");
	alert.setContentText(message);

	alert.showAndWait();
}

    @FXML
    void uye_sil(ActionEvent event) {
    	int idsi=uye_table.getSelectionModel().getSelectedItem().getId();
    	connect=dbveri.getconnection();
		String sql="delete from uye where id=?";
		try {
			pst=connect.prepareStatement(sql);
			pst.setInt(1,idsi);
			int rs =pst.executeUpdate();
			if(rs==1) {
				alert("Silme Ýþlemi Baþarýlý");
				uye_table.getItems().clear();
				tablo();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
		
		tablo();
	}
	public void tablo() {
		connect=dbveri.getconnection();
		String sql="select * from uye";
		
		ResultSet rs;
		
			try {
				rs = connect.createStatement().executeQuery(sql);
				while(rs.next()) {
					list.add(new tableview(rs.getString("uye_ad"), rs.getString("amac"), rs.getString("uye_soyad"), rs.getString("uye_tel"), rs.getString("tarih"),rs.getInt("id")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	ad_sutun.setCellValueFactory(new PropertyValueFactory<>("ad"));
	amac_sutun.setCellValueFactory(new PropertyValueFactory<>("amac"));
	soyad_sutun.setCellValueFactory(new PropertyValueFactory<>("soyad"));
	tel_sutun.setCellValueFactory(new PropertyValueFactory<>("tel"));
	tarih_sutun.setCellValueFactory(new PropertyValueFactory<>("tarih"));
	id_kolon.setCellValueFactory(new PropertyValueFactory<>("id"));
	uye_table.setItems(list);
	
	}
	@FXML
    void programlar(ActionEvent event) {
		String program_num= uye_table.getSelectionModel().getSelectedItem().getAmac();
		int idsi=uye_table.getSelectionModel().getSelectedItem().getId();
		uyeSayfasi.getScene().getWindow().hide();
		 FXMLLoader loader=new FXMLLoader(getClass().getResource("/FXML/uyeProgramSayfasi.fxml"));
		 Parent root=null;
		 uyeProgramController main=null;
		 try {
			 root=loader.load();
			 main=loader.getController();
	main.id(idsi, program_num);
			Stage stage=new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
