package ie.anu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final HorizontalLayout masterLayout = new HorizontalLayout();
        final VerticalLayout layout = new VerticalLayout();
        final VerticalLayout layout1 = new VerticalLayout();
        
        final TextField drugField = new TextField();
        drugField.setCaption("Type drug name here:");
        final TextField pDose = new TextField();
        pDose.setCaption("Presdcribed dose");

       

        Button button = new Button("Press Me to calculate the volume");
        button.addClickListener(e -> {
        Label logo1 = new Label("You want to calculate the volume for " + drugField.getValue() 
                    + " where prescribed dose is " + pDose.getValue());
                    layout1.addComponent(logo1);
            
        });

        layout.addComponents(drugField,pDose);        
        
        masterLayout.addComponents(layout, button, layout1);
        
        setContent(masterLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

        private static final long serialVersionUID = 1L;
    }
}
