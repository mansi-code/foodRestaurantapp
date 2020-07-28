package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class Main6Activity extends AppCompatActivity implements View.OnClickListener{
    int totalamount = 0;
    int count =0;
    TextView t,tname,tphno,tid;
    EditText name,phno;
    Button b1,b2;
    Spinner s1;
    Context myContext;
    DatabaseHandler db = new DatabaseHandler(this);
    private FirebaseAuth firebaseauth;
        //implements View.OnClickListener
        //AdapterView.OnItemSelectedListener
        Integer[] qty = new Integer[]{ 1,2,3,4,5,6,7,8,9,10};
    AlertDialog ad=null;
    AlertDialog.Builder adb=null;

int amt,x;
int quantity=1;
Button b;
CheckBox c1;
    String id ;
    EditText quantityText;
    TextView t2;
    TextView t1;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        t = (TextView)findViewById(R.id.textView);

        name = (EditText)findViewById(R.id.editText);
        phno = (EditText)findViewById(R.id.editText2);
        s1 = (Spinner)findViewById(R.id.spinner);


        b=(Button) findViewById(R.id.myButton);
        c1= (CheckBox) findViewById(R.id.checkBox2);
        Intent j= getIntent();
        int val= j.getIntExtra("menu1",0);

        b2= (Button)findViewById(R.id.show);


        view =this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.pink);
        b2.setOnClickListener(this);
        quantityText= (EditText) findViewById(R.id.quantity_textview);
t2=(TextView) findViewById(R.id.textView4);

         //getting pos and using it for a switch menu to set amt
         switch(val)
         {
             case 1: amt=20;
             t.setText("RAJMA CHAWAL");
             break;
             case 2: amt=30;
                 t.setText("RAJMA CHAWAL");
             break;
             case 3: amt=20;
                 t.setText("CHOLE CHAWAL");
                 break;
             case 4: amt=30;
                 t.setText("CHOLE CHAWAL");
                 break;
             case 5: amt=25;
                 t.setText("CHOLE BHATURE");
             break;
             case 6: amt=35;
                 t.setText("DOSA");
                 break;
             case 7: amt=25;
                 t.setText("IDLI SAMBHAR");
                 break;
             case 8: amt=30; t.setText("CHOWMEIN");
                 break;
             case 9: amt=25;
                 t.setText("SPRING ROLL");
                 break;
             case 10: amt=30;
                 t.setText("PASTA");
                 break;
             case 11: amt=30;
                 t.setText("PAV BHAJI");
                 break;
             default:amt= 0;
                 t.setText("ITEM");
         }





    }

