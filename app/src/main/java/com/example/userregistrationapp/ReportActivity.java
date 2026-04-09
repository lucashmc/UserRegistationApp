package com.example.userregistrationapp;
//Importaçoes de componentes de UI, intenções e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.room.Room;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReportActivity extends AppCompatActivity {
    //Campo de texto onde  os  dados do banco serão exibidos
    private TextView textViewReport;

     @Override
    protected  void onCreate(Bundle saveInstanceState) {
         super.onCreate(saveInstanceState);
         // Define o layout XML dessa tela de relatorio
         setContentView(R.layout.activity_report);
         // Mapeamento do TextView do XML para o java
         textViewReport = findViewById(R.id.textViewReport);
         // Encontra o botao e define o clique expressão voltar
         Button btnVoltar = findViewById(R.id.btnVoltar);
         // o botao de retorno utilizando expressao lamdda
         btnVoltar.setOnClickListener(v -> voltarParaCadastro());

         /*
           conexão com  o banco de dados
           1- Cria uma instãncia do banco "User-database"
           2- . allowMaininThreadQueries(): Serve para liverar operações de consulta feitas  em threads da UI.
           por padrão, ROOM proibe isso. O correto seria fazer consultas em thereads separadas.
         */

         UserDatabase db = Room.databaseBuilder(getApplication(), UserDatabase.class, "user-database").allowMainThreadQueries().build();
         // Obtem o obketp DAP (data Access Object) que contem as queries SQL
         UserDao userDao = db.userDao();

         //Recupera todos os Usuarios salvos no BD e armazena numa Lista
         List<User> userList = userDao.getALLUsers();
         //StringBuilder: forma eficiente de construir uma String longa dentro de um laço (loop)
         StringBuilder report = new StringBuilder();

         // Loop "for-each" para percorrer cada obejeto User dentro da lista reperada
         for (User user : userList) {
             report.append("nome:").append(user.getName()).append("\n").append("CPF").append(user.getCPF()).append("\n\n");
         }
         // Exibe o relatorio final montado na TextView da tela
         textViewReport.setText(report.toString());
         //Método responsável pela navegação entre as telas do app
     }

        public void voltarParaCadastro() {

            //inteçao para abrir a tela de cadastro
            Intent intent = new Intent(ReportActivity.this, MainActivity.class);
            startActivity(intent);
            finish();// Fecha a tela de relatorio para nao acumular na pilha de tarefa

        }
}
