import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CusDao {
	public static void addCustomer(Customer c) throws Exception{
		Connection conn = DBconnection.getConn();
		
		String sql="" +
				"insert into �ͻ�������"+
				"(��������ʱ��,������ʽ,�ͻ��ȼ�,������λ��,��ϵ�˱��,�ջ���λ��,���㵥λ��,��ϵʱ����,����ϰ��)"+
				"values("+
				"?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);		
		ptmt.setInt(1, c.getCusTime());
		ptmt.setString(2, c.getCusMethod());
		ptmt.setString(3, c.getCusLevel());
		ptmt.setInt(4, c.getOrdId());
		ptmt.setInt(5, c.getConId());
		ptmt.setInt(6, c.getShipId());
		ptmt.setInt(7, c.getFinId());
		ptmt.setInt(8, c.getConTime());
		ptmt.setString(9, c.getCusHabit());
		
		String sql1=""+
				"insert into ������λ"+
				"(������λ��,������λ��,�绰,����)"+
				"values("+
				"?,?,?,?)";
		PreparedStatement ptmt1=conn.prepareStatement(sql1);		
		ptmt1.setInt(1, c.getOrdId());
		ptmt1.setString(2, c.getOrdName());
		ptmt1.setInt(3, c.getOrdPho());
		ptmt1.setInt(4, c.getOrdFax());
		
		String sql2=""+
				"insert into ���㵥λ"+
				"(���㵥λ��,���㵥λ,�����ַ,���������˺�,�������е�ַ)"+
				"values("+
				"?,?,?,?,?)";
		PreparedStatement ptmt2=conn.prepareStatement(sql2);		
		ptmt2.setInt(1, c.getFinId());
		ptmt2.setString(2, c.getFinName());
		ptmt2.setString(3, c.getFinAdd());
		ptmt2.setInt(4, c.getFinAcc());
		ptmt2.setString(5, c.getFinBank());
		
		String sql3=""+
				"insert into �ջ���λ"+
				"(�ջ���λ��,�ջ���λ,�ջ���λ��ַ,�绰,����,�ʱ�)"+
				"values("+
				"?,?,?,?,?,?)";
		PreparedStatement ptmt3=conn.prepareStatement(sql3);
		ptmt3.setInt(1, c.getShipId());
		ptmt3.setString(2, c.getShipName());
		ptmt3.setString(3, c.getShipAdd());
		ptmt3.setInt(4, c.getShipPho());
		ptmt3.setInt(5, c.getShipFax());
		ptmt3.setInt(6, c.getShipZip());
		
		ptmt.execute();
		ptmt1.execute();
		ptmt2.execute();
		ptmt3.execute();
	}
	
	public static Customer getCus(Integer id) throws SQLException{
		Customer cus =null;
		cus = new Customer();
		Connection conn = DBconnection.getConn();
		
		String sql = ""+
				"select * from �ͻ�������"+
				"where �ͻ����=? ";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		if (rs.next()){
			
			cus.setCusId(rs.getInt("�ͻ����"));
			cus.setCusTime(rs.getInt("��������ʱ��"));
			cus.setCusMethod(rs.getString("������ʽ"));
			cus.setCusLevel(rs.getString("�ͻ��ȼ�"));
			cus.setOrdId(rs.getInt("������λ��"));
			cus.setConId(rs.getInt("��ϵ�˱��"));
			cus.setShipId(rs.getInt("�ջ���λ��"));
			cus.setFinId(rs.getInt("���㵥λ��"));
			cus.setConTime(rs.getInt("��ϵʱ����"));
			cus.setCusHabit(rs.getString("����ϰ��"));	
		}
		
		String sql1 = ""+
				"select * from ���㵥λ"+
				"where ���㵥λ��=? ";
		
		PreparedStatement ptmt1 = conn.prepareStatement(sql1);
		ptmt1.setInt(1, rs.getInt("���㵥λ��"));
		ResultSet rs1 = ptmt1.executeQuery();
		while (rs1.next()){
			cus.setFinName(rs1.getString("���㵥λ"));
			cus.setFinAdd(rs1.getString("�����ַ"));
			cus.setFinAcc(rs1.getInt("���������˺�"));
			cus.setFinBank(rs1.getString("�������е�ַ"));
			
		}
		
		String sql2 = ""+
				"select * from ������λ"+
				"where ������λ��=? ";
		PreparedStatement ptmt2 = conn.prepareStatement(sql2);
		ptmt2.setInt(1, rs.getInt("������λ��"));
		
		ResultSet rs2 = ptmt2.executeQuery();
		while (rs2.next()){
			cus.setOrdName(rs2.getString("������λ��"));
			cus.setOrdPho(rs2.getInt("�绰"));
			cus.setOrdFax(rs2.getInt("����"));
			cus.setOrdZip(rs2.getInt("�ʱ�"));
		
		}
		
		String sql3=""+
				"select * from �ջ���λ"+
				"where �ջ���λ��=?";
		PreparedStatement ptmt3=conn.prepareStatement(sql3);
		ptmt3.setInt(1, rs.getInt("�ջ���λ��"));
		ResultSet rs3=ptmt.executeQuery();
		while (rs3.next()){
			cus.setShipName(rs3.getString("�ջ���λ"));
			cus.setShipAdd(rs3.getString("�ջ���λ��ַ"));
			cus.setShipPho(rs3.getInt("�绰"));
			cus.setShipFax(rs3.getInt("����"));
			cus.setShipZip(rs3.getInt("�ʱ�"));
		}
		
		return cus;
	}
}
