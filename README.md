# 🎓 Student Management System (Spring Boot)

A backend REST API for managing student records, built using Spring Boot.  
This project demonstrates clean architecture using DTO, validation, and global exception handling.

---

## 🚀 Features

- Create student (POST)
- Get all students (GET)
- Get student by ID (GET)
- Update student (PUT)
- Partial update (PATCH)
- Delete student (DELETE)
- Input validation using `@Valid`
- Global exception handling
- DTO-based architecture (Request & Response separation)
- Data normalization (uppercase for branch and section)

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 📁 Project Structure

```text
src/main/java/com/sms/studentmanagement/

├── controller        # Handles API requests
├── services          # Business logic
├── repository        # Database access
├── entity            # Database models
├── dto               # Request & Response objects
├── exception         # Global exception handling

src/main/resources/

├── application.properties
```

---

## 🧠 Architecture

Controller → Service → Repository → Database  

DTO layer is used to separate API request/response from database entities.

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|-------|--------|------------|
| POST | `/students` | Create student |
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| PUT | `/students/{id}` | Update full student |
| PATCH | `/students/{id}` | Partial update |
| DELETE | `/students/{id}` | Delete student |

---

## 📥 Sample Request (POST)

```json
{
  "rollNumber": "23A81A0000",
  "firstName": "Rohith",
  "lastName": "Kumar",
  "email": "rohith@gmail.com",
  "phone": "9876543210",
  "branch": "cse",
  "section": "a",
  "academicYear": 3,
  "dateOfBirth": "2003-05-12",
  "gender": "Male",
  "address": "Andhra Pradesh"
}
```
## 📤 Sample Response

```json
{
  "id": 1,
  "rollNumber": "23A81A0000",
  "firstName": "Rohith",
  "branch": "CSE",
  "section": "A"
}
```

## ⚠️ Error Handling

Example:
```json
{
  "message": "Phone number must be 10 digits",
  "status": 400,
  "timestamp": "2026-04-25T..."
}
```

---

## ▶️ How to Run
1. Clone repository:
    git clone https://github.com/saroja810/student-management-system.git
2. Open project in IDE (VS Code / IntelliJ)
3. Run application
4. Access API:
    http://localhost:8080/students
5. Open H2 Console:
    http://localhost:8080/h2-console

## 🔮 Future Enhancements
    - 🔐 JWT Authentication (Login & Role-based access)
    - 🗄️ MySQL/PostgreSQL integration (persistent database)
    - 📊 Attendance management module
    - 📈 Marks/Results module
    - 👨‍🏫 Faculty management
    - 📱 Frontend integration (React)
    - 🤖 AI-based student performance insights

## 👨‍💻 Author

Saroja  
B.Tech Computer Science Student  
Developed as part of backend learning using Spring Boot.