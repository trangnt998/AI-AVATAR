# Selenium Appium TestNG sample for AI AVATAR
## Introduction

This project is built for automated mobile application testing using Selenium, Appium, and TestNG.

- **Selenium Appium TestNG**: Used for mobile app testing
- **Maven**: Dependency management and project build tool

## Technologies Used

- Java
- Selenium
- Appium
- TestNG
- Maven

## Required Environment

### System Requirements

- **Operating System**: Windows
- **Java**: Version 11 or later (Check with `java -version`)
- **Maven**: Version 3.6+ (Check with `mvn -version`)
- **Android SDK**: Installed and configured
- **Appium Server**: Installed and running (Check with `appium -v`)
- **Android Emulator or Physical Device**: Running and connected
- **Environment Variables**:
  - `JAVA_HOME`: Points to the Java installation directory
  - `ANDROID_HOME`: Points to the Android SDK directory
  - `PATH`: Ensure `JAVA_HOME/bin` and `ANDROID_HOME/platform-tools` are included

## Installation and Running Tests

### How to Run Tests

1. **Clone the repository**

```sh
git clone https://github.com/trangnt998/AI-AVATAR.git

```

2. **Start Appium Server**

```sh
appium
```

3. **Start Android Emulator or Connect a Physical Device**
   - If using an emulator, start it from Android Studio or using the command:
   
   ```sh
   emulator -avd <your_emulator_name>
   ```
   - If using a physical device, ensure USB debugging is enabled and check device connection:
   
   ```sh
   adb devices
   ```

4. **Run Mobile App Tests**

```sh
mvn clean verify
```

5. **View Test Report**
After running the tests, the test report can be accessed from:

```sh
target/surefire-reports/index.html
```

## Project Structure

```
AI-AVATAR-MobileApp/
├── src/
│   ├── test/java/
│   │   ├── bases/         
│   │   ├── pages/         
│   │   ├── steps/         
│   │   ├── tests/         
│   │   ├── utils/         
│   ├── test/resources/  
│   │   ├── testsuites/         
├── target/               # Compiled output and test reports
├── pom.xml               # Maven configuration file
├── README.md             # Documentation
```

