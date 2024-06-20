package com.gl.todo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.ToDoDto;
import com.gl.todo.entity.ToDoClass;
import com.gl.todo.service.ToDoService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todotask")
@AllArgsConstructor
public class ToDoTaskController {

	ToDoService toDoService;

	@PostMapping
	public ResponseEntity<ToDoDto> createToDoTask(@RequestBody ToDoDto taskDto) {

		ToDoDto newDto = toDoService.creatToDoTask(taskDto);

		return new ResponseEntity<ToDoDto>(newDto, HttpStatus.CREATED);
	}

	@GetMapping
	public List<ToDoDto> getAllToDoList() {
		return toDoService.getAllToDoTask();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ToDoDto> updateToDoTask(@RequestBody ToDoDto updateToDoDto, @PathVariable long id) {

		ToDoDto newDto = toDoService.updateToDoTask(id, updateToDoDto);
		return new ResponseEntity<ToDoDto>(newDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteToDO(@PathVariable long id) {
		toDoService.deleteToDoTask(id);
		return ResponseEntity.ok(" To-Do task with id " + id + " deleted successfully");

	}

	@GetMapping("/{id}")
	public ResponseEntity<ToDoDto> getToDoTaskById(@PathVariable long id) {

		ToDoDto todoObj = toDoService.getToDOTaskById(id);

		return ResponseEntity.ok(todoObj);
	}

	@PutMapping("/{id}/complete")
	public ResponseEntity<ToDoDto> completedTask(@PathVariable long id) {

		ToDoDto dtoObj = toDoService.completeTask(id);
		return ResponseEntity.ok(dtoObj);
	}

	@PutMapping("/{id}/incomplete")
	public ResponseEntity<ToDoDto> incompletedTask(@PathVariable long id) {

		ToDoDto dtoObj = toDoService.incompleteTask(id);
		return ResponseEntity.ok(dtoObj);
	}

}
