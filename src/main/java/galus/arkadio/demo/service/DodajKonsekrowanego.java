package galus.arkadio.demo.service;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import galus.arkadio.demo.entity.EtapWspolnotowy;
import galus.arkadio.demo.entity.Konsekrowany;
import galus.arkadio.demo.entity.NazwaEtapu;
import galus.arkadio.demo.entity.repository.Repository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("Dodaj Konsekrowanego")
@RolesAllowed("User")
public class DodajKonsekrowanego extends VerticalLayout{


    @Autowired
    public DodajKonsekrowanego(Repository repository) {

        TextField textFieldImie = new TextField("imie");
        TextField textFieldNazwisko = new TextField("Nazwisko");
        TextField textFielOaza = new TextField("Oaza");
        DatePicker picker = new DatePicker("Podaj date urodzenia");
        picker.setWeekNumbersVisible(true);
        DatePicker entrata = new DatePicker("Entrata");
        entrata.setWeekNumbersVisible(true);
        DatePicker richiesta = new DatePicker("Richiesta");
        richiesta.setWeekNumbersVisible(true);
        DatePicker primi_voti = new DatePicker("Primi_Voti");
        primi_voti.setWeekNumbersVisible(true);
        DatePicker rinnovo = new DatePicker("Rinnovo");
        rinnovo.setWeekNumbersVisible(true);
        DatePicker perpetui = new DatePicker("Voti_Perpetui");
        perpetui.setWeekNumbersVisible(true);
        Button buttonDodaj = new Button("Dodaj Konsekrowanego");


        buttonDodaj.addClickListener (buttonClickEvent -> {
            Konsekrowany konsekrowany = new Konsekrowany();
            konsekrowany.setId(1L);
            konsekrowany.setName(textFieldImie.getValue());
            konsekrowany.setLastname(textFieldNazwisko.getValue());
            konsekrowany.setOasis(textFielOaza.getValue());
            konsekrowany.setBirthDay(picker.getValue());
            List<EtapWspolnotowy>etapWspolnotowyList = new ArrayList<>();
            etapWspolnotowyList.add(new EtapWspolnotowy(NazwaEtapu.ENTRATA,entrata.getValue()));
            etapWspolnotowyList.add(new EtapWspolnotowy(NazwaEtapu.RICHIESTA,richiesta.getValue()));
            etapWspolnotowyList.add(new EtapWspolnotowy(NazwaEtapu.PRIMI_VOTI,primi_voti.getValue()));
            etapWspolnotowyList.add(new EtapWspolnotowy(NazwaEtapu.RINNOVO,rinnovo.getValue()));
            etapWspolnotowyList.add(new EtapWspolnotowy(NazwaEtapu.VOTI_PERPETUI,perpetui.getValue()));
            konsekrowany.setEtapWspolnotowyList(etapWspolnotowyList);

            repository.save(konsekrowany);

            Notification notification = new Notification("Konsekrowany został dodany do bazy danych ", 3000);
            notification.open();


        });


        add(textFieldImie,textFieldNazwisko,textFielOaza,picker,entrata,richiesta,primi_voti,rinnovo,perpetui,buttonDodaj);



    }

}
