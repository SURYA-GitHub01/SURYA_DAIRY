# Surya Virtual Diary

## Prerequisites

- **Docker Desktop:** Ensure Docker is installed and running.
- **Java 21 or higher:** For building and running the Spring Boot application.
- **Maven:** For building the project.

## How to Run the Application

1. **Start the Oracle Database (via Docker):**
   ```bash
   docker-compose up -d
   ```
   This will pull the Oracle XE image and start a container on port 1521.

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   java -jar target/surya-virtual-diary-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application:**
   Open your web browser and go to `http://localhost:7070`.

## Important Note for Developers

If you make changes to the frontend files (HTML, CSS, JavaScript), you may need to do the following to see the changes:

1.  **Stop and restart the application:**  Use `Ctrl+C` in the terminal where the application is running, and then run the `java -jar` command again.
2.  **Hard Refresh your browser:**
    *   **Chrome/Firefox/Edge on Windows/Linux:** `Ctrl + Shift + R` or `Ctrl + F5`
    *   **Chrome/Firefox/Edge on Mac:** `Cmd + Shift + R`
    *   **Safari on Mac:** `Cmd + Option + R`

This will ensure that you are seeing the latest version of the files.