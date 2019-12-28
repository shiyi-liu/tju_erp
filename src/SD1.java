import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.common.*;


public class SD1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtOrdName;
	private JTextField txtOrdPho;
	private JTextField txtOrdFax;
	private Integer cusID;
	private JTextField txtShipAddCity;
	private JTextField txtShipName;
	private JTextField txtShipAddRoad;
	private JTextField txtShipPho;
	private JTextField txtShipFax;
	private JTextField txtShipZip;
	private JTextField txtShipAddTown;
	private JTextField txtOrdZip;
	private JTextField txtFinName;
	private JTextField txtFinAcc;
	private JTextField txtFinAdd;
	private JTextField txtFinBank;
	
	private JComboBox<?> comboShipAddPro;
	
	private JRadioButton rbMetRail;
	private JRadioButton rbMetTru;
	private JRadioButton rbMetSep;
	private JRadioButton rbMetWat;
	
	private JButton btnSub;
	private JButton btnClear;
	private JButton btnClose;
	
	
	public SD1(){
		setResizable(false);
		setTitle("创建新客户");
		setSize(943,521);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("127px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(0dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(21dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("34px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("38px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label_1 = new JLabel("\u8BA2\u8D27\u5355\u4F4D\uFF1A");
		label_1.setFont(new Font("STZhongsong", Font.BOLD, 16));
		getContentPane().add(label_1, "3, 2");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		getContentPane().add(separator, "9, 2, 1, 15");
		
		JLabel labShip = new JLabel("\u6536\u8D27\u5355\u4F4D\uFF1A");
		getContentPane().add(labShip, "11, 2");
		labShip.setFont(new Font("STZhongsong", Font.BOLD, 16));
		labShip.setBackground(Color.LIGHT_GRAY);
		labShip.setForeground(Color.BLACK);
		
		JLabel labOrdName = new JLabel("\u540D\u79F0");
		getContentPane().add(labOrdName, "3, 4, right, default");
		
		txtOrdName = new JTextField();
		getContentPane().add(txtOrdName, "5, 4, 3, 1");
		txtOrdName.setColumns(10);
		
		JLabel labShipName = new JLabel("\u540D\u79F0");
		getContentPane().add(labShipName, "11, 4, right, default");
		
		txtShipName = new JTextField();
		txtShipName.setColumns(10);
		getContentPane().add(txtShipName, "13, 4, 5, 1, fill, default");
		
		JComboBox<?> comboShipAddPro = new JComboBox();
		comboShipAddPro.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC\u5E02\uFF08\u4EAC\uFF09 ", "\u5929\u6D25\u5E02\uFF08\u6D25\uFF09 ", "\u4E0A\u6D77\u5E02\uFF08\u6CAA\uFF09 ", "\u91CD\u5E86\u5E02\uFF08\u6E1D\uFF09 ", "\u6CB3\u5317\u7701\uFF08\u5180\uFF09 ", "\u6CB3\u5357\u7701\uFF08\u8C6B\uFF09 ", "\u4E91\u5357\u7701\uFF08\u4E91\uFF09 ", "\u8FBD\u5B81\u7701\uFF08\u8FBD\uFF09 ", "\u9ED1\u9F99\u6C5F\u7701\uFF08\u9ED1\uFF09 ", "\u6E56\u5357\u7701\uFF08\u6E58\uFF09 ", "\u5B89\u5FBD\u7701\uFF08\u7696\uFF09 ", "\u5C71\u4E1C\u7701\uFF08\u9C81\uFF09 ", "\u65B0\u7586\u7EF4\u543E\u5C14\uFF08\u65B0\uFF09 ", "\u6C5F\u82CF\u7701\uFF08\u82CF\uFF09 ", "\u6D59\u6C5F\u7701\uFF08\u6D59\uFF09 ", "\u6C5F\u897F\u7701\uFF08\u8D63\uFF09 ", "\u6E56\u5317\u7701\uFF08\u9102\uFF09 ", "\u5E7F\u897F\u58EE\u65CF\uFF08\u6842\uFF09 ", "\u7518\u8083\u7701\uFF08\u7518\uFF09 ", "\u5C71\u897F\u7701\uFF08\u664B\uFF09 ", "\u5185\u8499\u53E4\uFF08\u8499\uFF09 ", "\u9655\u897F\u7701\uFF08\u9655\uFF09 ", "\u5409\u6797\u7701\uFF08\u5409\uFF09 ", "\u798F\u5EFA\u7701\uFF08\u95FD\uFF09 ", "\u8D35\u5DDE\u7701\uFF08\u8D35\uFF09 ", "\u5E7F\u4E1C\u7701\uFF08\u7CA4\uFF09 ", "\u9752\u6D77\u7701\uFF08\u9752\uFF09 ", "\u897F\u85CF\uFF08\u85CF\uFF09 ", "\u56DB\u5DDD\u7701\uFF08\u5DDD\uFF09 ", "\u5B81\u590F\u56DE\u65CF\uFF08\u5B81\uFF09 ", "\u6D77\u5357\u7701\uFF08\u743C\uFF09", "\u53F0\u6E7E\u7701\uFF08\u53F0\uFF09", "\u9999\u6E2F\u7279\u522B\u884C\u653F\u533A", "\u6FB3\u95E8\u7279\u522B\u884C\u653F\u533A"}));
		getContentPane().add(comboShipAddPro, "13, 6, fill, default");
		
		txtShipAddCity = new JTextField();
		txtShipAddCity.setText("\u5E02");
		txtShipAddCity.setColumns(10);
		getContentPane().add(txtShipAddCity, "15, 6, fill, default");
		
		txtShipAddTown = new JTextField();
		txtShipAddTown.setText("\u533A\u53BF");
		getContentPane().add(txtShipAddTown, "17, 6, fill, default");
		txtShipAddTown.setColumns(10);
		
		JLabel labOrdPho = new JLabel("\u7535\u8BDD");
		getContentPane().add(labOrdPho, "3, 6, right, default");
		
		txtOrdPho = new JTextField();
		getContentPane().add(txtOrdPho, "5, 6, 3, 1, fill, center");
		txtOrdPho.setColumns(10);
		
		JLabel labShipAdd = new JLabel("\u5730\u5740");
		getContentPane().add(labShipAdd, "11, 6, 1, 3, right, default");
		
		txtShipAddRoad = new JTextField();
		txtShipAddRoad.setText("\u5177\u4F53\u5730\u5740");
		getContentPane().add(txtShipAddRoad, "13, 8, 5, 1, fill, default");
		txtShipAddRoad.setColumns(10);
		
		txtOrdZip = new JTextField();
		getContentPane().add(txtOrdZip, "5, 10, 3, 1, fill, default");
		txtOrdZip.setColumns(10);
		
		JLabel label = new JLabel("\u7535\u8BDD");
		getContentPane().add(label, "11, 10, right, default");
		
		txtShipPho = new JTextField();
		getContentPane().add(txtShipPho, "13, 10, 5, 1, fill, default");
		txtShipPho.setColumns(10);
		
		JLabel labOrdFax = new JLabel("\u4F20\u771F");
		getContentPane().add(labOrdFax, "3, 8, right, fill");
		
		txtOrdFax = new JTextField();
		getContentPane().add(txtOrdFax, "5, 8, 3, 1");
		txtOrdFax.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		getContentPane().add(separator_3, "2, 12, 6, 1");
		
		JLabel label_10 = new JLabel("\u7269\u6D41\u65B9\u5F0F\uFF1A");
		label_10.setFont(new Font("STZhongsong", Font.BOLD, 16));
		getContentPane().add(label_10, "3, 14");
		
		rbMetRail = new JRadioButton("\u4E13\u5217");
		getContentPane().add(rbMetRail, "5, 14");
		
		rbMetTru = new JRadioButton("\u6574\u8F66");
		getContentPane().add(rbMetTru, "7, 14");
		
				
		JLabel label_4 = new JLabel("\u4F20\u771F");
		getContentPane().add(label_4, "11, 14, right, default");
		
		txtShipFax = new JTextField();
		getContentPane().add(txtShipFax, "13, 14, 5, 1, fill, default");
		txtShipFax.setColumns(10);
		
		JLabel labOrdZip = new JLabel("\u90AE\u7F16");
		getContentPane().add(labOrdZip, "3, 10, right, default");
		
		rbMetSep = new JRadioButton("\u96F6\u62C5");
		getContentPane().add(rbMetSep, "5, 16");
		
		rbMetWat = new JRadioButton("\u6C34\u8FD0");
		getContentPane().add(rbMetWat, "7, 16");
		
		ButtonGroup btng=new ButtonGroup();
		btng.add(rbMetTru);
		btng.add(rbMetRail);
		btng.add(rbMetSep);
		btng.add(rbMetWat);
		
		JLabel label_5 = new JLabel("\u90AE\u7F16");
		getContentPane().add(label_5, "11, 16, right, default");
		
		txtShipZip = new JTextField();
		getContentPane().add(txtShipZip, "13, 16, 5, 1, fill, default");
		txtShipZip.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "2, 18, 17, 1");
		
		JLabel label_2 = new JLabel("\u7ED3\u7B97\u5355\u4F4D\uFF1A");
		label_2.setFont(new Font("STZhongsong", Font.BOLD, 16));
		getContentPane().add(label_2, "3, 20");
		
		JLabel label_3 = new JLabel("\u540D\u79F0");
		getContentPane().add(label_3, "3, 22, right, default");
		
		txtFinName = new JTextField();
		getContentPane().add(txtFinName, "5, 22, 3, 1, fill, default");
		txtFinName.setColumns(10);
		
		JLabel label_6 = new JLabel("\u94F6\u884C\u8D26\u53F7");
		getContentPane().add(label_6, "11, 22, right, default");
		
		txtFinAcc = new JTextField();
		getContentPane().add(txtFinAcc, "13, 22, 5, 1, fill, default");
		txtFinAcc.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5355\u4F4D\u5730\u5740");
		getContentPane().add(label_7, "3, 24, right, default");
		
		txtFinAdd = new JTextField();
		getContentPane().add(txtFinAdd, "5, 24, 13, 1, fill, default");
		txtFinAdd.setColumns(10);
		
		JLabel label_8 = new JLabel("\u5F00\u6237\u94F6\u884C\u5730\u5740");
		getContentPane().add(label_8, "3, 26, right, default");
		
		txtFinBank = new JTextField();
		getContentPane().add(txtFinBank, "5, 26, 13, 1, fill, default");
		txtFinBank.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		getContentPane().add(separator_2, "2, 28, 17, 1");
		
		btnSub = new JButton("\u63D0\u4EA4");
		btnSub.addActionListener(this);
		getContentPane().add(btnSub, "7, 30, right, default");
		
		btnClear = new JButton("\u6E05\u7A7A");
		btnClear.addActionListener(this);
		getContentPane().add(btnClear, "11, 30, center, default");
		
		btnClose = new JButton("\u9000\u51FA");
		btnClose.addActionListener(this);
		getContentPane().add(btnClose, "13, 30, left, default");
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnSub){
			   try {
				toCreate();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		 }
		 if(e.getSource()==btnClear){
			 toClear();
		 }
		 if(e.getSource()==btnClose) {
			   System.exit(0);
		 }
	} 

	private void toClear() {
		txtOrdName.setText(null);
		txtOrdPho.setText(null);
		txtOrdFax.setText(null);
		txtOrdZip.setText(null);
		txtShipName.setText(null);
		txtShipPho.setText(null);
		txtShipFax.setText(null);
		txtShipAddCity.setText("市");
		txtShipZip.setText(null);
		txtShipAddRoad.setText("具体地址");
		txtShipAddTown.setText("区县");
		txtFinName.setText(null);
		txtFinAcc.setText(null);
		txtFinAdd.setText(null);
		txtFinBank.setText(null);
		comboShipAddPro.setSelectedIndex(-1);
		rbMetRail.setSelected(false);
		rbMetTru.setSelected(false);
		rbMetWat.setSelected(false);
		rbMetSep.setSelected(false);
	}

	public void toCreate() throws Exception{
		Customer cus = new Customer();
		Connection conn=DBconnection.getConn();
		
		java.sql.Statement stmt = conn.createStatement();  
        ResultSet rs = stmt.executeQuery("select 收货单位码 from 收货单位");  
        
        while (rs.next()) {  
            System.out.println(rs.getString(1));  
        }  
        rs.close();  
        stmt.close();  
        conn.close();  
        
		//get value of 3ID per DB former customer
		String sql=""+
				 "select 客户编号 from 客户主数据";
		/**
		if(conn!=null){
			PreparedStatement stmt=conn.prepareStatement(sql);
		}
		ResultSet rs=stmt.executeQuery();		
		rs.last();
		Integer formID = rs.getInt("客户编号");
		cusID = formID+1;
		Integer shipID = cusID*100+3;
		Integer finID = cusID*100+2;
		Integer ordID = cusID*100+1;
		*/
		//get value of radiobuttons(Method)
		String cusMethod;
		if (rbMetTru.isSelected()){
			cusMethod="整车";
		}else if (rbMetRail.isSelected()){
			cusMethod="专线";
		}else if (rbMetSep.isSelected()){
			cusMethod="零担";
		}else if (rbMetWat.isSelected()){
			cusMethod="水运";
		}else{
			cusMethod="无";
		}
		
		//get value of ShipAdd
		String shipAddPro=(String)comboShipAddPro.getSelectedItem();
		String shipAddCity=txtShipAddCity.getText();
		String shipAddTown=txtShipAddTown.getText();
		String shipAddRoad=txtShipAddRoad.getText();
		String shipAdd=shipAddPro+shipAddCity+shipAddTown+shipAddRoad;
		
		cus.setCusId(cusID);
		cus.setCusHabit("null");
		cus.setCusLevel("null");
		cus.setCusMethod(cusMethod);
		cus.setCusTime(00);
		cus.setCusHabit("null");
		//cus.setOrdId(ordID);
		cus.setOrdName(txtOrdName.getText());
		cus.setOrdPho(Integer.parseInt(txtOrdPho.getText()));
		cus.setOrdFax(Integer.parseInt(txtOrdFax.getText()));
		cus.setOrdZip(Integer.parseInt(txtOrdZip.getText()));
		//cus.setShipId(shipID);
		cus.setShipAdd(shipAdd);
		cus.setShipName(txtShipName.getText());
		cus.setShipFax(Integer.parseInt(txtShipFax.getText()));
		cus.setShipPho(Integer.parseInt(txtShipPho.getText()));
		cus.setShipZip(Integer.parseInt(txtShipZip.getText()));
		//cus.setFinId(finID);
		cus.setFinName(txtFinName.getText());
		cus.setFinAcc(Integer.parseInt(txtFinAcc.getText()));
		cus.setFinBank(txtFinBank.getText());
		cus.setFinAdd(txtFinAdd.getText());
		
		
		CusDao.addCustomer(cus);
				 
	}
	
}