public void increment (View view) {
    quantity = quantity + 1;
    display(quantity);
}

    public void decrement (View view) {
        if (quantity>0){
            quantity = quantity - 1;
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityText.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText("RUPEES " + number);
    }
    public void submitOrder(View view) {


        quantity = Integer.parseInt(quantityText.getText().toString());


int count =0;
        //StringBuilder result = new StringBuilder("YOUR ORDER IS LIKE THIS :" );
        if ((c1.isChecked())&&(quantity>0)) {
            totalamount += (amt * quantity);
            displayPrice(totalamount);

            adb= new AlertDialog.Builder(this);
            adb.setCancelable(false);
            adb.setMessage(" DO YOU WANT TO CONFIRM ORDER ?");

                    adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.d("Insert: ", "Inserting ..");

                            db.addContact(new Contact(name.getText().toString(),phno.getText().toString(),t.getText().toString(),totalamount));
                            Toast.makeText(getApplicationContext(), "YOUR ORDER HAS BEEN PLACED ", Toast.LENGTH_LONG).show();


                        }
                    });
                    adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            Toast.makeText(getApplicationContext(), "ORDER NOT CONFIRMED!!", Toast.LENGTH_LONG).show();

                        }
                    });

            ad=adb.create();
            ad.setTitle("CONFIRM ORDER ");
            ad.show();


            //result.append("\nTotal: " + totalamount + "Rs");
            //t2.setText(result);
            //Displaying the message on the toast
            //result.append("TOTAL BILL "+totalamount +" RS");result.toString()

        }
        else {
            Toast.makeText(getApplicationContext(),"NOTHING SELECTED TO ADD IN CART ", Toast.LENGTH_SHORT).show();
        }


    }


    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
    }  private void Logout()
    {
        firebaseauth.signOut();
        finish();
        startActivity(new Intent(Main6Activity.this,MainActivity.class));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.home: {
                Intent i = new Intent(this, MainActivity4.class);
                startActivity(i);
                break;
            }

            case R.id.mainmenu:
            {
                Intent i = new Intent(this, Main5Activity.class);
                startActivity(i);
                break;
            }
            case R.id.logoutMenu:
            {
               Logout();
            }
            case R.id.settingsMenu:
            {
                Intent i = new Intent(this, settings.class);
                startActivity(i);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Log.d("Reading: ", "Reading all contacts..");
        int size=db.getContactsCount();
        String[] mylist = new String[size];
        int i = 0;
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts)
        {
            String show1= String.valueOf(cn.getID());
            String log = "Id: "+cn.getID()+" ,Lcn: " + cn.getName() + " ,Phn: " + cn.getPhoneNumber()+ " ,order: " + cn.getFood()+ " ,AMt: " + cn.getAmt();
            mylist[i]=log;
            i++;
            Log.d("Name: ", log);
            // Log.d("Name: ", String.valueOf(s1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item,mylist);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);

        s1.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                myContext=view.getContext();
                Toast myToast=new Toast(myContext);

                // tv1.setText(((TextView)view).getText());
                myToast.makeText(myContext,((TextView)view).getText(),Toast.LENGTH_LONG). show();
                //tv1.setText(((TextView)view).getText());

                String s1= ((TextView)view).getText().toString();
                String id1 =s1.substring(4,5);
                Log.d("hello",s1);
                Log.d("hello",id1);
                Contact c = db.getContact(Integer.parseInt(id1));

            }

            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }
}
class DatabaseHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_AMT = "amt";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_FOOD = "food";
    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT," + KEY_FOOD + " TEXT," + KEY_AMT + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }
    void addContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());
        values.put(KEY_FOOD, contact.getFood());
        values.put(KEY_AMT, contact.getAmt());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }
    Contact getContact(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO , KEY_FOOD ,KEY_AMT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getInt(4));
        return contact;
    }
    public List<Contact> getAllContacts()
    {
        List<Contact> contactList = new ArrayList<Contact>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor != null)
            cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contact.setFood(cursor.getString(3));
                contact.setAmt(cursor.getInt(4));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }


    public int getContactsCount()
    {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();
        return cursor.getCount();
    }
}
class Contact
{
    int _id;
    String _name;
    String _phone_number;
    String food;
    int amt;
    public Contact()
    {

    }
    public Contact(int id, String name, String _phone_number, String food, int amt)
    {
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this.food= food;
        this.amt=amt;
    }
    public Contact(String name, String _phone_number,String food, int amt)
    {
        this._name = name;
        this._phone_number = _phone_number;
        this.food= food;
        this.amt=amt;
    }
    public int getID()
{
    return this._id;
}
    public void setID(int id)
    {
        this._id = id;
    }
    public int getAmt()
    {
        return this.amt;
    }
    public void setAmt(int amt)
    {
        this.amt = amt;
    }
    public String getName()
{
    return this._name;
}
    public void setName(String name)
    {
        this._name = name;
    }
    public String getFood()
    {
        return this.food;
    }
    public void setFood(String food)
    {
        this.food =food;
    }
    public String getPhoneNumber(){
        return this._phone_number;
    }
    public void setPhoneNumber(String phone_number)
    {
        this._phone_number = phone_number;
    }
}


