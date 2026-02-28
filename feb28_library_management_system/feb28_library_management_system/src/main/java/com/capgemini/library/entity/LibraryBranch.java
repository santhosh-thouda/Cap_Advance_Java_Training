package com.capgemini.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="library_branches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LibraryBranch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long branchId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String location;
	
	private String contactNumber;
}
