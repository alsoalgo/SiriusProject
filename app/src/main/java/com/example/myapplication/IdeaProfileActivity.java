package com.example.myapplication;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class IdeaProfileActivity
        extends AppCompatActivity {

    private boolean flag = false;
    private ImageButton CounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        CounterButton = (ImageButton) findViewById(R.id.imageButton);

        CounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag) {
                    CounterButton.setColorFilter(Color.parseColor("#CBCC00"));
                } else {
                    CounterButton.setColorFilter(Color.parseColor("#92a2bc"));
                }
            }
        });

        ImageView image = (ImageView) findViewById(R.id.iv);
        image.setImageResource(R.drawable.bike);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText("1972 BARKAS B1000");

        TextView generated = (TextView) findViewById(R.id.generated);
        generated.setText("Иван Петров, 25 мая 2017");

        TextView description = (TextView) findViewById(R.id.description);
        description.setText("Barkas (VEB Barkas-Werke) — автопроизводитель в ГДР, в период с 1961 по 1991 год выпускавшиймикроавтобусы и развозные фургоны модели B1000, а также и лёгкие грузовики и спецавтомобили на их основе.\n" +
                "\n" +
                "Производство было создано на базе национализированного правительством ГДР автозавода компании Framo в Карл-Маркс-Штадте (ныне Хемниц).\n" +
                "\n" +
                "Сборочное производство предприятия отличалось низкой автоматизацией и высокой долей ручного труда. При этом единственная выпускаемая модель несколько десятилетий не подвергалась серьёзной модернизации, и к началу 1990-х гг. сильно устарела. После объединения Германии продукция Barkas оказалась неконкурентноспособной, и 10 апреля 1991 года конвейер автозавода был остановлен.\n" +
                "\n" +
                "В 1993 оборудование предприятия было демонтировано и упаковано для отправки в Россию с целью организации производства микроавтобусов на Кировском заводе под Санкт-Петербургом, однако из-за отсутствия свободноконвертируемой валюты у российской стороны сделка не состоялась, и весь подготовленный к отправке груз был сдан в металлолом.\n" +
                "\n" +
                "В настоящее время на месте прежнего завода в Хемнице располагается сборочное производство двигателей Фольксваген.");
    }
}
