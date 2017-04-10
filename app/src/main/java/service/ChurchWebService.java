package service;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.japhethwaswa.church.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChurchWebService {

    //app-run-false
    public static void serviceGetEntireBible(Context context) {

        //todo perform bible_books,bible_chapters,bible_verses file creaations and write data to them.(remove after getting data i files)

String[] bibleBooks = {"genesis","exodus","leviticus","numbers","deuteronomy","Joshua","Judges","Ruth","1Samuel","2Samuel",
"1Kings","2Kings","1Chronicles","2Chronicles","Ezra","Nehemiah","Esther","Job","Psalms","Proverbs","Ecclesiastes","SongofSongs",
"Isaiah","Jeremiah","Lamentations","Ezekiel","Daniel","Hosea","Joel","Amos","Obadiah","Jonah","Micah","Nahum","Habakkuk","Zephaniah",
"Haggai","Zechariah","Malachi","Matthew","Mark","Luke","John","Acts","Romans","1Corinthians","2Corinthians","Galatians","Ephesians",
"Philippians","Colossians","1Thessalonians","2Thessalonians","1Timothy","2Timothy","Titus","Philemon","Hebrews","James","1Peter",
"2Peter","1John","2John","3John","Jude","Revelation"};

        Resources res = context.getResources();
        String bibleApi = res.getString(R.string.bibleApi);
        for(String bibleBook : bibleBooks){

            String relativeUrl = bibleApi + "json?p="+bibleBook;
            AndroidNetworking.get(relativeUrl)
                    .setTag("bibleData")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            parseBibleData(response);
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.e("jeff-waswa-bib-err",anError.toString());
                        }
                    });

        }

      /** try {
            File fileName = new File(context.getFilesDir().getPath() + "/bible_books.txt");
            FileOutputStream fOut = new FileOutputStream(fileName, true);
            //FileOutputStream fOut = openFileOutput("bible_books", Context.MODE_PRIVATE);
            String str = "Hello world 18";
            fOut.write(str.getBytes());
            fOut.close();

            FileInputStream fin = new FileInputStream(fileName);
            int c;
            String temp = "";
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            fin.close();
            Log.e("jeff-waswa", temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
**/

    }

    //parse bible data
    private static void parseBibleData(String response) {
        try {
            //Log.e("jeff-waswa",response);
            response = response.replace("(","");
            response = response.replace(")","");
            JSONObject responseJsonObj = new JSONObject(response);
            //JSONObject responseJsonObj = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
            String bookName = responseJsonObj.getString("book_name");
            Log.e("jeffw-waswa",bookName);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
