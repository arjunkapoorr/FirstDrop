package com.arjunkapoor.firstdrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

public class VaccineList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_VaccineList);
        Bundle extras = getIntent().getExtras();
        String valuename = extras.getString("name");
        TextView titlename = (TextView) findViewById(R.id.toolbartitle_vaccinelist);
        titlename.setText(valuename);
        String[] vaccineName = {"BCG","Hepatitis B1","OPV0","OPV1 / IPV","DPT1 / DTaP1","Hepatitis B2",
                "HIB1","DPT2 / DTaP2","OPV2 / IPV","HIB2+Hepatitis B3","Hepatitis B4",
                "DPT3 / DTaP3","HIB3","OPV3+IPV","Measels","MMR","DPT / DTaP Booster1",
                "HIB Booster","OPV Booster / IPV1","Typhoid","DPT / DTaP Booster","OPV Booster / IPV2","MMR 2nd Dose",
                "Typhoid 2","Typhoid 3","TD","Typhoid 4","Typhoid 5","TD"};
        String[] description = {"It protects your child against Tuberculosis.Shoud be given as as close of time of birth as possible.",
                "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\nTwo types available:\n-INACTIVE POLIO VACCINE(IPV)\n-ORAL POLIO VACCINE(OPV).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
               "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n-Diphtheria\n-Tetanus\n-Pertussis\n-Polio and\n-HIB(Haemophilus Influenzae type B).",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B)." +
                        " Hepatisis B protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is a individual Vaccine and given in combination with Mumps and Rubella. ",
                "It is MEASLES MUMPS RUBELLA(MMR),is a live attenuated viral Vaccine used to induce immunity against Measles,Mumps,and Rubella.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is given to baby to prevent Typhoid Fever.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is MEASLES MUMPS RUBELLA(MMR),is a live attenuated viral Vaccine used to induce immunity against Measles,Mumps,and Rubella",
                "It is given to baby to prevent Typhoid Fever.",
                "It is given to baby to prevent Typhoid Fever.",
                "TD is a combination vaccine that protects your baby against three potentially diseases:\n-Tetanus\n-Diphtheria\n-Pertussis.TD is a booster vaccine for tetanus and Diphtheria.It does not protect against Pertusis.",
                "It is given to baby to prevent Typhoid Fever.",
                "It is given to baby to prevent Typhoid Fever.",
                "TD is a combination vaccine that protects your baby against three potentially diseases:\n" +
                        "-Tetanus\n" +
                        "-Diphtheria\n" +
                        "-Pertussis.TD is a booster vaccine for tetanus and Diphtheria.It does not protect against Pertusis."};
int i = 0;
        Card card;
        ArrayList<Card> cards = new ArrayList<Card>();

        for(i = 0;i<29;i++) {
             card = new Card(this);
            CardHeader header = new CardHeader(this);
            header.setTitle(vaccineName[i]);
            header.setButtonExpandVisible(true);
            card.addCardHeader(header);
            CardExpand expand = new CardExpand(this);
            expand.setTitle("Description\n"+description[i]);
            card.addCardExpand(expand);
            cards.add(card);

        }




    CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,cards);

    CardListView listView = (CardListView) this.findViewById(R.id.cardlist_vaccinelist);
        if (listView!=null)

    {
        listView.setAdapter(mCardArrayAdapter);
    }


}






    public void backButton(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
    public void addBaby(View view) {

        Intent i = new Intent(this, addBaby.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);


    }



}
