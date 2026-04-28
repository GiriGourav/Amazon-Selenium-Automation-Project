# Amazon Selenium Automation Project

This project is a simple **Selenium + TestNG automation framework** written in Java that performs product search, price extraction, and add-to-cart validation on Amazon India.

---

## 📌 Features

* Open Amazon India website
* Search for products (iPhone, Samsung Galaxy, MacBook, etc.)
* Extract product price
* Try adding product to cart
* Handle basic CAPTCHA detection
* Uses TestNG for test execution

---

## 🛠️ Tech Stack

* Java 21
* Selenium WebDriver 4.43.0
* TestNG 7.12.0
* Maven
* WebDriverManager

---

## 📁 Project Structure

```
amazonautomation
│── src
│   └── test
│       └── java
│           └── tests
│               └── AmazonTest.java
│── pom.xml
│── testng.xml
│── mvnw / mvnw.cmd
```

---

## 🚀 How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/GiriGourav/automated-testing.git
cd automated-testing
```

---

### 2️⃣ Install dependencies

Make sure you have:

* Java 21 installed
* Maven installed

Check versions:

```bash
java -version
mvn -version
```

---

### 3️⃣ Run tests using Maven

```bash
mvn clean test
```

---

### 4️⃣ Run tests using TestNG (IntelliJ IDEA)

1. Open project in IntelliJ IDEA
2. Go to `testng.xml`
3. Right-click → Run

---

## 🧪 Test Cases Included

* iPhone search test
* Samsung Galaxy search test

---

## ⚠️ Common Issues

### 1. Add to Cart unavailable

Amazon often disables Add-to-Cart for:

* Sponsored products
* Out of stock items
* Region restrictions

---

### 2. CAPTCHA error

Amazon may block automation with CAPTCHA.

Solution:

* Reduce request frequency
* Use headless=false mode
* Run manually sometimes

---

### 3. NoSuchElementException

Selectors may break due to Amazon UI changes.

Fix:

* Update CSS/XPath selectors
* Use explicit waits

---

## 📌 Author

Gourav Giri
