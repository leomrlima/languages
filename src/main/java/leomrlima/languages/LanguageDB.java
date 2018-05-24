package leomrlima.languages;

import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;

import java.util.Collection;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.jnosql.artemis.document.DocumentTemplate;

@ApplicationScoped
public class LanguageDB {
  
  @Inject
  private DocumentTemplate template;
  
  public boolean addLanguage(Language language) {
    return template.insert(language) != null;
  }
  
  public Collection<Language> getAllLanguages() {
    return template.select(select().from("Language").build());
  }
  
  public int countAllLanguages() {
    //FIXME: change then JNoSQL supports count!
    return getAllLanguages().size();
  }
  
  public List<Language> fetchLanguages(int offset, int limit) {
    return template.select(select().from("Language").start(offset).limit(limit).build());
  }
}
