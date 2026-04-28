````markdown
# Amazon Selenium Automation Project

This project is a Selenium + TestNG automation framework built with Java that performs product search, price extraction, and add-to-cart validation on Amazon India.

It automates real-world eCommerce scenarios and can run locally or on cloud platforms like LambdaTest.

---

## 📌 Features

✅ Open Amazon India website  
✅ Search products like iPhone, Samsung Galaxy, Wireless Mouse, etc.  
✅ Extract product price  
✅ Attempt Add to Cart  
✅ Handle basic CAPTCHA detection  
✅ Execute tests using TestNG  
✅ Supports cloud execution using LambdaTest  

---

## 🛠️ Tech Stack

| Technology | Version |
|-----------|---------|
| Java | 21 |
| Selenium WebDriver | 4.43.0 |
| TestNG | 7.12.0 |
| Maven | Latest |
| WebDriverManager | Latest |

---

## 📁 Project Structure

```text
amazonautomation/
│── src/
│   └── test/
│       └── java/
│           └── tests/
│               └── AmazonTest.java
│── pom.xml
│── testng.xml
│── mvnw
│── mvnw.cmd
│── README.md
````

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/GiriGourav/automated-testing.git
cd automated-testing
```

---

### 2️⃣ Install Dependencies

Make sure the following are installed:

* Java 21
* Maven

Check installed versions:

```bash
java -version
mvn -version
```

---

### 3️⃣ Run Tests Using Maven

```bash
mvn clean test
```

---

### 4️⃣ Run Tests Using TestNG (IntelliJ IDEA)

* Open project in IntelliJ IDEA
* Locate `testng.xml`
* Right Click → **Run**

---

## 🧪 Test Cases Included

| Test Name         | Product        |
| ----------------- | -------------- |
| iphoneTest        | iPhone         |
| galaxyTest        | Samsung Galaxy |
| wirelessMouseTest | Wireless Mouse |

---

## ✅ Sample Output

```text
iphone Price: ₹1,34,900
iphone Add to cart unavailable

Samsung Galaxy Price: ₹1,30,999
Samsung Galaxy Add to cart unavailable

wireless Mouse Price: ₹399
wireless Mouse added to cart

Total tests run: 3
Passes: 3
Failures: 0
```

---

## ⚠️ Common Issues

### 1️⃣ Add to Cart Unavailable

Amazon may disable Add to Cart for:

* Sponsored products
* Out of stock items
* Region restricted products

### 2️⃣ CAPTCHA Error

Amazon may detect automation traffic.

### Solution:

* Reduce repeated executions
* Add delays
* Use cloud execution (LambdaTest)
* Run tests less aggressively

### 3️⃣ NoSuchElementException

Amazon frequently updates UI selectors.

### Solution:

* Update CSS/XPath selectors
* Use explicit waits
* Improve locator strategy

---

## 📌 Future Enhancements

* Page Object Model (POM)
* Screenshot on Failure
* Extent Reports
* Parallel Execution
* Jenkins CI/CD Integration
* Data Driven Testing

---

## 👨‍💻 Author

**Gourav Giri**

GitHub: [https://github.com/GiriGourav](https://github.com/GiriGourav)

---

## ⭐ Bonus Achievement

Successfully executed Selenium TestNG tests on **LambdaTest Cloud Grid**

---

```
```
