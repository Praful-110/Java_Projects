# 🎓 STUDENT_ADMIN_PORTAL 

A Java-based dynamic web application for managing student records — built using Servlets, JSP, and a layered architecture (MVC pattern).

---

## 🚀 Key Features

- 🧱 **Modular Architecture** — Follows MVC with clear separation of concerns  
- 🌐 **Servlet-Based Routing** — Handles request/response lifecycle with precision  
- 💾 **MySQL + JDBC Integration** — Robust data access via DAO pattern  
- 🔄 **CRUD Operations** — Create, Read, Update, Delete student data  
- 🏗️ **Factory Pattern** — Decoupled object creation using Factory classes  
- 📦 **Deployable WAR File** — Easy deployment on Apache Tomcat  
- 🎨 **Responsive UI** — JSP-based frontend with Bootstrap for styling

---

# graph TD
    HTMLForm[add.html / index.html] -->|Submits Form| ServletController;

    ServletController -->|Creates Entity| Student;
    ServletController -->|Calls Service| StudentService;

    StudentService -->|Calls DAO Interface| StudentDao;
    StudentDao -->|Implemented By| StudentDaoImpl;

    StudentDaoImpl -->|Uses| ConnectionFactory;
    ConnectionFactory -->|Connects to| Database;

    Database -->|Returns Result| StudentDaoImpl;
    StudentDaoImpl -->|Returns Status/Data| StudentService;
    StudentService -->|Returns to| ServletController;

    ServletController -->|Forwards to| display.jsp;
    ServletController -->|On Error| failed.html;
    
---

🔹 Project Structure
---
# Root Directory:

Web_project_02/

├── .classpath                 # Eclipse classpath file
├── .project                   # Eclipse project metadata
├── .gitignore                 # Git ignored files
├── README.md                  # Project overview (if available)


├── src/                       # Java source code

│   ├── UserDao/

│   │   ├── UserDao.java

│   │   └── UserDaoImpl.java

│   ├── UserFactory/

│   │   ├── ConnectionFactory.java

│   │   ├── DaoFactory.java

│   │   └── ServiceFactory.java
│   ├── UserService/

│   │   ├── UserService.java

│   │   └── UserServiceImpl.java

│   ├── softronix/

│   │   └── in/

│   │       └── UserController.java

│   └── entity/

│       └── User.java


├── bin/                       # Compiled class files

│   ├── UserDao/

│   ├── UserFactory/

│   ├── UserService/

│   ├── softronix/

│   │   └── in/

│   └── entity/


├── webapp/                    # Frontend (Java EE style)

│   ├── index.html

│   ├── add.html

│   ├── display.html

│   ├── empty.html

│   ├── failed.html

│   ├── display.jsp

│   ├── style.css

│   └── script.js

---



# Output


# <img width="952" alt="image" src="https://github.com/user-attachments/assets/0e6441e6-38f1-425d-92a9-dfea0f797d3d" width="400" height="400" />


# <img width="956" alt="image" src="https://github.com/user-attachments/assets/f17d9c1c-8c34-4668-9e92-55de69f990fd" width="400" height="400" />


# <img width="959" alt="image" src="https://github.com/user-attachments/assets/e7716042-bb80-43ab-bbf4-f2681e709deb" width="400" height="400" />







