package com.example.manikandanvnair.psc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    private DatabaseReference mDatabase;

    // Choose authentication providers
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
            new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setLogo(R.mipmap.ic_launcher)
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);








//        AuthUI.getInstance()
//                .signOut(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                       Log.println(Log.INFO, "Log", "Logout success");
//
//                    }
//                });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Create and launch sign-in intent

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.println(Log.INFO,"Login first",Integer.toString(resultCode));

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            Log.println(Log.INFO,"Login",Integer.toString(resultCode));

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast toast = Toast.makeText(this, user.getDisplayName(), Toast.LENGTH_LONG);
                toast.show();
                writeNewUser(user.getUid(), user.getDisplayName(),user.getEmail(),user.getPhotoUrl().toString());




                // ...
            } else {
                // Sign in failed, check response for error code
                // ...
                Log.println(Log.INFO,"Login","fail");
            }
        }
    }


    private void writeNewUser(String userId, String name, String email, String imageURL) {
        User user = new User(name, email, imageURL);

        mDatabase.child(User.UserRef).child(userId).setValue(user);
        this.navigate(user);

    }

    public void navigate(User user)
    {
        Intent tabBarView = new Intent(this, NavigationBar.class);
        tabBarView.putExtra("displayName",  user.username);
        tabBarView.putExtra("avatharName",  user.avatharURL);
        tabBarView.putExtra("email",  user.email);
        startActivity(tabBarView);

    }
}
