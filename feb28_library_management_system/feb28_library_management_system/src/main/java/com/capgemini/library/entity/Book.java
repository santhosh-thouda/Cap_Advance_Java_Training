package com.capgemini.library.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(unique=true, nullable=false)
	private String isbn;
	
	private int publishYear;

    private int copiesTotal;

    private int copiesAvailable;

    private String status;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // 🔹 Many-to-One → LibraryBranch
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private LibraryBranch branch;

    // 🔹 Many-to-Many → Author
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    
    @OneToMany(mappedBy = "book")
    private List<Loan> loans;
}
