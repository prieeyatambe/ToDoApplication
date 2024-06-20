package com.gl.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gl.todo.dto.ToDoDto;
import com.gl.todo.entity.ToDoClass;
import com.gl.todo.exception.ToDoTaskNotFound;
import com.gl.todo.mapper.ToDoMapper;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

	ToDoRepository toDoRepository;

	@Override
	public ToDoDto creatToDoTask(ToDoDto dto) {

		ToDoClass newToDoTask = ToDoMapper.mapToDoClass(dto);
		ToDoClass saveToDoTask = toDoRepository.save(newToDoTask);
		return ToDoMapper.mapToDoDto(saveToDoTask);
	}

	@Override
	public List<ToDoDto> getAllToDoTask() {

		List<ToDoClass> taskList = toDoRepository.findAll();
		return taskList.stream().map((task) -> ToDoMapper.mapToDoDto(task)).toList();
	}

	@Override
	public ToDoDto updateToDoTask(long id, ToDoDto updatetoDoTask) {

		ToDoClass toDoObj = toDoRepository.findById(id)
				.orElseThrow(() -> new ToDoTaskNotFound("To-Do task with id-" + id + " not found"));

		toDoObj.setTitle(updatetoDoTask.getTitle());
		toDoObj.setDescription(updatetoDoTask.getDescription());
		toDoObj.setCompleted(updatetoDoTask.isCompleted());

		ToDoClass saveUpdatedToDo = toDoRepository.save(toDoObj);

		return ToDoMapper.mapToDoDto(saveUpdatedToDo);
	}

	@Override
	public void deleteToDoTask(long id) {

		ToDoClass toDoObj = toDoRepository.findById(id)
				.orElseThrow(() -> new ToDoTaskNotFound("To-Do task with id-" + id + " not found"));

		toDoRepository.deleteById(id);

	}

	@Override
	public ToDoDto getToDOTaskById(long id) {

		ToDoClass todoObj = toDoRepository.findById(id)
				.orElseThrow(() -> new ToDoTaskNotFound("To-Do task with id-" + id + " not found"));

		return ToDoMapper.mapToDoDto(todoObj);
	}

	@Override
	public ToDoDto completeTask(long id) {

		ToDoClass todoObj = toDoRepository.findById(id)
				.orElseThrow(() -> new ToDoTaskNotFound("To-Do task with id-" + id + " not found"));

		todoObj.setCompleted(true);
		ToDoClass saveUpdatedToDo = toDoRepository.save(todoObj);
		return ToDoMapper.mapToDoDto(saveUpdatedToDo);
	}

	@Override
	public ToDoDto incompleteTask(long id) {
		ToDoClass todoObj = toDoRepository.findById(id)
				.orElseThrow(() -> new ToDoTaskNotFound("To-Do task with id-" + id + " not found"));
		todoObj.setCompleted(false);
		ToDoClass saveUpdatedToDo = toDoRepository.save(todoObj);
		return ToDoMapper.mapToDoDto(saveUpdatedToDo);
	}

}
