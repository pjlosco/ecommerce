package controllers.db;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Map;

public class PostgreSQLJDBC {

	private String LOCALHOST_URL = "jdbc:postgresql://localhost:5432/testdb";
	private String LOCALHOST_USER = "postgres";
	private String LOCALHOST_PASSWORD = "123";

	private Connection c = null;
	private static Logger log;

	/**
	 * Based on setup we should know admin user we have to connect to db
	 * @param url
	 * @param user
	 * @param password
	 * @param isLocal
	 */
	public PostgreSQLJDBC(String url, String user, String password, boolean isLocal) {
		log = LogManager.getLogger("PostgreSQLJDBC");

		try {
			Class.forName("org.postgresql.Driver");
			if (isLocal) {
				c = DriverManager.getConnection(LOCALHOST_URL, LOCALHOST_USER, LOCALHOST_PASSWORD);
			} else {
				c = DriverManager.getConnection(url, user, password);
			}
			log.info("Opened database successfully");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			// System.exit(0); // dont think we should exit because of this
		}
	}

	/**
	 * Example table creation. Need to format for retail items.
	 * TODO - pass in map for names and types and build statement dynamically
	 * @param tableName
	 * @return
	 */
	public boolean createTable(String tableName) {
		try {
			Statement statement = c.createStatement();
			String sql = "CREATE TABLE " + tableName.toUpperCase() + " " +
					"(ID INT PRIMARY KEY     NOT NULL," +
					" NAME           TEXT    NOT NULL, " +
					" AGE            INT     NOT NULL, " +
					" ADDRESS        CHAR(50), " +
					" SALARY         REAL)";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Insert values into a table by keys
	 * @param tableName
	 * @param data
	 * @return
	 */
	public boolean insert(String tableName, Map<String, String> data) {
		try {
			Statement statement = c.createStatement();

			// format data
			StringBuffer keys = new StringBuffer();
			StringBuffer values = new StringBuffer();
			for (String key : data.keySet()) {
				keys.append(key + ",");
				values.append(data.get(key) + ",");
			}
			// remove extra comma
			keys.deleteCharAt(keys.length()-1);
			values.deleteCharAt(keys.length()-1);

			String sql = "INSERT INTO " + tableName + " (" + keys + ") "
					+ "VALUES (" + values + ") ;";
			int responseValue = statement.executeUpdate(sql);
			log.info("Update into DB successful: " + responseValue);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Returns data from table
	 * @param tableName
	 * @param keys
	 * @param filter
	 * @return
	 */
	public ResultSet select(String tableName, String keys, String filter) {
		try {
			Statement statement = c.createStatement();

			StringBuffer sql = new StringBuffer("SELECT " + keys + " FROM " + tableName);
			if (filter != null) {
				sql.append(" WHERE " + filter );
			}
			sql.append(";");

			return statement.executeQuery(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	/**
	 * Update data in table
	 * @param tableName
	 * @param updateSet
	 * @param filter
	 * @return
	 */
	public boolean udpate(String tableName, String updateSet, String filter) {
		try {
			Statement statement = c.createStatement();

			StringBuffer sql = new StringBuffer("UPDATE " + tableName + " set " + updateSet);
			if (filter != null) {
				sql.append(" WHERE " + filter );
			}
			sql.append(";");

			int responseValue = statement.executeUpdate(sql.toString());
			log.info("Update into DB successful: " + responseValue);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Delete data in table
	 * @param tableName
	 * @param filter
	 * @return
	 */
	public boolean delete(String tableName, String filter) {
		try {
			Statement statement = c.createStatement();

			String sql = ("DELETE from " + tableName + " WHERE " + filter + ";");

			int responseValue = statement.executeUpdate(sql);
			log.info("Update into DB successful: " + responseValue);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

}

