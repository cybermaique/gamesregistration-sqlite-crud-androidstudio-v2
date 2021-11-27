package content;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_game);
    }

    public void updateButtonPressed(View view) {
        EditText oldNameET = findViewById(R.id.name1ET);
        EditText newNameET = findViewById(R.id.name2ET);
        EditText genreET = findViewById(R.id.genre1ET);

        String oldName = oldNameET.getText().toString();
        String newName = newNameET.getText().toString();
        String newGenre = genreET.getText().toString();

        DatabaseHandler.updateUsingName(oldName, newName, newGenre);
        Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show();

        oldNameET.setText("");
        newNameET.setText("");
        genreET.setText("");
    }
}
