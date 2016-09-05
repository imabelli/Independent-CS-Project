package java7;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Java7StringsInSwitchStatement {
	byte numByte = (byte) 0b10010001;

	//short value (16-bit) expressed in binary number system
	short numShort = (short) 0b1001000100011110;

	//int value (32-bit) expressed in binary number system
	int numInt =  0b10010001000111101010101001010101;

	//long value (64-bit) expressed in binary number system
	long numLong =  0b1001000100011110101010100101010110010001000111101010101001010101L;
    /**
     * @param args
	 */
	public static void main(String[] args) {
		final String programmingLanguage = "Java";
		
		String programmingLanguageType = null;
		switch(programmingLanguage) {
		case "C++"  :
		case "Java" : 
			programmingLanguageType = "Object Oriented Programming Language";
			break;
		case "C"	:
			programmingLanguageType = "Procedural Programming Language";
		}
		
		System.out.println("Programming Language: " + programmingLanguage + " is of type: " + programmingLanguageType);
	}

	public static void printEmployeesWithoutTryWithResource(Connection connection) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String query = "select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_DOB from EMPLOYEE";
		try{
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				final Long empId = resultSet.getLong("EMP_ID");
				final String empName = resultSet.getString("EMP_NAME");
				final String empEmail = resultSet.getString("EMP_EMAIL");
				final Date dOB = resultSet.getDate("EMP_DOB");
				System.out.println("[" + empId + ", " + empName + ", " + empEmail + ", " + dOB + "]");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				if(resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}

				if(preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			}catch (SQLException sqlException1) {
				sqlException1.printStackTrace();
			}
		}
	}


	public static void printEmployeesUsingTryWithResource(Connection connection) throws SQLException, IOException {

		String query = "select EMP_ID, EMP_NAME, EMP_EMAIL, EMP_DOB from EMPLOYEE";
		try(
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
		){
			while(resultSet.next()) {
				final Long empId = resultSet.getLong("EMP_ID");
				final String empName = resultSet.getString("EMP_NAME");
				final String empEmail = resultSet.getString("EMP_EMAIL");
				final Date dOB = resultSet.getDate("EMP_DOB");
				System.out.println("[" + empId + ", " + empName + ", " + empEmail + ", " + dOB + "]");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		try {
			//Statements that could throw either SQLEXception or IOException
			LocalDateTime currentTime = LocalDateTime.now();
			//Statements that could throw either SQLEXception or IOException
			if (currentTime.getSecond()%7 == 0)
				throw new IOException();


			if (currentTime.getSecond()%11 == 0)
				throw new SQLException();
		} catch(SQLException exception) {
			exception.printStackTrace();
			throw exception;
		} catch(IOException exception) {
			exception.printStackTrace();
			throw exception;
		}



		try {
			LocalDateTime currentTime = LocalDateTime.now();
			//Statements that could throw either SQLEXception or IOException
			if (currentTime.getSecond()%7 == 0)
				throw new IOException();

			throw new SQLException();
		} catch(IOException | SQLException exception) {
			exception.printStackTrace();
			throw exception;
		}
	}

	long hex = 0xAE_FF_FE_DE;
	long creditCardNo = 4321_8765_1234_5678L;
	float pi = 1_23.45_67_89F;
	double amount = 1_257_434_656.34;


//	long creditCardNo1 = _4321_8765_1234_5678L; //can't put underscore in starting of number as it makes it an identifier
//	long creditCardNo2 = 4321_8765_1234_5678L_; //can't put underscore in the end
//	long creditCardNo3 = 4321_8765_1234_5678_L; //can't put underscore before 'L' as it is same as putting underscore in the end
//	long hex = 0x_AE_FF_FE_DE; //can't put underscore after 0x
//	float pi = 1_23._45_67_89F; //can't put underscore just after decimal point(.)
//	double amount = 1_257_434_656_.34; //can't put underscore just before decimal point(.)


}