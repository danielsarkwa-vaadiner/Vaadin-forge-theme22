package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.vaadin.example.util.NavTitle;
import org.vaadin.example.views.*;

public class MainView extends AppLayout {
    public MainView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new NavTitle();
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);
    }


    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.add(
            createTab("Button", ButtonView.class),
            createTab("Checkbox", CheckboxView.class),
            createTab("Radio", RadioButtonView.class),
            createTab("Text Field", TextFieldView.class),
            createTab("Email Field", EmailFieldView.class),
            createTab("Number Field", NumberFieldView.class),
            createTab("Password Field", PasswordFieldView.class),
            createTab("Text Area", TextAreaView.class),
            createTab("Select", SelectView.class),
            createTab("Combo Box", ComboBoxView.class),
            createTab("Date Picker", DatePickerView.class),
            createTab("Time Picker", TimePickerView.class),
            createTab("Date Time Picker", DateTimePickerView.class),
            createTab("Checkout Demo",  CheckoutView.class),
            createTab("Components",  ComponentsView.class)
            // add tab
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private Tab createTab(String viewName, Class<? extends Component> content) {
        RouterLink link = new RouterLink(viewName, content);
        link.setTabIndex(-1);
        return new Tab(link);
    }
}