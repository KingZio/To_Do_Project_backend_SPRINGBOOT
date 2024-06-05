package org.hansei.toomanydo.controller;

import lombok.RequiredArgsConstructor;
import org.hansei.toomanydo.dto.TodoRequest;
import org.hansei.toomanydo.entity.Todo_entity;
import org.hansei.toomanydo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    @PostMapping("/api/post-data")
    public ResponseEntity<String> receiveTodoData(@RequestBody TodoRequest todoData) {
        // todoData 객체를 사용하여 필요한 작업 수행
        System.out.println("할일: " + todoData.getTodo());
        System.out.println("기한: " + todoData.getDeadline());
        System.out.println("작성자: " + todoData.getName());

        if(todoData.getTodo().length() > 0){
            if (todoData.getDeadline().length() > 0){
                if(todoData.getName() != null) {
                    Todo_entity todoEntity = new Todo_entity();
                    todoEntity.setTodo(todoData.getTodo());
                    todoEntity.setDeadline(todoData.getDeadline());
                    todoEntity.setUsername(todoData.getName());
                    todoRepository.save(todoEntity);
                    return ResponseEntity.ok("데이터 처리 완료.");
                }
            }
        }
        return ResponseEntity.ok("데이터가 처리 실패");
    }

    @GetMapping("/api/get-data")
    public HashMap getTodoData(@RequestParam String username) {
        HashMap hashMap = new HashMap();
        List<Todo_entity> result = todoRepository.findAllByUsername(username);
        for(Integer i = 0; i < result.size(); i++){
            hashMap.put(i, result.get(i));
        }
        return hashMap;
    }

    @DeleteMapping("/api/delete-data")
    public ResponseEntity<String> deleteTodoData(@RequestParam Long id) {
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return ResponseEntity.ok("삭제완료");
        }
        return ResponseEntity.ok("삭제 실패");
    }
}
