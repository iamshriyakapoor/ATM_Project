// Source code is decompiled from a .class file using FernFlower decompiler.
package ASimulatorSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection("jdbc:mysql:///bms", "root", "1234");
            this.s = this.c.createStatement();
        } catch (Exception var2) {
            System.out.println(var2);
        }

    }
}
