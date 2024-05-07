package com.example.node;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // URL de la API
        String url = "http://192.168.1.5:3000/conejos?p=3&nPar=5&nCri=3&tMor=20";

        // Ejecutar la solicitud HTTP en un hilo separado
        new HttpAsyncTask().execute(url);
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            // Realizar la solicitud HTTP y manejar la respuesta
            String response = new HttpHandler().makeHttpRequest(urls[0]);
            if (response != null) {
                // Si la respuesta no es nula, analizar el JSON y devolver el resultado
                return new JsonParser().parseJson(response);
            } else {
                // Si la respuesta es nula, devolver un mensaje de error
                return "Error al obtener la respuesta del servidor";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Actualizar la interfaz de usuario con el resultado
            resultTextView.setText(result);
        }
    }}
