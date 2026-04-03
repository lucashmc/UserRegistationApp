package com.example.userregistrationapp;

//importa anotações do Room necessarios para mapear esta classe como uma entidade do banco de dados
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class User {

    //Define o campo 'id' como chave primaria da tabela e configura para ser gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campos que representam as colunas da tabela para armazenar os dados do usuario

    private  String name; // Nome do Usuario
    private  String cpf; // CPF do Usuario
    private  String email; // email do Usuario
    private  String phone; // fone do Usuario

    //Construtor da classe que sera usado para criar novo objeto user
    public User(String name, String cpf, String email, String Phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = Phone;

    }

    //METODOS getter e setter para acessar e modificar os dados do objeto User

    public int getId(){return id;}

    //Define o ID do usuario (usado pelo Room para preencher automaticamente)
    public void setId(int id) {this.id= id;}
    //Retorna O nome do Usuario
    public String getName(){return name;}
    //Retorna a Cpf do usuario
    public String getCPF(){return cpf;}
    //Retorna a email do usuario
    public String getEmail(){return email;}
    //Retorna o phone do Usuario
    public String getPhone(){return phone;}



}
