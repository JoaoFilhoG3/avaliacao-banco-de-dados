package com.mycompany.cliente.model.DAO;

import com.mycompany.cliente.controller.Conexao;
import com.mycompany.cliente.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void add(Cliente cliente) {
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "INSERT INTO cliente"
                    + "(nome, endereco, email, cpf, idade)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCpf());
            ps.setInt(5, cliente.getIdade());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cliente> getAll() {
        List<Cliente> lClientes = new ArrayList<>();
        try {
            Connection conn = Conexao.abrirConexao();
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while(rs.next()){
                    Cliente cli = new Cliente(
                            rs.getInt("cod_cli"), 
                            rs.getString("nome"), 
                            rs.getString("endereco"), 
                            rs.getString("email"), 
                            rs.getString("cpf"), 
                            rs.getInt("idade"));
                    lClientes.add(cli);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lClientes;
    }
}
