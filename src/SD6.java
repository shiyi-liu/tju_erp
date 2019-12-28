import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import com.jgoodies.common.*;

public class SD6 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtKey;
	private JTextField txtOrdName;
	private JTextField txtOrdPho;
	private JTextField txtOrdFax;
	private JTextField txtOrdZip;
	private JTextField txtShipName;
	private JTextField txtShipPho;
	private JTextField txtShipFax;
	private JTextField txtShipZip;
	private JTextField txtShipMet;
	private JTextField txtShipAdd;
	private JTextField txtFinName;
	private JTextField txtFinAcc;
	private JTextField txtFinAdd;
	private JTextField txtFinBank;
	private JButton btnClose;
	private JButton btnSub;
	private JTextField txtOrdId;
	private JTextField txtShipId;
	private JTextField txtFinId;
	
	public SD6() {
		setResizable(false);
		setTitle("\u67E5\u8BE2\u5BA2\u6237\u4E3B\u6570\u636E");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(64dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(38dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(82dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel label = new JLabel("\u5BA2\u6237\u7F16\u53F7\uFF1A");
		label.setFont(new Font("STZhongsong", Font.PLAIN, 17));
		getContentPane().add(label, "2, 2, right, default");
		
		txtKey = new JTextField();
		txtKey.setText("\u8BF7\u8F93\u5165\u9700\u8981\u67E5\u8BE2\u7684\u5BA2\u6237\u7F16\u53F7");
		txtKey.setColumns(10);
		getContentPane().add(txtKey, "4, 2, 5, 1, fill, default");
		
		btnSub = new JButton("\u67E5\u8BE2");
		btnSub.addActionListener((ActionListener) this);
		getContentPane().add(btnSub, "10, 2, left, default");
		
		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "2, 4, 12, 1");
		
		JLabel label_1 = new JLabel("\u8BA2\u8D27\u5355\u4F4D\u4FE1\u606F\uFF1A");
		label_1.setFont(new Font("STZhongsong", Font.PLAIN, 17));
		getContentPane().add(label_1, "2, 6");
		
		JLabel label_17 = new JLabel("\u8BA2\u8D27\u5355\u4F4D\u7801");
		getContentPane().add(label_17, "2, 8, right, default");
		
		txtOrdId = new JTextField();
		getContentPane().add(txtOrdId, "4, 8, fill, default");
		txtOrdId.setColumns(10);
		
		JLabel label_2 = new JLabel("\u540D\u79F0");
		getContentPane().add(label_2, "2, 10, right, default");
		
		txtOrdName = new JTextField();
		getContentPane().add(txtOrdName, "4, 10, 3, 1, fill, default");
		txtOrdName.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		getContentPane().add(label_3, "8, 10, right, default");
		
		txtOrdPho = new JTextField();
		txtOrdPho.setColumns(10);
		getContentPane().add(txtOrdPho, "10, 10, 3, 1, fill, default");
		
		JLabel label_4 = new JLabel("\u4F20\u771F");
		getContentPane().add(label_4, "2, 12, right, default");
		
		txtOrdFax = new JTextField();
		getContentPane().add(txtOrdFax, "4, 12, 3, 1, fill, default");
		txtOrdFax.setColumns(10);
		
		JLabel label_5 = new JLabel("\u90AE\u7F16");
		getContentPane().add(label_5, "8, 12, right, default");
		
		txtOrdZip = new JTextField();
		getContentPane().add(txtOrdZip, "10, 12, 3, 1, fill, default");
		txtOrdZip.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "2, 14, 12, 1");
		
		JLabel label_6 = new JLabel("\u6536\u8D27\u5355\u4F4D\u4FE1\u606F\uFF1A");
		label_6.setFont(new Font("STZhongsong", Font.PLAIN, 17));
		getContentPane().add(label_6, "2, 16");
		
		JLabel label_18 = new JLabel("\u6536\u8D27\u5355\u4F4D\u7801");
		getContentPane().add(label_18, "2, 18, right, default");
		
		txtShipId = new JTextField();
		getContentPane().add(txtShipId, "4, 18, fill, default");
		txtShipId.setColumns(10);
		
		JLabel label_7 = new JLabel("\u540D\u79F0");
		getContentPane().add(label_7, "2, 20, right, default");
		
		txtShipName = new JTextField();
		getContentPane().add(txtShipName, "4, 20, 3, 1, fill, default");
		txtShipName.setColumns(10);
		
		JLabel label_8 = new JLabel("\u7535\u8BDD");
		getContentPane().add(label_8, "8, 20, right, default");
		
		txtShipPho = new JTextField();
		getContentPane().add(txtShipPho, "10, 20, 3, 1, fill, default");
		txtShipPho.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F20\u771F");
		getContentPane().add(lblNewLabel, "2, 22, right, default");
		
		txtShipFax = new JTextField();
		getContentPane().add(txtShipFax, "4, 22, 3, 1, fill, default");
		txtShipFax.setColumns(10);
		
		JLabel label_9 = new JLabel("\u90AE\u7F16");
		getContentPane().add(label_9, "8, 22, right, default");
		
		txtShipZip = new JTextField();
		getContentPane().add(txtShipZip, "10, 22, 3, 1, fill, default");
		txtShipZip.setColumns(10);
		
		JLabel label_11 = new JLabel("\u5730\u5740");
		getContentPane().add(label_11, "2, 24, right, default");
		
		txtShipAdd = new JTextField();
		getContentPane().add(txtShipAdd, "4, 24, 9, 1, fill, default");
		txtShipAdd.setColumns(10);
		
		JLabel label_10 = new JLabel("\u7269\u6D41\u65B9\u5F0F");
		getContentPane().add(label_10, "2, 26, right, default");
		
		txtShipMet = new JTextField();
		getContentPane().add(txtShipMet, "4, 26, 3, 1, fill, default");
		txtShipMet.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		getContentPane().add(separator_2, "2, 28, 12, 1");
		
		JLabel label_12 = new JLabel("\u7ED3\u7B97\u5355\u4F4D\u4FE1\u606F\uFF1A");
		label_12.setFont(new Font("STZhongsong", Font.PLAIN, 17));
		getContentPane().add(label_12, "2, 30");
		
		JLabel label_19 = new JLabel("\u7ED3\u7B97\u5355\u4F4D\u7801");
		getContentPane().add(label_19, "2, 32, right, default");
		
		txtFinId = new JTextField();
		getContentPane().add(txtFinId, "4, 32, fill, default");
		txtFinId.setColumns(10);
		
		JLabel label_13 = new JLabel("\u540D\u79F0");
		getContentPane().add(label_13, "2, 34, right, default");
		
		txtFinName = new JTextField();
		getContentPane().add(txtFinName, "4, 34, 3, 1, fill, default");
		txtFinName.setColumns(10);
		
		JLabel label_14 = new JLabel("\u94F6\u884C\u8D26\u53F7");
		getContentPane().add(label_14, "8, 34, right, default");
		
		txtFinAcc = new JTextField();
		getContentPane().add(txtFinAcc, "10, 34, 3, 1, fill, default");
		txtFinAcc.setColumns(10);
		
		JLabel label_16 = new JLabel("\u5355\u4F4D\u5730\u5740");
		getContentPane().add(label_16, "2, 36, right, default");
		
		txtFinAdd = new JTextField();
		getContentPane().add(txtFinAdd, "4, 36, 9, 1, fill, default");
		txtFinAdd.setColumns(10);
		
		JLabel label_15 = new JLabel("\u5F00\u6237\u94F6\u884C\u5730\u5740");
		getContentPane().add(label_15, "2, 38, right, default");
		
		txtFinBank = new JTextField();
		getContentPane().add(txtFinBank, "4, 38, 9, 1, fill, default");
		txtFinBank.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		getContentPane().add(separator_3, "2, 40, 12, 1");
		
		btnClose = new JButton("\u786E\u8BA4");
		btnClose.addActionListener((ActionListener) this);
		getContentPane().add(btnClose, "12, 42");
		
	}
	
	public void actionPerformed(ActionEvent e){ 
		   if(e.getSource()==btnSub){
			   try {
				toQuery();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		   }
		   
		   if(e.getSource()==btnClose) {
			   System.exit(0);
		   }
		   
	}   
	
	private void toQuery() throws SQLException {
		Integer id=Integer.parseInt(txtKey.getText());
		
		Customer cus=null;
		cus=CusDao.getCus(id);
		Integer newId=cus.getCusId();
		
		if(newId!=null){
			txtOrdName.setText(cus.getOrdName());
			txtOrdId.setText(Integer.toString(cus.getOrdId()));
			txtShipId.setText(Integer.toString(cus.getShipId()));
			txtFinId.setText(Integer.toString(cus.getFinId()));
			txtOrdPho.setText(Integer.toString(cus.getOrdPho()));
			txtOrdFax.setText(Integer.toString(cus.getOrdFax()));
			txtOrdZip.setText(Integer.toString(cus.getOrdZip()));
			txtShipName.setText(cus.getShipName());
			txtShipPho.setText(Integer.toString(cus.getShipPho()));
			txtShipFax.setText(Integer.toString(cus.getShipFax()));
			txtShipZip.setText(Integer.toString(cus.getShipZip()));
			txtShipMet.setText(cus.getCusMethod());
			txtShipAdd.setText(cus.getShipAdd());
			txtFinName.setText(cus.getFinName());
			txtFinAcc.setText(Integer.toString(cus.getFinAcc()));
			txtFinAdd.setText(cus.getFinAdd());
			txtFinBank.setText(cus.getFinBank());
		}else{
			JOptionPane.showMessageDialog(null, "查无此用户，请核对关键字", "Warning", JOptionPane.ERROR_MESSAGE);
		}
	} 
}
