package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class uyeProgramController implements Initializable{
	 @FXML
	    private AnchorPane program_sayfasi;

	    @FXML
	    private Label ad;

	    @FXML
	    private Label soyad;

	 

	    @FXML
	    private Label program;

	    @FXML
	    private Label protein;

	    @FXML
	    private Label karbon;

	    @FXML
	    private Label yag_gr;

	    @FXML
	    private Label kilo;
	    private Connection connect;
	    private DBConnection dbveri=new DBConnection();
	    private PreparedStatement pst;
	public void id(int a,String program_num) {
		 String sql="select * from uye where id=?";
			connect=dbveri.getconnection();
			int programNum=Integer.parseInt(program_num);
			
				try {
					pst=connect.prepareStatement(sql);
					pst.setInt(1,a);
					ResultSet rs =pst.executeQuery();
					if(rs.next()) {
						int kiloInt=rs.getInt("kilo");
						ad.setText(rs.getString("uye_ad"));
						soyad.setText(rs.getString("uye_soyad"));
						kilo.setText(rs.getString("kilo"));
						program.setText(rs.getString("amac"));
						if(programNum==1)
						{
							protein.setText(String.valueOf(kiloInt*2));
							karbon.setText(String.valueOf(kiloInt*4));
							yag_gr.setText(rs.getString("kilo"));
						}
						else if(programNum==2) {
							protein.setText(String.valueOf(kiloInt*3));
							karbon.setText(String.valueOf(kiloInt*2));
							yag_gr.setText(rs.getString("kilo"));
						}
						else if(programNum==3) {
							protein.setText(String.valueOf(kiloInt*3));
							karbon.setText(String.valueOf(kiloInt*2));
							yag_gr.setText(String.valueOf(kiloInt/2));
						}
							
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
			
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
