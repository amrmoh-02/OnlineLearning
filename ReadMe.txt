- implement an online learning application using EJBs with 2 microservices, 1st handles courses(CreateCourse), 2nd review courses(review).
- Your interface should is a web-based interface using HTML simulate a functioning online learning platform with different users.
- service is exposed as REST APIs, and beans are exposed using REST to fulfill the web service REST API as appropriate.
- separate UI that calls the APIs exposed by services.
- there's 3 separate DBs
(You need internet connection to run the app)
1st run app and two microservices :
Online Learning       	Ports auto set to:  	        8093		
CreateCourse   						8094
Review       						8096
Startup URL: http://localhost:8093/login.html
Login Credentials:
Admin:    	 	admin1     	pass: password
Student:   		newstudent 	pass: password
Instructor:   	        instructor1    	pass: password
Some Notes:
Singleton Bean: Spring Boot itself manages beans as singletons by default, annotation used one of its stereotypes (@Repository)

Stateless Components: In Spring, most components are naturally stateless by design, annotations used to indicate it (@RestController)

If UI didn't work in any scenarios, you can use post man to test required functionality like:

POST: http://localhost:8093/student/newstudent/enroll
raw body JSON:

{
    "courseName": "Data Structures"
}

- Functionalities:
- Admins in the system should have the following abilities:
1. View and manage user accounts, including students and instructors.
2. Review course content before it's published to ensure quality and compliance with
platform guidelines.
3. Have the authority to edit or remove courses that violate policies or are deemed
inappropriate.
4. Track platform usage by students and instructors, check the courses popularity, ratings,
reviews, ... etc.
- As an instructor, you should be able to:
1. Register and login into the system. Registration should collect information like name,
email, password, affiliation, years of experience, and bio.
2. Create courses, where each course has a name, duration, category, rating, capacity,
number of enrolled students, and list of reviews.
3. View detailed information about each course and search courses by name, category or
sort by ratings.
4. Accept/Reject student enrollments.
- As a student, you should be able to:
1. Register and login into the system. Registration should collect information like name,
email, password, affiliation, and bio.
2. View current and past course enrollments.
3. View detailed information about each course and search courses by name, category or
sort by ratings.
4. Make or cancel course enrollment. Enrollments should be handled in a special way to
avoid situations of server failure.
5. Get notified for course enrollments updates
6. Make a review and rating for a course.
Key & non-duplication constraints apply where it makes sense. Also, you should be handling
case sensitivity while searching for courses. 