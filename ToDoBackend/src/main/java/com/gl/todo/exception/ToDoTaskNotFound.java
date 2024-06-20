package com.gl.todo.exception;

public class ToDoTaskNotFound extends RuntimeException {

	public ToDoTaskNotFound(String message) {
		super(message);
	}
}
