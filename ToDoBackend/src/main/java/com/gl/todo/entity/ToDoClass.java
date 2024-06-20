package com.gl.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private long id;

	@Column(name = "todo_title")
	private String title;

	@Column(name = "todo_description")
	private String description;

	@Column(name = "todo_completed")
	private boolean completed;
}
