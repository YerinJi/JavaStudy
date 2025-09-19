package com.multi.springboot.controller;

import com.multi.springboot.model.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    // 데모용 in-memory 목록
    private final List<UserDTO> users = new ArrayList<>(Arrays.asList(
            new UserDTO(1, "Alice", "alice@example.com"),
            new UserDTO(2, "Bob", "bob@example.com"),
            new UserDTO(3, "Charlie", "charlie@example.com")
    ));

    // GET /api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    // GET /api/user (단일 JSON)
    @GetMapping("/user")
    public UserDTO user() {
        return new UserDTO(100, "John Doe", "john@example.com");
    }

    // GET /api/greet/{name}
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // GET /api/sum?a=10&b=20
    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // POST /api/create
    @PostMapping(value = "/create", consumes = "application/json")
    public String create(@RequestBody Map<String, Object> body) {
        String name = body.get("name") != null ? body.get("name").toString() : "noname";
        String email = body.get("email") != null ? body.get("email").toString() : (name.toLowerCase() + "@example.com");

        // stream 없이 max id 찾기
        int maxId = 0;
        for (UserDTO u : users) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }

        int newId = maxId + 1;
        users.add(new UserDTO(newId, name, email));
        return "Created user id=" + newId + ", name=" + name;
    }

    // PUT /api/update/{id}
    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public String update(@PathVariable int id, @RequestBody Map<String, Object> body) {
        String name = body.get("name") != null ? body.get("name").toString() : null;
        String email = body.get("email") != null ? body.get("email").toString() : null;

        UserDTO target = null;
        for (UserDTO u : users) {
            if (u.getId() == id) {
                target = u;
                break;
            }
        }

        if (target == null) {
            return "No user found for id=" + id;
        }

        if (name != null) target.setName(name);
        if (email != null) target.setEmail(email);

        return "Updated user id=" + id;
    }

    // DELETE /api/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        boolean removed = false;

        for (int i = 0; i < users.size(); i++) {
            UserDTO u = users.get(i);
            if (u.getId() == id) {
                users.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            return "Deleted user id=" + id;
        } else {
            return "No user found for id=" + id;
        }
    }

    // GET /api/users (리스트 JSON)
    @GetMapping("/users")
    public List<UserDTO> listUsers() {
        return users;
    }

    // GET /api/status (ResponseEntity 데모)
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Demo-Header", "demo");
        return new ResponseEntity<>("OK", headers, HttpStatus.OK);
    }

    // GET /api/error (에러 핸들링 데모)
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("의도적으로 발생시킨 오류입니다.");
    }

    // 컨트롤러 내부 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
