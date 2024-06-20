package com.gl.todo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gl.todo.dto.ToDoDto;
import com.gl.todo.entity.ToDoClass;

public interface ToDoService {

	ToDoDto creatToDoTask(ToDoDto dto);

	List<ToDoDto> getAllToDoTask();

	ToDoDto updateToDoTask(long id, ToDoDto updatetoDoTask);

	void deleteToDoTask(long id);

	ToDoDto getToDOTaskById(long id);

	ToDoDto completeTask(long taskId);

	ToDoDto incompleteTask(long taskId);
}
