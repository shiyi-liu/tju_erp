import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CusDao {
	public static void addCustomer(Customer c) throws Exception{
		Connection conn = DBconnection.getConn();
		
		String sql="" +
				"insert into 客户主数据"+
				"(单据生成时间,物流方式,客户等级,订货单位码,联系人编号,收货单位码,结算单位码,联系时间间隔,购买习惯)"+
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
				"insert into 订货单位"+
				"(订货单位码,订货单位名,电话,传真)"+
				"values("+
				"?,?,?,?)";
		PreparedStatement ptmt1=conn.prepareStatement(sql1);		
		ptmt1.setInt(1, c.getOrdId());
		ptmt1.setString(2, c.getOrdName());
		ptmt1.setInt(3, c.getOrdPho());
		ptmt1.setInt(4, c.getOrdFax());
		
		String sql2=""+
				"insert into 结算单位"+
				"(结算单位码,结算单位,结算地址,结算银行账号,开户银行地址)"+
				"values("+
				"?,?,?,?,?)";
		PreparedStatement ptmt2=conn.prepareStatement(sql2);		
		ptmt2.setInt(1, c.getFinId());
		ptmt2.setString(2, c.getFinName());
		ptmt2.setString(3, c.getFinAdd());
		ptmt2.setInt(4, c.getFinAcc());
		ptmt2.setString(5, c.getFinBank());
		
		String sql3=""+
				"insert into 收货单位"+
				"(收货单位码,收货单位,收货单位地址,电话,传真,邮编)"+
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
				"select * from 客户主数据"+
				"where 客户编号=? ";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		if (rs.next()){
			
			cus.setCusId(rs.getInt("客户编号"));
			cus.setCusTime(rs.getInt("单据生成时间"));
			cus.setCusMethod(rs.getString("物流方式"));
			cus.setCusLevel(rs.getString("客户等级"));
			cus.setOrdId(rs.getInt("订货单位码"));
			cus.setConId(rs.getInt("联系人编号"));
			cus.setShipId(rs.getInt("收货单位码"));
			cus.setFinId(rs.getInt("结算单位码"));
			cus.setConTime(rs.getInt("联系时间间隔"));
			cus.setCusHabit(rs.getString("购买习惯"));	
		}
		
		String sql1 = ""+
				"select * from 结算单位"+
				"where 结算单位码=? ";
		
		PreparedStatement ptmt1 = conn.prepareStatement(sql1);
		ptmt1.setInt(1, rs.getInt("结算单位码"));
		ResultSet rs1 = ptmt1.executeQuery();
		while (rs1.next()){
			cus.setFinName(rs1.getString("结算单位"));
			cus.setFinAdd(rs1.getString("结算地址"));
			cus.setFinAcc(rs1.getInt("结算银行账号"));
			cus.setFinBank(rs1.getString("开户银行地址"));
			
		}
		
		String sql2 = ""+
				"select * from 订货单位"+
				"where 订货单位码=? ";
		PreparedStatement ptmt2 = conn.prepareStatement(sql2);
		ptmt2.setInt(1, rs.getInt("订货单位码"));
		
		ResultSet rs2 = ptmt2.executeQuery();
		while (rs2.next()){
			cus.setOrdName(rs2.getString("订货单位名"));
			cus.setOrdPho(rs2.getInt("电话"));
			cus.setOrdFax(rs2.getInt("传真"));
			cus.setOrdZip(rs2.getInt("邮编"));
		
		}
		
		String sql3=""+
				"select * from 收货单位"+
				"where 收货单位码=?";
		PreparedStatement ptmt3=conn.prepareStatement(sql3);
		ptmt3.setInt(1, rs.getInt("收货单位码"));
		ResultSet rs3=ptmt.executeQuery();
		while (rs3.next()){
			cus.setShipName(rs3.getString("收货单位"));
			cus.setShipAdd(rs3.getString("收货单位地址"));
			cus.setShipPho(rs3.getInt("电话"));
			cus.setShipFax(rs3.getInt("传真"));
			cus.setShipZip(rs3.getInt("邮编"));
		}
		
		return cus;
	}
}
