package com.example.userregistrationapp;



// 0 data Access Objeto e componente que serve para persistencia de dados. Serve para definir as operaçoes que podem ser
// feitas no banco de dados com relação a entidade User
//importa as notaçoes do Room necessarias para definir o DAO (data access Obejto)

import  androidx.room.Dao;
import  androidx.room.Insert;
import androidx.room.Query;
//importa a classe list do java para retorna uma lista de usuarios
import java.util.List;

public interface UserDao {
    //Método para inserir um usuario na tabela do banco de Dados
    // A anotaçao @insert informa que este metodo deve ser usado para inserir dado

    @Insert
    void insert(User user);

    //Método para buscar todos os usuarios cadastrados no BD
    //A anotação @Query permite define um consulta SQl personalizar
    @Query("SELECT * FROM user")
    List<User> getALLUsers();
}
