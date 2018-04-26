package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJSONObject = new JSONObject(json);
            JSONObject nameObj = sandwichJSONObject.getJSONObject("name");

            // Getting Main name from name object
            String mainName = nameObj.getString("mainName");

            // Looping through json array to alsoKnownAs String List array
            JSONArray alsoKnownAsJSONArray = nameObj.optJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();
            if (alsoKnownAsJSONArray != null) {
                int jsonLength = alsoKnownAsJSONArray.length();
                for (int i = 0; i < jsonLength; i++ ) {
                    alsoKnownAs.add(alsoKnownAsJSONArray.getString(i));
                }
            }

            // Getting the placeOfOrigin from sandwich object
            String placeOfOrigin = sandwichJSONObject.getString("placeOfOrigin");

            // Getting the description from sandwich object
            String description = sandwichJSONObject.getString("description");

            // Getting the image from sandwich object
            String image = sandwichJSONObject.getString("image");

            // Looping through json array to ingredients String List array
            JSONArray ingredientsJSONArray = sandwichJSONObject.optJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();
            if (ingredientsJSONArray != null) {
                int jsonLength = ingredientsJSONArray.length();
                for (int i = 0; i < jsonLength; i++ ) {
                    ingredients.add(ingredientsJSONArray.getString(i));
                }
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            return sandwich;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
