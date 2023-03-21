package com.todoapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection(){
        
        try{
            Properties prop = getPropeties();
            final String url = prop.getProperty("db.url");
            final String usuario = prop.getProperty("db.user");
            final String senha = prop.getProperty("db.password");
    
            return DriverManager.getConnection(url, usuario, senha); 
        }catch(SQLException | IOException e){
            throw new RuntimeException(e);
        } 

    }

    public static void closeConnection(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch (Exception ex){
            throw new RuntimeException("Não foi possivel fechar a conexão");
        }
    }

    private static Properties getPropeties() throws IOException{
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("E:\\meusProjetos\\Cursos\\Novo Curso\\ILP_3\\software\\exercicio\\src\\main\\java\\com\\mycompany\\exercicio\\utils\\connection.prop")){
            prop.load(input);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
