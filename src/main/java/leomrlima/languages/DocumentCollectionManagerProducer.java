package leomrlima.languages;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManager;

@ApplicationScoped
public class DocumentCollectionManagerProducer {

  private static final String COLLECTION = "languages";

  @Inject
  @ConfigurationUnit(name = "document", fileName = "jnosql.yaml")
  private DocumentCollectionManagerFactory<MongoDBDocumentCollectionManager> managerFactory;

  @Produces
  public DocumentCollectionManager getManager() {
    return managerFactory.get(COLLECTION);
  }
}
