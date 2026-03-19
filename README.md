# Factorial App Testing & Automation

## Overview

This project contains manual and automated testing for a factorial web application:

http://qainterview.pythonanywhere.com

The objective was to perform exploratory testing, identify defects, document test cases, and implement automated tests aligned with those findings.

---

## Scope

The testing covered the following areas:

- Input validation and error handling
- Boundary value and large number behaviour
- UI/UX behaviour and feedback
- Navigation and link validation
- API and network behaviour

---

## Tech Stack

- Java
- Playwright
- TestNG

---

## Project Structure



---

## Test Approach

### Manual Testing

Exploratory testing was conducted using structured charters focusing on:

- Input validation
- Boundary analysis
- System limits
- User experience
- Navigation behaviour

Key issues identified include:

- Missing backend validation (negative inputs causing server errors)
- Lack of upper bound constraints
- Misleading results for overflow cases ("Infinity")
- Inconsistent handling of large inputs
- Incomplete navigation content

---

### Automated Testing

Automated tests were implemented using Playwright with a Page Object Model design.

Test coverage includes:

- Valid factorial calculations
- Boundary values (0, 1, 170, 171, 992)
- Input validation (empty, decimal, negative)
- UI behaviour and validation feedback
- Navigation links
- API request verification

---

## Key Test Scenarios

### Functional
- Verify correct factorial calculation for valid inputs
- Validate behaviour at boundary values
- Confirm system response to invalid inputs

### Validation
- Empty input
- Decimal input
- Negative input
- Non-numeric input

### Edge Cases
- Overflow handling (171+)
- System stability (large inputs such as 992+)

### Navigation
- About page
- Terms and Conditions
- Privacy page

### API
- API request triggered for valid input
- No unnecessary API calls for invalid input
- Correct request method and structure

---

## How to Run the Tests

### Prerequisites

- Java 17+
- Maven

---

### Install dependencies

```bash
mvn clean install

```

### Run Tests
```bash
mvn test

```


---

## Notes
* The application does not enforce strict input constraints, which leads to inconsistent behaviour across different input ranges. 
* Several defects identified during manual testing are intentionally reflected in failing automated tests. 
* The framework is designed to be easily extendable for additional scenarios.


---

## Author
Percival Gebashe

---
