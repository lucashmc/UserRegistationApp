package com.example.userregistrationapp;
// importa as anotações e classes da biblioteca Room e do Android
import android.content.Context; // Classe que representa o contexto da aplicação (necessario para acessar recursos)

import androidx.room.Database; // anotação para marca a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase; // Classe base que representa o BD


/*
Anotação @Database define que a classe representa o banco de dados Room Ela especifica as entidades (tabelas) que o banco ira conter e a versao do BD

*/

@Database(entities = {User.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    //Instáncia unica (singleton) do BD

    private static  UserDatabase instace;
    // Método abstrado  que sera implementado pela Room
    public  abstract UserDao userDao();

    //Método que retorna a isntãncia do BD
    // o uso do "sychronized" garante que apenas uma thread possa acessar este metodo por vez, evitando que duas instancias do BD sejam criadas acidentalmente
    public  static synchronized  UserDatabase getInstace(Context context) {
        //Verificar se ja existe um instancia de BD
        if (instace == null) {
            //Cria a instancia do BD usando Room
            //Usa o contexto da aplicação para evitar vazamento da memoria
            //fallbackToDestructiveMigration - se houver mudança de versao e nao ouver migração, o BD sera reciado do zero
            instace = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();


        }
        //retorna a instancia criada
        return instace;
    }


}
