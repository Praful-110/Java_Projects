# 🎓 Student Management Web App

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

graph TD
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
Root Directory:

• Web_project_01/

---

• my-java-project/
   - .classpath  
   - .project  

   • .settings/
      - org.eclipse.core.resources.prefs  
      - org.eclipse.jdt.core.prefs  

   • bin/ (Compiled Classes)
      • UserDao/
         - UserDao.class  
         - UserDaoImpl.class  
      • UserFactory/
         - ConnectionFactory.class  
         - DaoFactory.class  
         - ServiceFactory.class  
      • UserService/
         - UserService.class  
         - UserServiceImpl.class  
      - module-info.class  
      • softronix/
         • in/
            - UserController.class  
            • entity/
               - User.class  

   • src/ (Source Code)
      • UserDao/
         - UserDao.java  
         - UserDaoImpl.java  
      • UserFactory/
         - ConnectionFactory.java  
         - DaoFactory.java  
         - ServiceFactory.java  
      • UserService/
         - UserService.java  
         - UserServiceImpl.java  
      - module-info.java  
      • softronix/
         • in/
            - UserController.java  
            • entity/
               - User.java  

   • webapp/ (Frontend Files)
      - index.html  
      - add.html  
      - display.html  
      - empty.html  
      - failed.html  
      - style.css  
      - script.js  
      - display.jsp  

---


