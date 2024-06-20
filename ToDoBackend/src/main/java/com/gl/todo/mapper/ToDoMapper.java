package com.gl.todo.mapper;

import com.gl.todo.dto.ToDoDto;
import com.gl.todo.entity.ToDoClass;

public class ToDoMapper {

	public static ToDoDto mapToDoDto(ToDoClass todo) {

		return new ToDoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
	}

	public static ToDoClass mapToDoClass(ToDoDto dto) {
		return new ToDoClass(dto.getId(), dto.getTitle(), dto.getDescription(), dto.isCompleted());
	}
}
