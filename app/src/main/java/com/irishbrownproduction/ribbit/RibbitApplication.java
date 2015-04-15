package com.irishbrownproduction.ribbit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by IrishBrownProduction on 4/14/2015.
 */
//Add RibbitApplication to manifest under application , if it shows here as never been used.
public class RibbitApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "rPJcOpfmfmvoRrFqJwD3vXUpbQ8aK9MyTRncTQIg", "tPe1qZoMY62lwR1vjc49vF15INmnodDjCrp5BFbk");

       /* ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
    }
}
