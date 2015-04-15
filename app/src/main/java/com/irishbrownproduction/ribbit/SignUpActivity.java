package com.irishbrownproduction.ribbit;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;


public class SignUpActivity extends ActionBarActivity {
    //L1.Declare member variables for items in the layout
    protected EditText mUsername;
    protected EditText mPassword;
    protected EditText mEmail;
    protected Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //L2. Set the member varaible with find view by ID
        mUsername = (EditText)findViewById(R.id.usernameField);
        mPassword = (EditText)findViewById(R.id.passwordField);
        mEmail = (EditText)findViewById(R.id.emailField);
        mSignUpButton = (Button)findViewById(R.id.signupButton);//L2a. cast this one as Button vs EditText
        //L3. Set on click listener for button
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //L4. once button is pressed the values are checked and return message
                String username = mUsername.getText().toString();//L5. Convert the edited text to string
                String password = mPassword.getText().toString();
                String email = mEmail.getText().toString();

                //L6. Trim insure values are not empty & Trim white spaces from value in case the user accidentally hit the space bar
                //L6. Call the trim method and store the result into the same variable
                username = username.trim();
                password = password.trim();
                email = email.trim();

                //L7. If statement check each value
                if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
                    //L7a. ise a dialog so the user will have to take some action to dismiss it vs toast that goes away on its own
                    AlertDialog.Builder builder /* <-- name of dialog*/ = new AlertDialog.Builder(SignUpActivity.this);
                    //L7b. Set message chain the 3 lines togather, remove ; and take builder front of .set...
                    builder.setMessage(R.string.sign_up_error_message)//L7b. Will need to create string resource to be used by dialog (res/values/strings.xml)
                    //L7c. Set title
                        .setTitle(R.string.sign_up_error_title)
                    //L7d. Set text. the positive button dismiss the dialog
                        .setPositiveButton(android.R.string.ok,/*listener*/ null);//L7b. for the listener pass a null and that dismisses the dialog
                    //L7e. create and show dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                else{
                    //this is where we will create hte new user
                    //M1. Create  new user in Parse
                    ParseUser newUser = new ParseUser();
                    //M2.

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
