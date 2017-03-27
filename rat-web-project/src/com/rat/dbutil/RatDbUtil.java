package com.rat.dbutil;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.rat.app.Rat;

public class RatDbUtil {
//TODO IMPLEMENT THE DB UTILITY
	
	private DataSource dataSource;

	public RatDbUtil(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public List<Rat> getRats() throws Exception{
		List<Rat> rats = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try{
			// get a connection 
			myConn = dataSource.getConnection();
			
			// generate sql statement 
			String sql = "select * from web_rat_db.rat order by id";
			myStmt = myConn.createStatement();
			
			// Execute query 
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while (myRs.next()){
			
				// Retrieve data from result set row 
				int id = myRs.getInt("id");

				byte[] buf = myRs.getBytes("rat");
				ObjectInputStream objectIn = null;
				Object deSerializedObject = null;
				Rat tempRat = new Rat();
				if (buf != null){
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
					deSerializedObject = objectIn.readObject();
					tempRat = (Rat) deSerializedObject;
				}else{
					System.out.println("not pulling up rat");
				}
				
				if(tempRat != null){
					tempRat.setId(id);	
				}
				
				
				// add it to the list of rats
				rats.add(tempRat);
			}		
			return rats;
		}
		finally{
			
			// close JDBC objects
			close(myConn,myStmt,myRs);
			}
		}
		
	
	public void addRat(Rat tempRat) throws Exception {
		Connection myConn = null; 
		PreparedStatement myStmt = null;
		
			try{
				// get the DB connection 
				
				myConn = dataSource.getConnection();
			// create sql statement for insert 
				
				String sql = "insert into web_rat_db.rat"
						+"(main_claim, rat) "
						+"values (?, ?)";
				
				myStmt = myConn.prepareStatement(sql);
			// set the param vals for the statement 
				myStmt.setString(1, "Fix"); //TODO implement main claim on add rat jsp page.
				myStmt.setObject(2, tempRat);
				
			
			//excequte the sql insert 
			
				myStmt.execute();
			} finally{
				// clean JDBC objects
				close(myConn,myStmt,null); 
			}
		}

	
	public void deleteRatFromDataBase(String id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
			try{
				// get DB connection 
				myConn = dataSource.getConnection();
			
				// create SQL drop statement 
				String sql = "delete from web_rat_db.rat "
						+"where id=?";
				// prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				// set param
				myStmt.setString(1, id);
				
				//Execute statement 
				myStmt.execute();
				
				
			}finally{
				System.out.println("Finished deleteRatFromDataBase(id) method in RatDbUtil" );
				close(myConn,myStmt,null);
			}
		}

		
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
			try{
				if(myRs!= null){
					myRs = null;
				}
				if(myStmt != null){
					myStmt = null;
				}
				
				if(myConn!= null){
					myConn=null;
				}			
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
		}

			
		


		
}
