package com.example.orientationandlistviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    TextView display;
    TextView description;
    int selectedPosition;

    WebView webView;
    ImageButton questionButton;


    ArrayList<GreekGod> list = new ArrayList<>();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        description = findViewById(R.id.textView5);
        display = findViewById(R.id.descriptionDisplay);
        //webView = findViewById(R.id.webView);
        //webView.setWebViewClient(new WebViewClient());
        questionButton = findViewById(R.id.questionButton);

        list.add(new GreekGod("Aphrodite", R.drawable.aphrodite, "The god of beauty, love, desire and pleasure. Really strong, but surprisingly evil. 10/10 powers, 0/10 personality", "Married to Hephaestus, loved Ares", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=2ahUKEwi3_t6r27HmAhWDhOAKHcc2AtAQFjAAegQIAhAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Faphrodite%2F&usg=AOvVaw2MvEEjxz6iMBfgFMcDP4d7"));
        list.add(new GreekGod("Apollo", R.drawable.apollo,"The god of music, arts, healing, prophecy and archery. 5/10 powers, 10/10 personality, ", "Loved Daphne, and Kyrene", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=14&cad=rja&uact=8&ved=2ahUKEwiX96ii27HmAhVmU98KHQLSAN8QFjANegQIAxAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fapollo%2F&usg=AOvVaw3kxAt8nHCzAcSIQGAz8lDY"));
        list.add(new GreekGod("Ares", R.drawable.ares, "The god of war, bloodshed and violence. Kind of a jerk, and rightfully gets rejected a lot. 10/10 powers, 0/10 personality", "Loved Aphrodite, got rejected by Athena", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwjrm9Sb27HmAhXhV98KHY_dB3UQFjACegQIDRAH&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fares%2F&usg=AOvVaw0S9C6XLrrvIVE28ZThuyKe"));
        list.add(new GreekGod("Artemis", R.drawable.artemis, "The goddess of the hunt, wilderness, animals. A rare, mostly good person! 10/10 personality, 10/10 powers.", "Mostly single, except she loved Orion, except she got tricked into killing him", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwjFqPCQ27HmAhVBUt8KHdBXDKcQFjACegQIDRAH&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Fartemis%2F&usg=AOvVaw2QlvnJYny8PhTgQ14yosyS"));
        list.add(new GreekGod("Athena", R.drawable.athena, "The god of wisdom, warfare and  strategy. A rare, mostly good person! 10/10 personality, 10/10 powers.", "Never married or loved, but bore children", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwi9yPSD27HmAhUMTN8KHfkLBpYQFjACegQIDxAH&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Fathena%2F&usg=AOvVaw3B4LIis7Uk0c4ai2MRyQdG"));
        list.add(new GreekGod("Demeter", R.drawable.demeter, "The god of agriculture and harvest. Almost as lame as hermes: 8/10 personality, 0/10 powers.", "Loved Iason, had children with Zeus and Poseidon", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwiBnMb72rHmAhXyUt8KHalsDD0QFjACegQIDhAH&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Fdemeter%2F&usg=AOvVaw2Mr_n-Lj5HovWSU8qhAJ34"));
        list.add(new GreekGod("Dionysus", R.drawable.dionysus, "The god of wine, parties and the theater. Has drugged way too many women. 0/10 powers, 0/10 personality", "Loved Aphrodite, the mortal Althaia", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=12&cad=rja&uact=8&ved=2ahUKEwib7urz2rHmAhVBT98KHe85AGgQFjALegQIAxAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fdionysus%2F&usg=AOvVaw28g1OEY-JnP28lHxBMVdt4"));
        list.add(new GreekGod("Hades", R.drawable.hades,"The god of the underworld. Terrible person. Kinda cool though. 9/10 powers, 0/10 personality" , "Married to Persephone(not by her choice)", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=13&cad=rja&uact=8&ved=2ahUKEwiA3K7r2rHmAhXxQd8KHbM7ArkQFjAMegQIBhAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fhades%2F&usg=AOvVaw31acYH3fGfyQlgUXdFGck6"));
        list.add(new GreekGod("Hephaestus", R.drawable.hephaestus, "The god of fire, metalworking and crafts. All the gods are shallow, so no one likes Hephastus cause he's ugly. 10/10 powers, 10/10 personality", "Married to Aphrodite, one consort was the sea nymph, Cabeiro", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=2ahUKEwjNpYLi2rHmAhXBVt8KHSnsD7EQFjAAegQIAxAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fhephaestus%2F&usg=AOvVaw0lEdDWAqHLjpgkfp5A_s9i"));
        list.add(new GreekGod("Hera", R.drawable.hera, "The goddess of marriage and childbirth. Has killed a lot of women, but almost understandable because Zeus slept with all of them. 1/10 powers, 1/10 personality", "Married to Zeus", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=2ahUKEwim5LXY2rHmAhVwTd8KHX3CCM0QFjAAegQIARAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Fhera%2F&usg=AOvVaw1TOYeK-ipATdcJf5i3qpum"));
        list.add(new GreekGod("Hermes", R.drawable.hermes, "The god of travel and communication. Probably the lamest god. 0/10 powers, 0/10 personality", "Loved Peitho and Aphrodite", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=10&cad=rja&uact=8&ved=2ahUKEwi-pJjO2rHmAhUIhOAKHS-DDtYQFjAJegQIARAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fhermes%2F&usg=AOvVaw2DnLNAAcaCsIw3lIuJlb_A"));
        list.add(new GreekGod("Hestia", R.drawable.hestia, "The goddess of the hearth, home and chastity. A rare, mostly good person! 10/10 personality, 10/10 powers.", "Single", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=13&cad=rja&uact=8&ved=2ahUKEwjQy9OX2rHmAhVwmuAKHUW9DNYQFjAMegQIARAB&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgoddesses%2Fhestia%2F&usg=AOvVaw0DixSRBOOYv6FfBtzmFkhf"));
        list.add(new GreekGod("Poseidon", R.drawable.images, "The sea, rivers and earthquakes. Clearly the coolest powers. Also has sexually assaulted a lot of people...10/10 powers, 0/10 personality.", "Loved Amphitrite but had countless affairs, ", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwj4ic6J2rHmAhXJSt8KHRqkAuIQFjACegQIDRAH&url=https%3A%2F%2Fgreekgodsandgoddesses.net%2Fgods%2Fposeidon%2F&usg=AOvVaw2UuKynLDO7JqOVHxjPM_xb"));
        list.add(new GreekGod("Zeus", R.drawable.zeus, "The king of gods, the sky and lightning. Few redeeming qualities other than his powers. 10/10 powers, 0/10 personality", "Too many lovers to keep track", "https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=2ahUKEwj14Lrx2bHmAhUKn-AKHbgoDxgQFjACegQIDhAG&url=https%3A%2F%2Fwww.greekmythology.com%2FOlympians%2FZeus%2Fzeus.html&usg=AOvVaw3oUKMpQtMEAqovYAQDQfh7"));


        if(savedInstanceState != null){ // in landscape mode

            list = (ArrayList<GreekGod>) savedInstanceState.getSerializable("LIST");
            selectedPosition = savedInstanceState.getInt("POSITION");

            int orientation = getResources().getConfiguration().orientation;

            if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (selectedPosition < list.size()) {
                    if (description != null) {
                        description.setText(list.get(selectedPosition).getPurview());
                    }
                    display.setText(list.get(selectedPosition).getLovers());



        }

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_custom, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;

                display.setText(list.get(position).getLovers());

                if(savedInstanceState != null ) {
                    if(description != null) {
                        description.setText(list.get(position).getPurview());
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("POSITION", selectedPosition);
        outState.putSerializable("LIST", list);
    }

    public class GreekGod implements Serializable {
        String name;
        int image;
        String purview;
        String lovers;
        String webpage;


        public GreekGod (String name, int image, String purview, String lovers, String webpage){
            this.name = name;
            this.image = image;
            this.purview = purview;
            this.lovers = lovers;
            this.webpage = webpage;

        }
        public int getImageID(){
            return image;
        }
        public String getName() {
            return name;
        }
        public String getPurview() {
            return purview;
        }
        public String getLovers() {
            return lovers;
        }
        public String getWebpage() {
            return webpage;
        }
    }
    public class CustomAdapter extends ArrayAdapter<GreekGod> {
        List<GreekGod> list;
        Context context;
        int xmlResource;


        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<GreekGod> objects) {
            super(context, resource, objects);
            this.context = context;
            xmlResource = resource;
            list = objects;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //return super.getView(position, convertView, parent);

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            final View adapterView = inflater.inflate(xmlResource, null);

            TextView text = adapterView.findViewById(R.id.textView);
            ImageView image = adapterView.findViewById(R.id.imageView);
            //TextView description = adapterView.findViewById(R.id.description);
            ImageButton remove = adapterView.findViewById(R.id.remove);
            remove.setBackgroundColor(Color.WHITE);

            //FUNCTIONALITY
            int orientation = getResources().getConfiguration().orientation;

                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });

            GreekGod currentObject = list.get(position);
            text.setText(currentObject.getName());
            image.setImageResource(currentObject.getImageID());

            return adapterView;

        }


    }

}
