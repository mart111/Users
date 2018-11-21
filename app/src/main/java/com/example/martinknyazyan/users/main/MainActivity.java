package com.example.martinknyazyan.users.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

<<<<<<<Updated upstream:app/src/main/java/com/example/martinknyazyan/users/MainActivity.java
public class MainActivity extends AppCompatActivity {
=======
import com.example.martinknyazyan.users.R
import com.example.martinknyazyan.users.base.BaseActivity

    public class MainActivity extends BaseActivity {
>>>>>>> Stashed changes:app/src/main/java/com/example/martinknyazyan/users/main/MainActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
