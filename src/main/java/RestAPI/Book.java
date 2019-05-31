package RestAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Book {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank
	private String author;
	@NotBlank
	private String title;
	
	private int pageCount;
	private String comments;
	
	public Book(){
		
		author = "";
		title = "";
		pageCount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book( String author, String title, int pageCount ){
		
		this.author = author;
		this.title = title;
		this.pageCount = pageCount;
	}
	
	public void setAuthor( String author ){
		this.author = author;
	}
	
	
	public String getAuthor(){
		return author;
	}
	
	public void setTitle( String title ){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}

	public void setPageCount( int pageCount ){
		this.pageCount = pageCount;
	}
	
	public int getPageCount(){
		return pageCount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
