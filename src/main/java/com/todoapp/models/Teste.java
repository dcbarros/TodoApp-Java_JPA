package com.todoapp.models;

import java.sql.Connection;
import java.sql.SQLException;

import com.todoapp.utils.ConnectionFactory;

public class Teste {
    public static void main(String[] args) throws SQLException{
        Connection conexao = ConnectionFactory.getConnection();
        conexao.close();
    }
}
