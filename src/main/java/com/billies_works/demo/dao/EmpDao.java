/**
 * 参考URL
 *   ユニバーサル接続プールの動作の最適化
 *   https://docs.oracle.com/cd/E16338_01/java.112/b56283/optimize.htm
 */

package com.billies_works.demo.dao;

import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
// import java.sql.DriverManager;

import oracle.ucp.jdbc.PoolDataSourceFactory;
import oracle.ucp.jdbc.PoolDataSource;

// import oracle.jdbc.pool.OracleDataSource;
// import oracle.jdbc.OracleConnection;

import com.billies_works.demo.model.Emp;
import com.billies_works.demo.model.EmpDept;
import com.billies_works.demo.model.Dept;

public class EmpDao {
    final static String DB_URL =
        "jdbc:oracle:thin:@localhost:1521/XE";
    final static String DB_USER = "mydb";
    final static String DB_PASS = "app";
    final static String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";
    static PoolDataSource pds = null;

    public EmpDao () {
        // try {
        //     init();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }

    public void init() throws SQLException {
        // Get the PoolDataSource for UCP
        pds = PoolDataSourceFactory.getPoolDataSource();

        // Set the connection factory first before all other properties.
        pds.setConnectionFactoryClassName( CONN_FACTORY_CLASS_NAME );
        pds.setURL( DB_URL );
        pds.setUser( DB_USER );
        pds.setPassword( DB_PASS );
        pds.setConnectionPoolName( "JDBC_UCP_POOL" );

        // Set the initial number of connection to be created when UCP is started.
        // 初期プールサイズの設定
        // Default is 0.
        pds.setInitialPoolSize( 5 );

        // Set the minimum number of connections that is maintained by UCP at runtime.
        // 最小プールサイズの設定
        // Default is 0.
        pds.setMinPoolSize( 5 );

        // Set the maximum number of connection allowed on the connection pool.
        // 最大プールサイズの設定
        // Default is Integer.MAX_VALUE (2147483647).
        pds.setMaxPoolSize( 20 );

        // Set the frequency in seconds to enforce the timeout properties.
        // タイムアウト・チェック間隔の設定
        // 強制タイムアウト(チェック)の頻度を秒単位で設定する。
        // つまり、接続のタイムアウト時に、実際には接続がプールに回収されない
        // ことがある。
        // Default is 30secs.
        // inactiveConnectionTimeout(int secs), AbondonedConnectionTimeout(secs),
        // TimeToLiveConnectionTimeout(int secs) に適用される。
        // 有効な値の範囲は 0 ... Integer.MAX_VALUE である。
        pds.setTimeoutCheckInterval( 5 );

        // Set the maximum time, in seconds, that a connection remains available
        // in the connection pool.
        // 非アクティブ接続タイムアウトの設定
        // クローズしてプールから削除されるまでの、使用可能な接続がアイドル状態で
        // いられる時間(sec)。
        // Default is 0.
        pds.setInactiveConnectionTimeout( 10 );

    }

    private void printPoolConnection( PoolDataSource pds, String checkInOut ) {
        try {
            System.out.println("Available connections after " + checkInOut + " : "
                               + pds.getAvailableConnectionsCount());
            System.out.println("Borrowed connections after " + checkInOut + " : "
                               + pds.getBorrowedConnectionsCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Emp> findEmpAll () {
        List<Emp> empList = new ArrayList<>();
        String sql = "SELECT * FROM emp";

        try {
            if (pds == null) {
                init();
                pds.setValidateConnectionOnBorrow(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        try (Connection conn = pds.getConnection()) {
            printPoolConnection( pds, "checkout" );
            printConnectionInfo( conn );
        
            try {
                conn.setAutoCommit( false );  // Default is true
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery( sql );
            
                // PreparedStatement pStmt = conn.prepareStatement( sql );
                // ResultSet rs = pStmt.executeQuery();

                while (rs.next()) {
                    Integer empno = rs.getInt("empno");
                    String ename = rs.getString("ename");
                    String job = rs.getString("job");
                    Integer sal = rs.getInt("sal");
                    Integer age = rs.getInt("age");
                    Integer deptno = rs.getInt("deptno");

                    Emp emp = new Emp( empno, ename, job, sal, age, deptno );
                    empList.add( emp );
                }
            } catch (SQLException e) {
                System.out.println("EmpDao - findEmpAll - " + "SQLException occurred : " +
                                   e.getMessage());
                System.out.println("エラーでっせ!");
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println("EmpDao - get.connection - "
                               + "SQLExceptin occurred : "
                               + e.getMessage());
        }
        printPoolConnection( pds,"checkin" );

        return empList;
    }

    public List<EmpDept> findEmpDeptAll () {
        try {
            if (pds == null) {
                init();
                pds.setValidateConnectionOnBorrow(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        List<EmpDept> empDeptList = new ArrayList<>();
        String sql = "SELECT empno, ename, job, age, dname FROM emp";
        sql = sql + " left outer join dept on emp.deptno = dept.deptno";

        try (Connection conn = pds.getConnection()) {
            printPoolConnection( pds, "checkout" );
            // a database operation

            try {
                conn.setAutoCommit( false );  // Default is true
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery( sql );
            
                while (rs.next()) {
                    Integer empno = rs.getInt("empno");
                    String ename = rs.getString("ename");
                    String job = rs.getString("job");
                    Integer age = rs.getInt("age");
                    String dname = rs.getString("dname");

                    EmpDept empDept = new EmpDept( empno, ename, job, age, dname );
                    empDeptList.add( empDept );
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("エラーでっせ!");
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println("EmpDao - getConnection - "
                               + "SQLExceptin occurred : "
                               + e.getMessage());
        }
        printPoolConnection( pds,"checkin" );
        return empDeptList;
    }

    public List<Dept> findDeptAll () {
        try {
            if (pds == null) {
                init();
                pds.setValidateConnectionOnBorrow(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        List<Dept> deptList = new ArrayList<>();
        String sql = "SELECT deptno, dname, telno FROM dept";

        try (Connection conn = pds.getConnection()) {
            printPoolConnection( pds, "checkout" );
            // a database operation

            try {
                conn.setAutoCommit( false );  // Default is true
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery( sql );

                while (rs.next()) {
                    Integer deptno = rs.getInt("deptno");
                    String dname = rs.getString("dname");
                    String telno = rs.getString("telno");

                    Dept dept = new Dept( deptno, dname, telno );
                    deptList.add( dept );
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("エラーでっせ!");
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println("EmpDao - getConnection - "
                               + "SQLExceptin occurred : "
                               + e.getMessage());
        }
        printPoolConnection( pds,"checkin" );
        return deptList;
    }
    
    public Emp findEmp( int empno ) {
        try {
            if (pds == null) {
                init();
                pds.setValidateConnectionOnBorrow(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Emp emp = null;
        
        String sql = "SELECT * FROM emp where empno = ?";

        try (Connection conn = pds.getConnection()) {
            printPoolConnection( pds, "checkout" );
            // a database operation

            try {
                conn.setAutoCommit( false );  // Default is true
                PreparedStatement statement = conn.prepareStatement( sql );
                statement.setInt( 1, empno );
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    empno = rs.getInt("empno");
                    String ename = rs.getString("ename");
                    String job = rs.getString("job");
                    Integer sal = rs.getInt("sal");
                    Integer age = rs.getInt("age");
                    Integer deptno = rs.getInt("deptno");

                    emp = new Emp( empno, ename, job, sal, age, deptno );


                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("エラーでっせ!");
                return null;
            }
        }
        catch (SQLException e) {
            System.out.println("EmpDao - findEmp - "
                               + "SQLExceptin occurred : "
                               + e.getMessage());
        }
        printPoolConnection( pds,"checkin" );
        return emp;
    }

    public boolean updateEmp( Emp emp ) {
        try {
            if (pds == null) {
                init();
                pds.setValidateConnectionOnBorrow(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("empno:" + emp.getEmpno());
        System.out.println("name:" + emp.getEname());
        System.out.println("job:" + emp.getJob());
        System.out.println("sal:" + emp.getSal());
        System.out.println("age:" + emp.getAge());
        System.out.println("deptno:" + emp.getDeptno());

        

        String sql = "UPDATE emp SET ename = ?, job = ?, ";
        sql = sql + " sal = ?, age = ?, deptno = ? ";
        sql = sql + " where empno = ?";

        try (Connection conn = pds.getConnection()) {
            printPoolConnection( pds, "checkout" );
            // a database operation

            try {
                conn.setAutoCommit( false );  // Default is true
                PreparedStatement statement = conn.prepareStatement( sql );
                statement.setString( 1, emp.getEname() );
                statement.setString( 2, emp.getJob() );
                statement.setInt( 3, emp.getSal() );
                statement.setInt( 4, emp.getAge() );
                statement.setInt( 5, emp.getDeptno() );
                statement.setInt( 6, emp.getEmpno() );
                ResultSet rs = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("エラーでっせ!");
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("EmpDao - findEmp - "
                               + "SQLExceptin occurred : "
                               + e.getMessage());
            return false;
        }
        printPoolConnection( pds,"checkin" );
        return true;
    }

    
    private void printConnectionInfo( Connection conn ) {
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            // System.out.println("Default Row Prefetch Value is: " + conn.getDefaultRowPrefetch());
            // System.out.println("Database Username is: " + conn.getUserName());
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 修正時刻: Mon Feb 15 15:57:04 2021
