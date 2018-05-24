package leomrlima.languages;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalSplitPanel;
import javax.inject.Inject;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@Title("Languages")
@PreserveOnRefresh
@CDIUI("ui")
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
public class LanguageApp extends UI {

  @Inject
  private LanguageDB languageDB;

  @Override
  protected void init(VaadinRequest request) {
    VerticalSplitPanel sample = new VerticalSplitPanel();
    sample.setSizeFull();
    sample.setSplitPosition(250, Unit.PIXELS);

    Grid<Language> secondComponent = createDataGrid();
    secondComponent.setWidth(100, Unit.PERCENTAGE);

    Component firstComponent = createLanguageForm(secondComponent);
    firstComponent.setWidth(100, Unit.PERCENTAGE);

    sample.setFirstComponent(firstComponent);
    sample.setSecondComponent(secondComponent);

    setContent(sample);
  }

  private Grid<Language> createDataGrid() {
    Grid<Language> grid = new Grid<>();
    grid.setSizeFull();

    grid.setItems(languageDB.getAllLanguages());
    grid.setSelectionMode(SelectionMode.NONE);

    grid.addColumn(Language::getName).setCaption("Name");
    grid.addColumn(Language::getLink).setCaption("Link");

    return grid;
  }

  private Component createLanguageForm(Grid<Language> gridToUpdate) {
    FormLayout sample = new FormLayout();
    sample.setMargin(true);
    sample.addStyleName("outlined");
    sample.setSizeFull();

    final TextField name = new TextField("Name");
    name.setWidth(100.0f, Unit.PERCENTAGE);
    sample.addComponent(name);

    final TextField link = new TextField("Link");
    link.setWidth(100.0f, Unit.PERCENTAGE);
    sample.addComponent(link);

    sample.addComponent(new Button("Add", __ -> {
      LoggerFactory.getLogger(getClass()).info("Adding new language!");
      Language language = new Language();
      language.setLink(link.getValue());
      language.setName(name.getValue());
      if (languageDB.addLanguage(language)) {
        Notification.show("Language added!");
        gridToUpdate.getDataProvider().refreshAll();
      } else {
        Notification.show("Count not add language!", Notification.Type.WARNING_MESSAGE);
      }
    }));

    return sample;
  }

}
