package adapters.recyclerview.event;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.japhethwaswa.church.databinding.ItemEventBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import db.ChurchContract;
import model.Event;
import model.dyno.ApplicationContextProvider;
import service.ChurchWebService;

public class EventViewHolder extends RecyclerView.ViewHolder{

    private ItemEventBinding itemEventBinding;
    private final Button registerButton;

    public EventViewHolder(View itemView) {
        super(itemView);
        itemEventBinding = DataBindingUtil.bind(itemView);
        registerButton = itemEventBinding.registerEvent;
    }

    public void bind(Cursor cursor){

        Event event = new Event();

        if(cursor.isClosed() == false && cursor != null){
            event.setEvent_title(cursor.getString(cursor.getColumnIndex(ChurchContract.EventsEntry.COLUMN_TITLE)));
            event.setImage_url(ChurchWebService.getRootAbsoluteUrl(ApplicationContextProvider.getsContext(),cursor.getString(cursor.getColumnIndex(ChurchContract.EventsEntry.COLUMN_IMAGE_URL))));
            event.setBrief_description(cursor.getString(cursor.getColumnIndex(ChurchContract.EventsEntry.COLUMN_BRIEF_DESCRIPTION)));

            /**date format**/
            String eventDate = "";
            String dateString = cursor.getString(cursor.getColumnIndex(ChurchContract.EventsEntry.COLUMN_EVENT_DATE));
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            try {
                Date date = dtFormat.parse(dateString);

                SimpleDateFormat dtFormatOutPut = new SimpleDateFormat("EEE, d MMM yyyy 'at' hh:mm aaa");
                eventDate =  dtFormatOutPut.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            event.setEvent_date(eventDate);
            /****/

            event.setCreated_at(cursor.getString(cursor.getColumnIndex(ChurchContract.EventsEntry.COLUMN_CREATED_AT)));

        }

        itemEventBinding.setEvent(event);
    }

    //return register button
    public Button getRegisterButton(){
        return registerButton;
    }

}
