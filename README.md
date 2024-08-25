# SSM Project

## Overview
This project is a full-stack web application built using Spring Framework (Spring MVC) for the backend and Vue.js for the frontend. The application follows a typical Model-View-Controller ) architecture and employs RESTful principles for API development. 

## Prerequisites
To run this project, you will need to have the following installed:
- **Java 11 or higher**
- **Maven 3.6+**
- **Node.js and npm**
- **Spring MVC**
- **MyBatis**
- **Redis**
- **Vue 3**
- **MySQL 8.0.38 **

## Project Structure
- **ssm-backend/**: Contains the backend code based on Spring Boot.
  - `src/main/java`: Java source files for controllers, services, repositories, and models.
  - `src/main/resources`: Configuration files, such as `pom.xml` or `application.yml`.
- **ssm-ui/**: Contains the frontend code based on Vue.js.
  - `src/`: Vue.js components, views, and other frontend assets.
  - `public/`: Static assets such as images and fonts.

## Setup Instructions

### Backend Setup
1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd ssm-backend
   ```

2. **Configure the database**:
   - Update the `jdbc.properties` file with your database credentials.
   - Example:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your-database
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     ```



   The backend will start on `http://localhost:8088`.


### Frontend Setup
1. **Navigate to the frontend directory**:
   ```bash
   cd ssm-ui
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Run the development server**:
   ```bash
   npm run serve
   ```

   The frontend will be available on `http://localhost:8080`.

### Running the Project
After starting both the backend and frontend servers, you can access the application by navigating to `http://localhost:8080` in your web browser. The frontend will communicate with the backend APIs via HTTP requests.

## License
This project is licensed under the MIT License.

## Contact
For any questions or issues, please reach out to lexiinventinglife@gmail.com.

