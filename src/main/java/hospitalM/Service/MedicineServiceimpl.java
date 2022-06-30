package hospitalM.Service;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hospitalM.Model.MedicineModel;
import hospitalM.Utill.DBConecctionUtil;


public class MedicineServiceimpl implements MedicineService {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement prearedStatement = null;
	private static List<MedicineModel> list = null;
	private MedicineModel medicineModel = null;
	@Override
	public boolean addMedicine(MedicineModel medi) {
		boolean flag = false;

		try {

			System.out.println("#############################################");
			System.out.println(medi.getName());
			System.out.println(medi.getCategory());
			System.out.println(medi.getPrice());
			System.out.println(medi.getQuantity());
			System.out.println(medi.getExpdate());
			System.out.println(medi.getFabDate());
			System.out.println(medi.getCompany());
			//declare query
			String sql = "INSERT INTO `medicine` (`sNo`, `Name`, `Category`, `Price`, `Quantity`, `expDate`, `fabDate`, `Company`) VALUES (NULL,'"+medi.getName()+"', '"+medi.getCategory()+"', '"+medi.getPrice()+"', '"+medi.getQuantity()+"', '"+medi.getExpdate()+"', '"+medi.getFabDate()+"', '"+medi.getCompany()+"')";
			
			
			
			connection = DBConecctionUtil.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);

//			System.out.println(s.getAccNum());

			prearedStatement.execute();
			flag = true;

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			//close the connection and preparedstatement
			 
			 
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}
	@Override
	public List<MedicineModel> allMedi() {
		list = new ArrayList<MedicineModel>();
		try {
				//declare query
			String sql = "SELECT * FROM `medicine`";

			connection = DBConecctionUtil.createConnection(); //open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql); //excecute query

			while (resultSet.next()) {
				medicineModel = new MedicineModel();

				medicineModel.setName(resultSet.getString("Name"));
				medicineModel.setCategory(resultSet.getString("Category"));
				medicineModel.setCompany(resultSet.getString("Company"));
				medicineModel.setPrice(resultSet.getFloat("Price"));
				medicineModel.setQuantity(resultSet.getInt("Quantity"));
				medicineModel.setId(resultSet.getInt("sNo"));
				medicineModel.setExpdate(resultSet.getString("expDate"));
				medicineModel.setFabDate(resultSet.getString("fabDate"));
				list.add(medicineModel);
			}
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}
	@Override
	public MedicineModel getSingleMedie(int id) {
		medicineModel = new MedicineModel();
		//declare query
		String sql = "SELECT * FROM `medicine` WHERE `medicine`.`sNo` ="+id;

		try {
			connection = DBConecctionUtil.createConnection();//open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				medicineModel.setName(resultSet.getString("Name"));
				medicineModel.setCategory(resultSet.getString("Category"));
				medicineModel.setId(resultSet.getInt("sNo"));
				medicineModel.setCompany(resultSet.getString("Company"));
				medicineModel.setPrice(resultSet.getFloat("Price"));
				medicineModel.setExpdate(resultSet.getString("expDate"));
				medicineModel.setQuantity(resultSet.getInt("Quantity"));
				medicineModel.setFabDate(resultSet.getString("fabDate"));

			}

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return medicineModel;
	}
	@Override
	public boolean updateMedi(MedicineModel medi) {
		boolean flag = false;

		//declare query

		String sql = "UPDATE `medicine` SET `Name` = '"+medi.getName()+"', `Category` = '"+medi.getCategory()+"', `Price` = '"+medi.getPrice()+"', `Quantity` = '"+medi.getQuantity()+"', `expDate` = '"+medi.getExpdate()+"', `fabDate` = '"+medi.getFabDate()+"', `Company` = '"+medi.getCompany()+"' WHERE `medicine`.`sNo` = "+medi.getId();

		try {
			connection = DBConecctionUtil.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);


			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return flag;
	}
	@Override
	public boolean deleteMedi(int id) {
		boolean flag = false;
		//declare query
		String sql = "DELETE FROM `medicine` WHERE `medicine`.`sNo` ="+id;

		try {
			connection = DBConecctionUtil.createConnection();//open connection
			prearedStatement = connection.prepareStatement(sql);
			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}

}
