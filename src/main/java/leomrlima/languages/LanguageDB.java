package leomrlima.languages;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LanguageDB {

  private Set<Language> languages = new LinkedHashSet<>();

  public boolean addLanguage(Language language) {
    return this.languages.add(Objects.requireNonNull(language, "language can't be null"));
  }
  
  public Collection<Language> getAllLanguages() {
    return Collections.unmodifiableSet(languages);
  }
}
