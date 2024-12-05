package com.mycompany.cliente.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection abrirConexao() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost/cliente";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void fecharConexao(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
