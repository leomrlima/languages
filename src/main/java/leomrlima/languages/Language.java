package leomrlima.languages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

@Entity
public class Language {

  @Id
  private String name;
  
  @Column
  private String link;
  
  private List<Comment> comments = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public List<Comment> getComments() {
    return Collections.unmodifiableList(comments);
  }

  protected void setComments(List<Comment> newComments) {
    this.comments.clear();
    if (newComments != null && !newComments.isEmpty())
      this.comments.addAll(newComments);
  }

  public void addComment(Comment comment) {
    this.comments.add(Objects.requireNonNull(comment, "comment can't be null"));
  }

  @Override
  public String toString() {
    return "Language [name=" + name + ", link=" + link + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Language other = (Language) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
