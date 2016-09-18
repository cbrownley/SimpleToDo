package com.clinton.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    private EditText etEditItem;
    private int editItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        // Set Title for Activity
        getSupportActionBar().setTitle("Edit Item");

        Bundle bundle = getIntent().getExtras();
        String editItemText = bundle.getString("todoItem");
        editItemIndex = bundle.getInt("itemIndex");
        etEditItem = (EditText) findViewById(R.id.etTextToEdit);
        setupReturnKeyListenerForEditText();
        populateEditText(editItemText);
    }

    private void setupReturnKeyListenerForEditText() {
        etEditItem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_DONE) {
                    onSave(v);
                    handled = true;
                }
                return handled;
            }
        });
    }

    public void populateEditText(String editItemText) {
        etEditItem.setText(editItemText);
        etEditItem.setSelection(editItemText.length());
        etEditItem.requestFocus();
        // Set keyboard to appear after etEditItem is in focus
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public void onSave(View v) {
        Intent editedTextData = new Intent(EditItemActivity.this, MainActivity.class);
        editedTextData.putExtra("editedItemText", preferredCase(etEditItem.getText().toString()));
        editedTextData.putExtra("editedItemIndex", editItemIndex);
        setResult(RESULT_OK, editedTextData);
        this.finish();
    }

    public void onCancel(View view) {
        this.finish();
    }

    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.etTextToEdit);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etName.getText().toString());
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public static String preferredCase(String original) {
        if (original.isEmpty())
            return original;
        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_save) {
            Intent editedTextData = new Intent(EditItemActivity.this, MainActivity.class);
            editedTextData.putExtra("editedItemText", preferredCase(etEditItem.getText().toString()));
            editedTextData.putExtra("editedItemIndex", editItemIndex);
            setResult(RESULT_OK, editedTextData);
            this.finish();
            return true;
        }

        if (id == R.id.action_cancel) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
