package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Random;


@Route
@PWA(name = "Quess A Number Game", shortName = "Quess A Number Game")
public class MainView extends HorizontalLayout
{
    int number;
    int times = 0;
    long seconds;
    Random random = new Random();
    VerticalLayout menu = new VerticalLayout();
    VerticalLayout label_list = new VerticalLayout();
    TextField name = new TextField("PLAYER NAME");
    Button start = new Button("NEW GAME", event -> start());
    Button enter = new Button("ENTER", event -> enter());
    Label label = new Label("INFORMATION");
    NumberField input = new NumberField();
    public MainView()
    {
        init();
        add(menu);
        add(label_list);
    }

    public void init()
    {
        menu.add(name);
        menu.add(start);
        menu.add(label);
        menu.add(input);
        menu.add(enter);
        enter.setEnabled(false);
        name.setMinWidth("200px");
        start.setMinWidth("200px");
        enter.setMinWidth("200px");
        input.setMinWidth("200px");
    }

    public void start()
    {
        number = random.nextInt(100);
        times = 0;
        seconds = System.nanoTime();
        enter.setEnabled(true);
    }

    public void enter()
    {
        times++;
        if(input.getValue().intValue() == number)
        {
            label_list.add(new Label("Player " + name.getValue() + " have quessed number " + number + " in " + times + " times using " + (System.nanoTime() - seconds)/1000000000 +  " seconds."));
            enter.setEnabled(false);
            label.setText("INFORMATION");
        }
        else
        {
            if(input.getValue().intValue() > number)
            {
                label.setText("X is smaller than " + input.getValue().intValue());
            }
            else
            {
                label.setText("X is larger than " + input.getValue().intValue());
            }
        }
    }


}
