package content;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddGameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

    }

    public void addButtonPressed(View view) {
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText genreEditText = findViewById(R.id.genreEditText);

        String name = nameEditText.getText().toString();
        String genre = genreEditText.getText().toString();

        addToDatabase(name, genre);

        nameEditText.setText("");
        genreEditText.setText("");
    }


    private void addToDatabase(String name, String genre) {
        DatabaseHandler.addToDatabase(name, genre);
        Toast.makeText(this, "Record Added",Toast.LENGTH_SHORT).show();
    }
}
