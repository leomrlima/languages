package leomrlima.languages;

public class Comment {

  private String commenter;
  private String comment;

  public String getCommenter() {
    return commenter;
  }

  public void setCommenter(String commenter) {
    this.commenter = commenter;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((comment == null) ? 0 : comment.hashCode());
    result = prime * result + ((commenter == null) ? 0 : commenter.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Comment [commenter=" + commenter + ", comment=" + comment + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Comment other = (Comment) obj;
    if (comment == null) {
      if (other.comment != null)
        return false;
    } else if (!comment.equals(other.comment))
      return false;
    if (commenter == null) {
      if (other.commenter != null)
        return false;
    } else if (!commenter.equals(other.commenter))
      return false;
    return true;
  }

}
