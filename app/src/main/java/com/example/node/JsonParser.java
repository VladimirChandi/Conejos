package com.example.node;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public String parseJson(String jsonString) {
        String result = "";
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            int pAnual = jsonObject.getInt("pAnual");
            int pMorir = jsonObject.getInt("pMorir");
            int pRestante = jsonObject.getInt("pRestante");
            int nParejas = jsonObject.getInt("nParejas");
            int nCrias = jsonObject.getInt("nCrias");

            result = "Población Anual: " + pAnual +
                    "\nPoblación Muerta: " + pMorir +
                    "\nPoblación Restante: " + pRestante +
                    "\nNúmero de Parejas: " + nParejas +
                    "\nNúmero de Crías: " + nCrias;

        } catch (JSONException e) {
            e.printStackTrace();
            // Manejar la excepción devolviendo un mensaje de error
            return "Error al analizar el JSON";
        }
        return result;
    }
}
